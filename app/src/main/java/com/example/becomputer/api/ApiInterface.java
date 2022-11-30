package com.example.becomputer.api;

import com.example.becomputer.response.FoodResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/food")
    Call <FoodResponse> getFood();
}
