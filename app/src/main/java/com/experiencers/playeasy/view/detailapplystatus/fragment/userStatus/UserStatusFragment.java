package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private String userKey;
    private int matchId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_user_status, container, false);

        userKey = TokenManger.read(getContext());
        matchId = getArguments().getInt("matchId", 0);

        init();
        recyclerInit();

        presenter = new UserStatusPresenter();
        presenter.setView(this);

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
    }

    @Override
    public void recyclerInit() {
        adapter = new UserStatusRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
