package com.experiencers.playeasy.view.main.fragment.home;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.myViewHolder> implements HomeContract.adapterView, HomeContract.adapterModel  {

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void add() {

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
