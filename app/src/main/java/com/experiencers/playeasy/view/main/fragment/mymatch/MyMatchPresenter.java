package com.experiencers.playeasy.view.main.fragment.mymatch;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus.MatchApplyStatusFragment;
import com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

public class MyMatchPresenter implements MyMatchContract.presenter {

    private MyMatchContract.view view;
    private MyMatchContract.adapterView adapterView;
    private MyMatchContract.adapterModel adapterModel;
    private RegisterFragment registerFragment;
    private MatchApplyStatusFragment matchApplyStatus;

    private Repository repository;

    public MyMatchPresenter() {
        repository = new Repository();
        registerFragment = new RegisterFragment();
        matchApplyStatus = new MatchApplyStatusFragment();
    }

    @Override
    public void setView(MyMatchContract.view view) {
        this.view = view;
    }

    @Override
    public void loadFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(registerFragment);
        fragments.add(matchApplyStatus);

        adapterModel.add(fragments);
        adapterView.refresh();
    }

    @Override
    public void setPageAdapterView(MyMatchViewPagerAdapter adapter) {
        this.adapterView = adapter;
    }

    @Override
    public void setPageAdapterModel(MyMatchViewPagerAdapter adapter) {
        this.adapterModel = adapter;
    }

    @Override
    public void deleteView() {
        view = null;
    }

}
