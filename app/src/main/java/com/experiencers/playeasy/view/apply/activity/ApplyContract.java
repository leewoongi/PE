package com.experiencers.playeasy.view.apply.activity;

import com.experiencers.playeasy.view.base.BaseContract;

public interface ApplyContract {
    interface view extends BaseContract.view{
        @Override
        void init();

        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }
    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        @Override
        void deleteView();
    }
}
