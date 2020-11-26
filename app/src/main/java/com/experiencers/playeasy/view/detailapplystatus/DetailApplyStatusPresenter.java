package com.experiencers.playeasy.view.detailapplystatus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts.TeamStatusFragment;
import com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus.UserStatusFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailApplyStatusPresenter implements DetailApplyStatusContract.presenter{

    private DetailApplyStatusContract.view view;
    private DetailApplyStatusContract.adapterView adapterView;
    private DetailApplyStatusContract.adapterModel adapterModel;
    private TeamStatusFragment teamStatusFragment;
    private UserStatusFragment userStatusFragment;

    public DetailApplyStatusPresenter() {
        teamStatusFragment = new TeamStatusFragment();
        userStatusFragment = new UserStatusFragment();
    }

    @Override
    public void setView(DetailApplyStatusContract.view view) {
        this.view = view;
    }

    @Override
    public void setRecyclerAdapterView(DetailApplyStatusContract.adapterView adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setRecyclerAdapterModel(DetailApplyStatusContract.adapterModel adapterModel) {
        this.adapterModel = adapterModel;
    }


    @Override
    public void loadFragment(int matchId) {
        Bundle bundle = new Bundle();
        bundle.putInt("matchId", matchId);

        teamStatusFragment.setArguments(bundle);
        userStatusFragment.setArguments(bundle);

        List<Fragment> list = new ArrayList<>();

        list.add(teamStatusFragment);
        list.add(userStatusFragment);

        adapterModel.add(list);
        adapterView.fresh();
    }


    @Override
    public void deleteView() {
        view = null;
    }
}
