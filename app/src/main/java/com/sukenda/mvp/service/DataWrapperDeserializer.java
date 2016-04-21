package com.sukenda.mvp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by krissadewo on 05/01/16.
 */
public class DataWrapperDeserializer implements JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new GsonBuilder().create();
        JsonElement jsonElement = json.getAsJsonObject().get("data");
        JsonElement elementSolr = json.getAsJsonObject().get("response");

        if (jsonElement != null) {
            return gson.fromJson(jsonElement, typeOfT);
        }

        if (elementSolr != null) {
            /*JsonElement docsElement = elementSolr.getAsJsonObject().get("docs");*/
            return gson.fromJson(elementSolr, typeOfT);
        }

        return gson.fromJson(json, typeOfT);
    }
}
