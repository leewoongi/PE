package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

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

public class UserStatusRecyclerViewAdapter extends RecyclerView.Adapter<UserStatusRecyclerViewAdapter.myViewHolder> implements UserStatusContract.adapterView, UserStatusContract.adapterModel {

    private List<ApplyStatusResponse> item = new ArrayList<>();
    private UserStatusPresenter presenter;
    private int matchId;

    public UserStatusRecyclerViewAdapter(UserStatusPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_status_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.userStatusName.setText(item.get(position).getUser().getTeamName());
        holder.userStatusQuota.setText(String.valueOf(item.get(position).getQuota()));
        holder.userStatusPhone.setText("전화번호 : " + item.get(position).getUser().getPhone());
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
        private TextView userStatusName;
        private TextView userStatusQuota;
        private TextView userStatusPhone;
        private Button userStatusOk;
        private Button userStatusX;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            userStatusName = itemView.findViewById(R.id.userStatusName);
            userStatusPhone = itemView.findViewById(R.id.userStatusPhone);
            userStatusOk = itemView.findViewById(R.id.userStatusOk);
            userStatusX = itemView.findViewById(R.id.userStatusX);

            userStatusOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.matchOk(matchId,"CONFIRMED");
                }
            });

            userStatusX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.matchReject(matchId, "DENIED");
                }
            });
        }
    }
}
