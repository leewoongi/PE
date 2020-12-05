package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel.MatchCancelActivity;

import java.util.ArrayList;
import java.util.List;

public class MatchApplyRecyclerViewAdapter extends RecyclerView.Adapter<MatchApplyRecyclerViewAdapter.myViewHolder> implements MatchApplyContract.adapterView, MatchApplyContract.adapterModel {

    private List<ApplyStatusResponse> item = new ArrayList<>();

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mymatch_status_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.applyMatchDate.setText(item.get(position).getMatch().getStartAt().substring(0,10));
        holder.applyMatchTime.setText(item.get(position).getMatch().getStartAt().substring(12, 16) + " ~ " + item.get(position).getMatch().getEndAt().substring(12, 16));
        holder.applyMatchPlace.setText(item.get(position).getMatch().getLocation().getPlaceDetail() + " " + item.get(position).getMatch().getLocation().getPlaceDetail());

        String type;
        if (item.get(position).getMatch().getType().equals("SOCCER")) {
            holder.applyMatchType.setText("축구 11 : 11");
        } else if (item.get(position).getMatch().getType().equals("FUTSAL5")) {
            holder.applyMatchType.setText("풋살 5 : 5");
        } else {
            holder.applyMatchType.setText("풋살 6 : 6");
        }

        if(item.get(position).getStatus().equals("WAITING")){
            holder.applyMatchContinue.setText("대기 중");
            holder.applyMatchContinue.setTextColor(Color.rgb(144,144,144));

        }else if(item.get(position).getStatus().equals("CONFIRMED")){
            holder.applyMatchContinue.setText("승인됨");
            holder.applyMatchContinue.setTextColor(Color.rgb(124,255,85));

        }else{
            holder.applyMatchContinue.setText("취소됨");
            holder.applyMatchContinue.setTextColor(Color.rgb(205,12,34));
            holder.applyCancel.setEnabled(false);
        }

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
    public void add(List<ApplyStatusResponse> list) {
        item = list;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        private TextView applyMatchDate;
        private TextView applyMatchTime;
        private TextView applyMatchPlace;
        private TextView applyMatchId;
        private TextView applyMatchType;
        private TextView applyMatchContinue;
        private Button applyCancel;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            applyMatchDate = itemView.findViewById(R.id.applyMatchDate);
            applyMatchTime = itemView.findViewById(R.id.applyMatchTime);
            applyMatchPlace = itemView.findViewById(R.id.applyMatchPlace);
            applyMatchId = itemView.findViewById(R.id.applyMatchId);
            applyMatchType = itemView.findViewById(R.id.applyMatchType);
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
