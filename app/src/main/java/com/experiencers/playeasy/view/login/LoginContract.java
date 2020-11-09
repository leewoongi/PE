package com.experiencers.playeasy.view.login;

import android.content.Context;

import com.experiencers.playeasy.view.base.BaseContract;

public interface LoginContract {

    interface view extends BaseContract.view{
        @Override
        void init();

        @Override
        void changeActivity();

        @Override
        void showResult();


    }

    interface presenter extends BaseContract.presenter<view>{

        void setView(view view, Context context);

        void sendUserKey(String access_token, presenter presenter);

        @Override
        void deleteView();
    }
}
