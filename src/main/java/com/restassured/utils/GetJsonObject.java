package com.restassured.utils;

import com.google.gson.Gson;

public class GetJsonObject {

    public static Object convertToJson(Object object){
        final Gson gson = new Gson();
        return gson.toJson(object);
    }

}
