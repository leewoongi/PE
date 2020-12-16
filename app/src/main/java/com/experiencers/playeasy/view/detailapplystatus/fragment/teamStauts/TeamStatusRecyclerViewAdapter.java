package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

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

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamStatusRecyclerViewAdapter extends RecyclerView.Adapter<TeamStatusRecyclerViewAdapter.myViewHolder> implements TeamStatusContract.adapterView, TeamStatusContract.adapterModel {
    private List<ApplyStatusResponse> item = new ArrayList<>();
    private TeamStatusPresenter presenter;

    public TeamStatusRecyclerViewAdapter(TeamStatusPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_stauts_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
       //나중에 사진 추가
        holder.teamStatusName.setText(item.get(position).getUser().getTeamName());
        holder.teamStatusMember.setText(item.get(position).getQuota() + "명");
        holder.teamStatusPhone.setText("전화번호 : " + item.get(position).getUser().getPhone());
        holder.teamApplicationId.setText(String.valueOf(item.get(position).getId()));

        if(item.get(position).getStatus().equals("CONFIRMED")){

            holder.teamStatusContinue.setText("승인됨");
            holder.teamStatusContinue.setTextColor(Color.rgb(124,255,85));
            holder.teamStatusOk.setEnabled(false);
            holder.teamStatusX.setEnabled(false);

        }else if(item.get(position).getStatus().equals("DENIED")){

            holder.teamStatusContinue.setText("거절됨");
            holder.teamStatusContinue.setTextColor(Color.rgb(144,144,144));
            holder.teamStatusOk.setEnabled(false);
            holder.teamStatusX.setEnabled(false);

        }else if(holder.teamStatusContinue.equals("진행중")){
            holder.teamStatusOk.setEnabled(true);
            holder.teamStatusX.setEnabled(true);
        }

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

        private CircleImageView circleImageView;
        private TextView teamStatusName;
        private TextView teamStatusMember;
        private TextView teamStatusPhone;
        private Button teamStatusOk;
        private Button teamStatusX;
        private TextView teamStatusContinue;
        private TextView teamApplicationId;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.teamCircleImageView);
            teamStatusName = itemView.findViewById(R.id.teamStatusName);
            teamStatusMember = itemView.findViewById(R.id.teamStatusMember);
            teamStatusPhone = itemView.findViewById(R.id.teamStatusPhone);
            teamStatusOk = itemView.findViewById(R.id.teamStatusOk);
            teamStatusX = itemView.findViewById(R.id.teamStatusX);
            teamStatusContinue = itemView.findViewById(R.id.teamStatusContinue);
            teamApplicationId = itemView.findViewById(R.id.teamApplicationId);

            teamStatusOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int applicationId = Integer.parseInt(teamApplicationId.getText().toString());
                    presenter.matchOk(applicationId,"CONFIRMED");
                }
            });

            teamStatusX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int applicationId = Integer.parseInt(teamApplicationId.getText().toString());
                    presenter.matchReject(applicationId, "DENIED");
                }
            });
        }
    }
}
