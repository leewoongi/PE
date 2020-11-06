package com.experiencers.playeasy.view.main.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.main.fragment.home.HomeFragment;
import com.experiencers.playeasy.view.main.fragment.mypage.MyPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.presenter{

    private MainContract.view view;
    private MainContract.adapterView adapterView;
    private MainContract.adapterModel adapterModel;


    @Override
    public void setView(MainContract.view view) {
        this.view = view;
    }

    @Override
    public void setViewPagerView(ViewPagerAdapter viewPagerAdapter) {
        this.adapterView = viewPagerAdapter;
    }

    @Override
    public void setViewPagerModel(ViewPagerAdapter viewPagerAdapter) {
        this.adapterModel = viewPagerAdapter;
    }

    @Override
    public void loadFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MyPageFragment());

        adapterModel.add(fragments);
        adapterView.refresh();
    }

    @Override
    public void deleteView() {

    }
}
