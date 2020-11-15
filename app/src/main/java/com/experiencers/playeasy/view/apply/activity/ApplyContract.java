package com.experiencers.playeasy.view.apply.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface ApplyContract {
    interface view extends BaseContract.view{
        @Override
        void init();
        void popUpInit();

        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }
    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void setViewpagerView(ApplyViewPagerAdapter adapter);
        void setViewPagerModel(ApplyViewPagerAdapter adapter);

        void loadFragment(int matchId);

        @Override
        void deleteView();
    }

    interface adapterView{
        void refresh();
    }
    interface adapterModel{
        void add(List<Fragment> fragments);
    }
}
