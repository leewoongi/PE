package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

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
import com.experiencers.playeasy.utill.RecyclerViewDeco;

public class TeamStatusFragment extends Fragment implements TeamStatusContract.view{

    private ViewGroup rootView;
    private TeamStatusPresenter presenter;
    private RecyclerView recyclerTeamStatus;
    private RecyclerView.LayoutManager layoutManager;
    private TeamStatusRecyclerViewAdapter adapter;
    private RecyclerViewDeco recyclerViewDeco;

    private TextView teamApplyCount;
    private String userKey;
    private int matchId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_team_status, container, false);

        presenter = new TeamStatusPresenter();
        presenter.setView(this);

        init();
        recyclerInit();

        userKey = TokenManger.read(rootView.getContext());
        matchId = getArguments().getInt("matchId", 0);

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        recyclerTeamStatus.setLayoutManager(layoutManager);
        recyclerTeamStatus.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.receiveTeamMatch(userKey, matchId, "TEAM");
    }

    @Override
    public void init() {
        recyclerTeamStatus = rootView.findViewById(R.id.recyclerTeamStatus);
        teamApplyCount = rootView.findViewById(R.id.teamApplyCount);
    }

    @Override
    public void recyclerInit() {
        adapter = new TeamStatusRecyclerViewAdapter(presenter);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewDeco = new RecyclerViewDeco(30);
        recyclerTeamStatus.addItemDecoration(recyclerViewDeco);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

        if(object instanceof String){
            if(object.equals("CONFIRMED")){
                Toast.makeText(getActivity(), "매치를 승인했습니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(), "매치를 거절 했습니다.", Toast.LENGTH_SHORT).show();
            }
        }else{

            teamApplyCount.setText(object + "개 팀");
        }
    }
}
