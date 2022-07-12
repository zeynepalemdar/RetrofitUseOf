package com.example.retrofituseof.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofituseof.retrofit.CategoriesResourceInterface;
import com.example.retrofituseof.retrofit.ApiRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {
    private final CategoriesResourceInterface apiRequest;

    public CategoriesRepository(Application application) {

        this.apiRequest = ApiRetrofitClient.getClient().create(CategoriesResourceInterface.class);

    }

    public LiveData<List<String>> categoriesResponse(){
        final MutableLiveData<List<String>> data = new MutableLiveData<>();
        apiRequest.getALLCategories().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                System.out.println("ONRESPONSE"+response.code());
                if(response.body() != null){
                    data.setValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                System.out.println("ONFAILURE"+t.getMessage());
                data.setValue(null);
            }
        });

        return data;
    }

}
