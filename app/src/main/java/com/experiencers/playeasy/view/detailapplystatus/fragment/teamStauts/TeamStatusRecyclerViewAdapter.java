package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

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

public class TeamStatusRecyclerViewAdapter extends RecyclerView.Adapter<TeamStatusRecyclerViewAdapter.myViewHolder> implements TeamStatusContract.adapterView, TeamStatusContract.adapterModel {
    private List<ApplyStatusResponse> item = new ArrayList<>();
    private TeamStatusPresenter presenter;
    private int matchId;

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
        holder.teamStatusName.setText(item.get(position).getUser().getTeamName());
        holder.teamStatusQuota.setText(String.valueOf(item.get(position).getQuota()));
        holder.teamStatusPhone.setText("전화번호 : " + item.get(position).getUser().getPhone());
        matchId = item.get(position).getMatch().getId();
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
        private TextView teamStatusName;
        private TextView teamStatusQuota;
        private TextView teamStatusPhone;
        private Button teamStatusOk;
        private Button teamStatusX;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            teamStatusName = itemView.findViewById(R.id.teamStatusName);
            teamStatusQuota = itemView.findViewById(R.id.teamStatusQuota);
            teamStatusPhone = itemView.findViewById(R.id.teamStatusPhone);
            teamStatusOk = itemView.findViewById(R.id.teamStatusOk);
            teamStatusX = itemView.findViewById(R.id.teamStatusX);

            teamStatusOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.matchOk(matchId,"CONFIRMED");
                }
            });

            teamStatusX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.matchReject(matchId, "DENIED");
                }
            });
        }
    }
}