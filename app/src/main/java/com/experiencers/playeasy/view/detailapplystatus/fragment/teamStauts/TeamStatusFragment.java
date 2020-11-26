package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

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

public class TeamStatusFragment extends Fragment implements TeamStatusContract.view{

    private ViewGroup rootView;
    private TeamStatusPresenter presenter;
    private RecyclerView recyclerTeamStatus;
    private RecyclerView.LayoutManager layoutManager;
    private TeamStatusRecyclerViewAdapter adapter;

    private String userKey;
    private int matchId;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_team_status, container, false);

        init();
        recyclerInit();

        presenter = new TeamStatusPresenter();
        presenter.setView(this);

        userKey = TokenManger.read(rootView.getContext());
        matchId = getArguments().getInt("matchId", 0);

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        presenter.receiveTeamMatch(userKey, matchId, "TEAM");

        recyclerTeamStatus.setLayoutManager(layoutManager);
        recyclerTeamStatus.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void init() {
        recyclerTeamStatus = rootView.findViewById(R.id.recyclerTeamStatus);

    }

    @Override
    public void recyclerInit() {
        adapter = new TeamStatusRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(getContext());
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
