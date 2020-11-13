package com.experiencers.playeasy.view.main.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface MainContract {

    interface view extends BaseContract.view{
        @Override
        void showResult(Object object);

        @Override
        void init();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);
        void setViewPagerView(MainViewPagerAdapter mainViewPagerAdapter);
        void setViewPagerModel(MainViewPagerAdapter mainViewPagerAdapter);

        void loadFragment();
        int changeFragment(int fragmentId);
        @Override
        void deleteView();
    }

    interface adapterView{
        void refresh();
    }

    interface adapterModel{
        void add(List<Fragment> fragments);
        void remove();
        void getItem();
    }
}
