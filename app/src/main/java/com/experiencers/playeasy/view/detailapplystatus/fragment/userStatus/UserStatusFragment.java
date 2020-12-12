package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;

public class UserStatusFragment extends Fragment implements UserStatusContract.view {

    private ViewGroup rootView;
    private UserStatusPresenter presenter;

    private RecyclerView recyclerUserStatus;
    private RecyclerView.LayoutManager layoutManager;
    private UserStatusRecyclerViewAdapter adapter;

    private TextView userApplyCount;
    private String userKey;
    private int matchId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_user_status, container, false);

        userKey = TokenManger.read(getContext());
        matchId = getArguments().getInt("matchId", 0);

        presenter = new UserStatusPresenter();
        presenter.setView(this);

        init();
        recyclerInit();

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        recyclerUserStatus.setLayoutManager(layoutManager);
        recyclerUserStatus.setAdapter(adapter);

        presenter.receiveUserMatch(userKey, matchId, "PERSONAL");

        return rootView;
    }

    @Override
    public void init() {
        recyclerUserStatus = rootView.findViewById(R.id.recyclerUserStatus);
        userApplyCount = rootView.findViewById(R.id.userApplyCount);
    }

    @Override
    public void recyclerInit() {
        adapter = new UserStatusRecyclerViewAdapter(presenter);
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

        if(object instanceof String){
            int check = (int) object;
            if(check == 1){
                Toast.makeText(getActivity(), "매치를 승인했습니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(), "매치를 거절 했습니다.", Toast.LENGTH_SHORT).show();
            }
        }else{
            userApplyCount.setText(object + "개 팀");
        }
    }
}
