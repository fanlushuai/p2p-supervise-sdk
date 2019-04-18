package com.open.sdk.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.open.sdk.util.Util;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * 1、根据原始报文里面的timestamp和nonce，自动生成apiKey且添加到报文里面
 * 2、根据环境变量配置，自动改变通用消息体，dataType参数的值,给 x-www-form-urlencoded 格式的post添加 参数
 * 3、根据环境变量配置,改变url格式
 */
@Slf4j
public class ApiKeyGenerateInterceptor implements Interceptor {

    private final static String KEY_API_KEY = "apiKey";

    private final static String KEY_MSG = "msg";

    private final static String KEY_DATA_TYPE = "dataType";

    private final static String KEY_NONCE = "nonce";

    private final static String KEY_TIMESTAMP = "timestamp";

    private final static String URL_KEY_CNCRT_ENV = "CNCRTEnvConfig";

    private final static String URL_DEV_ENV_SUFFIX = "test";

    private ConfigStorage configStorage;

    public ApiKeyGenerateInterceptor(ConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    /**
     * url后缀不同，环境不同
     * 测试环境url加了test。线上环境没有
     */
    private HttpUrl solveEnvOfUrl(Request request) {
        List<String> pathSegments = request.url().pathSegments();

        int envConfigIndex = 0;

        for (int i = 0; i < pathSegments.size(); i++) {
            String pathSegment = pathSegments.get(i);
            if (URL_KEY_CNCRT_ENV.equals(pathSegment)) {
                envConfigIndex = i;
                break;
            }
        }

        if (CNCRTEnv.ONLINE_PRODUCT.equals(configStorage.getCncrtEnv()) || CNCRTEnv.ONLINE_TEST.equals(configStorage.getCncrtEnv())) {
            //移除占位符，就是生产环境的url
            return request.url().newBuilder().removePathSegment(envConfigIndex).build();
        } else {
            //替换占位符。就是测试环境的url
            return request.url().newBuilder().setEncodedPathSegment(envConfigIndex, URL_DEV_ENV_SUFFIX).build();
        }

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (!canInjectIntoBody(request)) {
            return chain.proceed(request);
        }

        String postBodyString = bodyToString(request.body());

        String apiKeyGot = null;
        String[] paramKeyValueStrArray = postBodyString.split("&");
        boolean setGlobalEnv = false;
        for (int i = 0; i < paramKeyValueStrArray.length; i++) {
            String paramKeyValueStr = paramKeyValueStrArray[i];
            String[] keyValue = paramKeyValueStr.split("=");
            String key = keyValue[0];
            if (KEY_MSG.equals(key)) {
                //获取请求体里面的的msg json串
                String encodedValue = keyValue[1];
                String msgJson = URLDecoder.decode(encodedValue, "UTF-8");
                JsonObject msgJsonObject = new JsonParser().parse(msgJson).getAsJsonObject();

                //取json串中的时间戳和nonce进行apiKey生成
                apiKeyGot = Util.certToolV1.getApiKey(configStorage.getApiKey(), configStorage.getSourceCode(), configStorage.getVersion()
                        , msgJsonObject.get(KEY_TIMESTAMP).getAsLong(), msgJsonObject.get(KEY_NONCE).getAsString());

                if (msgJsonObject.get(KEY_DATA_TYPE) == null) {
                    //dataType的设置。在没有设置的情况下，设置全局的环境变量
                    msgJsonObject.addProperty(KEY_DATA_TYPE, configStorage.getDataType().getValue());
                    keyValue[1] = URLEncoder.encode(msgJsonObject.toString(), "UTF-8");
                    setGlobalEnv = true;
                    log.info("global env config {} add {} as dataType ", configStorage.getCncrtEnv(), configStorage.getDataType());
                } else {
                    log.warn("!!!! use self define config {} as dataType ", msgJsonObject.get(KEY_DATA_TYPE).getAsString());
                }
            }

            paramKeyValueStrArray[i] = keyValue[0] + "=" + keyValue[1];
        }

        if (setGlobalEnv) {
            //重新拼接请求体参数
            StringBuilder stringBuilder = new StringBuilder();
            for (String paramKeyValueStr : paramKeyValueStrArray) {
                stringBuilder.append(paramKeyValueStr);
            }
            postBodyString = stringBuilder.toString();
        }

        if (StringUtils.isEmpty(apiKeyGot)) {
            log.error("apiKey can not gen");
            return null;
        }

        RequestBody formBody = new FormBody.Builder().add(KEY_API_KEY, apiKeyGot).build();

        postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);

        log.info("P2P => CNCRT [{}]: apiKey {}  msg {} ", configStorage.getCncrtEnv(), apiKeyGot, URLDecoder.decode(postBodyString, "UTF-8"));

        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
        requestBuilder.url(solveEnvOfUrl(request));
        request = requestBuilder.build();
        return chain.proceed(request);
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final Buffer buffer = new Buffer();
            if (request != null) {
                request.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }

        if (!"POST".equals(request.method())) {
            return false;
        }

        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!"x-www-form-urlencoded".equals(mediaType.subtype())) {
            return false;
        }
        return true;
    }
}
