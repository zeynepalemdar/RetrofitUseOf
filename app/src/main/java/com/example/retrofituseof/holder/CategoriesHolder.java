package com.example.retrofituseof.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofituseof.databinding.CategoriesAdapterBinding;

public class CategoriesHolder extends RecyclerView.ViewHolder {
    private CategoriesAdapterBinding binding;

    public CategoriesHolder(@NonNull CategoriesAdapterBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public  CategoriesAdapterBinding getBinding() { return binding; }

    public void setBinding(CategoriesAdapterBinding binding) {
        this.binding = binding;//minik kusa bunuda sor
    }
}

