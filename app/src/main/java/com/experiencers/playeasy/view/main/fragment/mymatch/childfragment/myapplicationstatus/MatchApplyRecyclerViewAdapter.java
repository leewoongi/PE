package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel.MatchCancelActivity;

import java.util.ArrayList;
import java.util.List;

public class MatchApplyRecyclerViewAdapter extends RecyclerView.Adapter<MatchApplyRecyclerViewAdapter.myViewHolder> implements MatchApplyContract.adapterView, MatchApplyContract.adapterModel {

    private List<Match> item = new ArrayList<>();

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mymatch_status_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.applyMatchTime.setText(item.get(position).getStartAt().substring(12, 16) + " ~ " + item.get(position).getEndAt().substring(12, 16));
        holder.applyMatchPlace.setText(item.get(position).getLocation().getPlaceName() + " " + item.get(position).getLocation().getPlaceDetail());

        String type;
        if (item.get(position).getType() == "SOCCER") {
            type = "11";
        } else if (item.get(position).getType() == "FUTSAL5") {
            type = "5";
        } else {
            type = "6";
        }
        holder.applyPeople.setText(item.get(position).getQuota() + " / " + type);
        holder.applyMatchContinue.setText(item.get(position).getStatus());
        holder.applyMatchId.setText(String.valueOf(item.get(position).getId()));

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
    public void add(List<Match> list) {
        item = list;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        private TextView applyMatchTime;
        private TextView applyMatchPlace;
        private TextView applyPeople;
        private TextView applyMatchId;
        private TextView applyMatchContinue;
        private Button applyCancel;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            applyMatchTime = itemView.findViewById(R.id.applyMatchTime);
            applyMatchPlace = itemView.findViewById(R.id.applyMatchPlace);
            applyPeople = itemView.findViewById(R.id.applyPeople);
            applyMatchId = itemView.findViewById(R.id.applyMatchId);
            applyMatchContinue = itemView.findViewById(R.id.applyMatchContinue);
            applyCancel = itemView.findViewById(R.id.applyCancel);

            applyCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatchCancelActivity.class);
                    int matchId = Integer.parseInt(applyMatchId.getText().toString());
                    intent.putExtra("matchId", matchId);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
