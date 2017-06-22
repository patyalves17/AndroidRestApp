package com.fiap.patyalves.androidrestapp.api;


public class APIUtils {

    public static final String BASE_URL="http://www.mocky.io";

    public static AndroidAPI getAndroidAPIVersion(){
        return RetrofitClient.getClient(BASE_URL).create(AndroidAPI.class);
    }

}
