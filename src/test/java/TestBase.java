import com.open.sdk.api.ReconciliationService;
import com.open.sdk.api.UploadService;
import com.open.sdk.config.ApiKeyGenerateInterceptor;
import com.open.sdk.config.CNCRTEnv;
import com.open.sdk.config.ConfigStorage;
import com.open.sdk.config.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Before;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class TestBase {

    UploadService uploadService;

    ReconciliationService reconciliationService;

    /**
     * //todo 填自己公司的
     */

    private String apiKey = "";

    /**
     * //todo 填自己公司的
     */
    private String sourceCode = "";

    private String host = "https://api.ifcert.org.cn/";

    private String version = "1.5";


    

    /**
     * 所有的配置就这一个类
     */
    public ConfigStorage configStorage = ConfigStorage.builder().apiKey(apiKey)
            .cncrtEnv(CNCRTEnv.TEST).host(host).sourceCode(sourceCode).version(version).build();

    /**
     * 如下设置，集成到spring里面就ok了
     */
    @Before
    public void before() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(60, TimeUnit.SECONDS) //链接超时
                .writeTimeout(60, TimeUnit.SECONDS)   //写超时
                .readTimeout(60, TimeUnit.SECONDS)    //响应超时
                .retryOnConnectionFailure(false);     //取消重试

        builder.addInterceptor(new ApiKeyGenerateInterceptor(configStorage));

        if (!configStorage.getCncrtEnv().equals(CNCRTEnv.ONLINE_PRODUCT)) {
            //非线上正式环境都打印http日志
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configStorage.getHost())
                .addConverterFactory(GsonConverterFactory.create(configStorage.getCncrtEnv()))
                .client(client)
                .build();

        uploadService = retrofit.create(UploadService.class);
        reconciliationService = retrofit.create(ReconciliationService.class);

    }


}
