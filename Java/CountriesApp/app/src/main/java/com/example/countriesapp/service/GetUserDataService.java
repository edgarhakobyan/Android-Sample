package com.example.countriesapp.service;

import com.example.countriesapp.model.Info;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUserDataService {
    @GET("users")
    Call<ArrayList<Info>> getResults();
}
