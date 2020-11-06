package com.experiencers.playeasy.view.main.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface MainContract {

    interface view extends BaseContract.view{
        @Override
        void showResult();

        @Override
        void init();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);
        void setViewPagerView(ViewPagerAdapter viewPagerAdapter);
        void setViewPagerModel(ViewPagerAdapter viewPagerAdapter);
        void loadFragment();

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
