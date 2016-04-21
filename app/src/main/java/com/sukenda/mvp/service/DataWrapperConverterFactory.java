package com.sukenda.mvp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by krissadewo on 05/01/16.
 */
public class DataWrapperConverterFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, Object> fromResponseBody(final Type type, Annotation[] annotations) {
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody responseBody) throws IOException {
                return new GsonBuilder()
                        .registerTypeAdapter(type, new DataWrapperDeserializer())
                        .create()
                        .fromJson(responseBody.string(), type);
            }
        };
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(final Type type, Annotation[] annotations) {
        return new Converter<Object, RequestBody>() {
            @Override
            public RequestBody convert(Object value) throws IOException {
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(value, type);
                return RequestBody.create(MediaType.parse("application/json"), json);
            }
        };
    }
}
