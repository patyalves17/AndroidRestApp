package com.fiap.patyalves.androidrestapp.api;


import com.fiap.patyalves.androidrestapp.modelo.ResponseAndroid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidAPI {
//http://www.mocky.io/v2/58af1fb21000001e1cc94547

    @GET("/v2/58af1fb21000001e1cc94547")
    Call<ResponseAndroid>getVersoes();
}
