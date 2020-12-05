package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

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
import com.experiencers.playeasy.view.detailapplystatus.DetailApplyStatusActivity;
import com.experiencers.playeasy.view.main.fragment.mymatch.popup.close.MatchCloseActivity;
import com.experiencers.playeasy.view.modifymatch.ModifyMatchActivity;

import org.w3c.dom.Text;

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
        holder.registerMatchDate.setText(item.get(position).getStartAt().substring(0,10));
        holder.registerMatchTime.setText(item.get(position).getStartAt().substring(12,16) + " ~ "+ item.get(position).getEndAt().substring(12,16));
        holder.registerMatchPlace.setText(item.get(position).getLocation().getPlaceName() + " " +item.get(position).getLocation().getPlaceDetail());
        String type;
        if(item.get(position).getType().equals("SOCCER")){
            holder.registerMatchType.setText("축구 11 : 11");
        }else if(item.get(position).getType().equals("FUTSAL5")){
            holder.registerMatchType.setText("풋살 5 : 5");
        }else{
            holder.registerMatchType.setText("풋살 6 : 6");
        }

        if(item.get(position).getStatus().equals("WAITING")){

            holder.registerMatchContinue.setText("진행 중");
            holder.registerMatchContinue.setTextColor(Color.rgb(124,255,85));
            holder.registerMatchEnd.setText("마감하기");
            holder.registerMatchEnd.setTextColor(Color.rgb(183,111,255));

        }else if(item.get(position).getStatus().equals("CONFIRMED")){

            holder.registerMatchContinue.setText("마감");
            holder.registerMatchContinue.setTextColor(Color.rgb(144,144,144));
            holder.registerMatchEnd.setText("마감됨");
            holder.registerMatchEnd.setTextColor(Color.rgb(144,144,144));
            holder.registerMatchEnd.setEnabled(false);

        }else{
            holder.registerMatchContinue.setText("취소");
            holder.registerMatchContinue.setTextColor(Color.rgb(205,12,34));
            holder.registerMatchEnd.setText("취소됨");
            holder.registerMatchEnd.setTextColor(Color.rgb(205,12,34));
            holder.registerMatchEnd.setEnabled(false);
        }

        holder.registerMatchId.setText(String.valueOf(item.get(position).getId()));
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

        private TextView registerMatchDate;
        private TextView registerMatchTime;
        private TextView registerMatchPlace;
        private TextView registerMatchId;
        private TextView registerMatchType;
        private TextView registerMatchContinue;
        private TextView registerMatchEnd;
        private TextView confirmApplyStatus;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            registerMatchDate = itemView.findViewById(R.id.registerMatchDate);
            registerMatchTime = itemView.findViewById(R.id.registerMatchTime);
            registerMatchPlace = itemView.findViewById(R.id.registerMatchPlace);
            registerMatchContinue = itemView.findViewById(R.id.registerMatchContinue);
            registerMatchId = itemView.findViewById(R.id.registerMatchId);
            registerMatchType = itemView.findViewById(R.id.registerMatchType);
            registerMatchEnd = itemView.findViewById(R.id.registerMatchEnd);
            confirmApplyStatus = itemView.findViewById(R.id.confirmApplyStatus);

            itemView.setOnClickListener(v -> {
                int matchId = Integer.parseInt(registerMatchId.getText().toString());
                Intent intent = new Intent(itemView.getContext(), ModifyMatchActivity.class);
                intent.putExtra("matchId", matchId);
                itemView.getContext().startActivity(intent);
            });

            registerMatchEnd.setOnClickListener(v->{
                int matchId = Integer.parseInt(registerMatchId.getText().toString());
                Intent intent = new Intent(itemView.getContext(), MatchCloseActivity.class);
                intent.putExtra("matchId", matchId);
                itemView.getContext().startActivity(intent);
            });

            confirmApplyStatus.setOnClickListener(V->{
                int matchId = Integer.parseInt(registerMatchId.getText().toString());
                Intent intent = new Intent(itemView.getContext(), DetailApplyStatusActivity.class);
                intent.putExtra("matchId", matchId);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
