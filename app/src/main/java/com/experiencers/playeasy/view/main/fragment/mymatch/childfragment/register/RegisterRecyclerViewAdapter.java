package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;

public class RegisterRecyclerViewAdapter extends RecyclerView.Adapter<RegisterRecyclerViewAdapter.myViewHolder> implements RegisterContract.adapterView, RegisterContract.adapterModel{


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mymatch_register_item, parent, false);
        return new myViewHolder(view);
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
        private TextView registerMatchTime;
        private TextView registerMatchPlace;
        private TextView registerMatchStatus;
        private TextView registerMatchContinue;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            registerMatchTime = itemView.findViewById(R.id.registerMatchTime);
            registerMatchPlace = itemView.findViewById(R.id.registerMatchPlace);
            registerMatchStatus = itemView.findViewById(R.id.registerMatchStatus);
            registerMatchContinue = itemView.findViewById(R.id.registerMatchContinue);

        }
    }
}
