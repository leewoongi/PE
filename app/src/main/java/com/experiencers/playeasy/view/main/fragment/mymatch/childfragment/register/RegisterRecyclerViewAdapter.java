package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.entity.Match;

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
        private TextView registerPeople;
        private TextView registerMatchContinue;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            registerMatchTime = itemView.findViewById(R.id.registerMatchTime);
            registerMatchPlace = itemView.findViewById(R.id.registerMatchPlace);
            registerPeople = itemView.findViewById(R.id.registerPeople);
            registerMatchContinue = itemView.findViewById(R.id.registerMatchContinue);

        }
    }
}
