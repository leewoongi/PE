package com.experiencers.playeasy.view.main.fragment.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.detailmatch.DetailMatchActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.myViewHolder> implements HomeContract.adapterView, HomeContract.adapterModel  {

    private List<Match> item = new ArrayList<>();
    private int matchId;

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.matchTime.setText(item.get(position).getStartAt());
        holder.matchPlace.setText(item.get(position).getLocation().getDetail());
        holder.matchType.setText(item.get(position).getType());
        holder.matchStatus.setText(item.get(position).getStatus());
        matchId = (item.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override
    public void add(Object object) {
        item = (List<Match>) object;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView matchTime;
        private TextView matchPlace;
        private TextView matchType;
        private TextView matchStatus;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            matchTime = itemView.findViewById(R.id.matchTime);
            matchPlace = itemView.findViewById(R.id.matchPlace);
            matchType = itemView.findViewById(R.id.matchType);
            matchStatus = itemView.findViewById(R.id.matchStatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailMatchActivity.class);
                    intent.getIntExtra("matchId", matchId);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
