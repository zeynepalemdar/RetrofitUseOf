package com.example.retrofituseof.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesResourceInterface {
    @GET("/products/categories")
    Call<List<String>> getALLCategories();
}
