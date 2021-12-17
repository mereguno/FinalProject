package com.example.finalproject;

import android.util.Log;

import retrofit2.http.GET;
import retrofit2.Call;

public interface ApiService {
    @GET("/mereguno/json-holder/db")
    Call<DataList> getData();
}
