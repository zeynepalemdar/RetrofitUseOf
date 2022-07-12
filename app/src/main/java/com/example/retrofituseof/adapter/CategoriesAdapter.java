package com.example.retrofituseof.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofituseof.databinding.CategoriesAdapterBinding;
import com.example.retrofituseof.holder.CategoriesHolder;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesHolder> {
   private Context context;
   private List<String> categoryResources;


    public CategoriesAdapter(Context context, List<String> categoryResources) {
        this.context = context;
        this.categoryResources = categoryResources;
    }

    public void setData(List<String> categoryResources){
        this.categoryResources = categoryResources;
        notifyDataSetChanged();//yenı veri setlememize olanak sglar
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       CategoriesAdapterBinding categoriesAdapterBinding = CategoriesAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new CategoriesHolder(categoriesAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        String category = categoryResources.get(position);
        holder.getBinding().textView.setText(category);//xml e setledim
    }

    @Override
    public int getItemCount() {
        return categoryResources.size();
    }
}
