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

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.matchTime.setText(item.get(position).getStartAt().substring(12,16) + " ~ "+ item.get(position).getEndAt().substring(12,16));
        holder.matchPlace.setText(item.get(position).getLocation().getPlaceName() + " " +item.get(position).getLocation().getPlaceDetail());
        holder.matchType.setText(item.get(position).getType());
        String status = "";
        if(item.get(position).getStatus().equals("WAITING")) {
            holder.matchStatus.setText("신청 가능");
        }else{
            holder.matchStatus.setText("신청 마감");
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
        private TextView matchTime;
        private TextView matchPlace;
        private TextView matchType;
        private TextView matchStatus;
        private TextView matchId;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            matchTime = itemView.findViewById(R.id.applyMatchTime);
            matchPlace = itemView.findViewById(R.id.applyMatchPlace);
            matchType = itemView.findViewById(R.id.applyMatchStatus);
            matchStatus = itemView.findViewById(R.id.matchStatus);
            matchId = itemView.findViewById(R.id.applyMatchId);

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
