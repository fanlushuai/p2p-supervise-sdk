package com.open.sdk.config;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;
import java.io.StringReader;

@Slf4j
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;

    private final TypeAdapter<T> adapter;

    private final CNCRTEnv cncrtEnv;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, CNCRTEnv cncrtEnv) {
        this.gson = gson;
        this.adapter = adapter;
        this.cncrtEnv = cncrtEnv;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String responseStr = value.string();
        //原始报文相应内容 写入日志方便查询
        log.info("CNCRT => P2P [{}]: {}", cncrtEnv, responseStr);
        JsonReader jsonReader = gson.newJsonReader(new StringReader(responseStr));
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
