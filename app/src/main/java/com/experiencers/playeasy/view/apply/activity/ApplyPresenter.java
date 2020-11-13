package com.experiencers.playeasy.view.apply.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.apply.fragment.team.ApplyTeamFragment;
import com.experiencers.playeasy.view.apply.fragment.user.ApplyUserFragment;

import java.util.ArrayList;
import java.util.List;

public class ApplyPresenter implements ApplyContract.presenter {

    private ApplyContract.view view;
    private ApplyContract.adapterView adapterView;
    private ApplyContract.adapterModel adapterModel;
    private ApplyTeamFragment teamFragment;
    private ApplyUserFragment userFragment;

    public ApplyPresenter() {
        teamFragment = new ApplyTeamFragment();
        userFragment = new ApplyUserFragment();
    }

    @Override
    public void setView(ApplyContract.view view) {
        this.view = view;
    }

    @Override
    public void setViewpagerView(ApplyViewPagerAdapter adapter) {
        this.adapterView = adapter;
    }

    @Override
    public void setViewPagerModel(ApplyViewPagerAdapter adapter) {
        this.adapterModel = adapter;
    }

    @Override
    public void loadFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(teamFragment);
        fragments.add(userFragment);

        adapterModel.add(fragments);
        adapterView.refresh();
    }


    @Override
    public void deleteView() {
        view = null;
    }
}
