package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

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
import com.experiencers.playeasy.view.main.fragment.mymatch.popup.close.MatchCloseActivity;
import com.experiencers.playeasy.view.modifymatch.ModifyMatchActivity;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterRecyclerViewAdapter extends RecyclerView.Adapter<RegisterRecyclerViewAdapter.myViewHolder> implements RegisterContract.adapterView, RegisterContract.adapterModel{

    private List<Match> item = new ArrayList<>();
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mymatch_register_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.registerMatchTime.setText(item.get(position).getStartAt().substring(12,16) + " ~ "+ item.get(position).getEndAt().substring(12,16));
        holder.registerMatchPlace.setText(item.get(position).getLocation().getPlaceName() + " " +item.get(position).getLocation().getPlaceDetail());
        String type;
        if(item.get(position).getType() == "SOCCER"){
            type = "11";
        }else if(item.get(position).getType() == "FUTSAL5"){
            type = "5";
        }else{
            type = "6";
        }
        holder.registerPeople.setText(item.get(position).getQuota() + " / " + type);
        holder.registerMatchContinue.setText(item.get(position).getStatus());
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
    public void add(Object object) {
        item = (List<Match>) object;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView registerMatchTime;
        private TextView registerMatchPlace;
        private TextView applyMatchId;
        private TextView registerPeople;
        private TextView registerMatchContinue;
        private TextView applyMatchEnd;
        private TextView confirmApplyStatus;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            registerMatchTime = itemView.findViewById(R.id.applyMatchTime);
            registerMatchPlace = itemView.findViewById(R.id.applyMatchPlace);
            registerPeople = itemView.findViewById(R.id.applyPeople);
            registerMatchContinue = itemView.findViewById(R.id.applyMatchContinue);
            applyMatchId = itemView.findViewById(R.id.applyMatchId);
            applyMatchEnd = itemView.findViewById(R.id.applyMatchEnd);
            confirmApplyStatus = itemView.findViewById(R.id.confirmApplyStatus);

            itemView.setOnClickListener(v -> {
                int matchId = Integer.parseInt(applyMatchId.getText().toString());
                Intent intent = new Intent(itemView.getContext(), ModifyMatchActivity.class);
                intent.putExtra("matchId", matchId);
                itemView.getContext().startActivity(intent);
            });

            applyMatchEnd.setOnClickListener(v->{
                int matchId = Integer.parseInt(applyMatchId.getText().toString());
                Intent intent = new Intent(itemView.getContext(), MatchCloseActivity.class);
                intent.putExtra("matchId", matchId);
                itemView.getContext().startActivity(intent);
            });

            confirmApplyStatus.setOnClickListener(V->{
                
            });
        }
    }
}
