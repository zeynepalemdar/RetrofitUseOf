package com.example.retrofituseof;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.retrofituseof.adapter.CategoriesAdapter;
import com.example.retrofituseof.databinding.ActivityMainBinding;
import com.example.retrofituseof.viewModel.CategoriesViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    CategoriesViewModel categoriesViewModel;
    CategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        getAllCategoriesList();
    }

    public void getAllCategoriesList(){
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        categoriesViewModel.getCategoriesLiveData().observe(this, categoryResponse ->{
            if(categoryResponse != null){
                LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                activityMainBinding.categoryRecycler.setLayoutManager(layoutManager);
                adapter = new CategoriesAdapter(this,categoryResponse);
                activityMainBinding.categoryRecycler.setAdapter(adapter);
            }
        });
    }
}