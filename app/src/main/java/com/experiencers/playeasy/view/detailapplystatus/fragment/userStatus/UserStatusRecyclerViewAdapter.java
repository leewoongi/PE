package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

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

public class UserStatusRecyclerViewAdapter extends RecyclerView.Adapter<UserStatusRecyclerViewAdapter.myViewHolder> implements UserStatusContract.adapterView, UserStatusContract.adapterModel {

    private List<ApplyStatusResponse> item = new ArrayList<>();
    private UserStatusPresenter presenter;

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
        holder.userStatusName.setText(item.get(position).getUser().getName());
        holder.userStatusPhone.setText("전화번호 : " + item.get(position).getUser().getPhone());
        holder.userApplicationId.setText(String.valueOf(item.get(position).getId()));

        if(item.get(position).getStatus().equals("CONFIRMED")){

            holder.userStatusContinue.setText("승인됨");
            holder.userStatusContinue.setTextColor(Color.rgb(124,255,85));
            holder.userStatusOk.setEnabled(false);
            holder.userStatusX.setEnabled(false);

        }else if(item.get(position).getStatus().equals("DENIED")){

            holder.userStatusContinue.setText("거절됨");
            holder.userStatusContinue.setTextColor(Color.rgb(144,144,144));
            holder.userStatusOk.setEnabled(false);
            holder.userStatusX.setEnabled(false);

        }else if(holder.userStatusContinue.equals("진행중")){
            holder.userStatusOk.setEnabled(true);
            holder.userStatusX.setEnabled(true);
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
        private TextView userStatusName;
        private TextView userStatusPhone;
        private Button userStatusOk;
        private Button userStatusX;
        private TextView userStatusContinue;
        private TextView userApplicationId;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            userStatusName = itemView.findViewById(R.id.userStatusName);
            userStatusPhone = itemView.findViewById(R.id.userStatusPhone);
            userStatusOk = itemView.findViewById(R.id.userStatusOk);
            userStatusX = itemView.findViewById(R.id.userStatusX);
            userStatusContinue = itemView.findViewById(R.id.userStatusContinue);
            userApplicationId = itemView.findViewById(R.id.userApplicationId);

            userStatusOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int applicationId = Integer.parseInt(userApplicationId.getText().toString());
                    presenter.matchOk(applicationId,"CONFIRMED");
                }
            });

            userStatusX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int applicationId = Integer.parseInt(userApplicationId.getText().toString());
                    presenter.matchReject(applicationId, "DENIED");
                }
            });
        }
    }
}
