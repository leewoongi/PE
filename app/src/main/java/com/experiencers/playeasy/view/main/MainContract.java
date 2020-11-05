package com.experiencers.playeasy.view.main;

import android.view.View;

import com.experiencers.playeasy.view.base.BaseContract;

public interface MainContract {

    interface view extends BaseContract.view{
        @Override
        void showResult();
    }

    interface presenter extends BaseContract.presenter{
        @Override
        void setView(View view);

    }

}
