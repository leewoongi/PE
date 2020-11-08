package com.experiencers.playeasy.view.login;

import com.experiencers.playeasy.view.base.BaseContract;

public interface LoginContract {

    interface view extends BaseContract.view{
        @Override
        void init();

        @Override
        void showResult();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        @Override
        void deleteView();
    }
}
