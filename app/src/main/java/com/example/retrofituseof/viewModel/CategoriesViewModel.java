package com.example.retrofituseof.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.retrofituseof.repository.CategoriesRepository;

import java.util.List;

public class CategoriesViewModel extends AndroidViewModel {
    private CategoriesRepository categoriesRepository;
    private LiveData<List<String>> categoriesLiveData;

    public CategoriesViewModel(@NonNull Application application) {
        super(application);
        categoriesRepository = new CategoriesRepository(application);
        this.categoriesLiveData = categoriesRepository.categoriesResponse();
    }

    public LiveData<List<String>> getCategoriesLiveData(){return categoriesLiveData;}
}
