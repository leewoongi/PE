package com.experiencers.playeasy.view.main.fragment.home;

import android.content.Intent;
import android.graphics.Color;
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

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.matchDate.setText(item.get(position).getStartAt().substring(0,10));
        holder.matchTime.setText(item.get(position).getStartAt().substring(12,16) + " ~ "+ item.get(position).getEndAt().substring(12,16));
        holder.matchPlace.setText(item.get(position).getLocation().getPlaceName() + " " +item.get(position).getLocation().getPlaceDetail());

        if(item.get(position).getType().equals("FUTSAL5")){
            holder.matchType.setText("풋살 5 : 5");
        }else if(item.get(position).getType().equals("FUTSAL6")){
            holder.matchType.setText("풋살 6 : 6");
        }else{
            holder.matchType.setText("축구 11 : 11");
        }

        String status = "";
        if(item.get(position).getStatus().equals("WAITING")) {
            holder.matchStatus.setText("신청 가능");
            holder.matchStatus.setTextColor(Color.parseColor("#7ce155"));
        }else{
            holder.matchStatus.setText("신청 마감");
            holder.matchStatus.setTextColor(Color.parseColor("#d1d1d1"));
        }
        holder.matchId.setText(String.valueOf(item.get(position).getId()));
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
        private TextView matchDate;
        private TextView matchTime;
        private TextView matchPlace;
        private TextView matchType;
        private TextView matchStatus;
        private TextView matchId;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            matchDate = itemView.findViewById(R.id.matchDate);
            matchTime = itemView.findViewById(R.id.matchTime);
            matchPlace = itemView.findViewById(R.id.matchPlace);
            matchType = itemView.findViewById(R.id.matchType);
            matchStatus = itemView.findViewById(R.id.matchStatus);
            matchId = itemView.findViewById(R.id.matchId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String clickMatchId = matchId.getText().toString();
                    Intent intent = new Intent(itemView.getContext(), DetailMatchActivity.class);
                    intent.putExtra("matchId", clickMatchId);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
