/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.open.sdk.config;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * 自定义GsonConverterFactory 用来修改一些操作
 */
public final class GsonConverterFactory extends Converter.Factory {

    public static GsonConverterFactory create(CNCRTEnv cncrtEnv) {
        return new GsonConverterFactory(new Gson(), cncrtEnv);
    }

    private final Gson gson;

    private final CNCRTEnv cncrtEnv;

    private GsonConverterFactory(Gson gson, CNCRTEnv cncrtEnv) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }

        if (cncrtEnv == null) {
            throw new NullPointerException("cncrtEnv == null");
        }
        this.gson = gson;
        this.cncrtEnv = cncrtEnv;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new GsonResponseBodyConverter<>(gson, adapter, cncrtEnv);
    }


}
