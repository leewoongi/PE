package com.experiencers.playeasy.view.main.activity;

import android.view.View;

import com.experiencers.playeasy.view.base.BaseContract;

public interface MainContract {

    interface view extends BaseContract.view{
        @Override
        void showResult();
        void init();
        void setFragment();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);



        @Override
        void deleteView();
    }

}
