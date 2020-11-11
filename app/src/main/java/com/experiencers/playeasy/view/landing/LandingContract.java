package com.experiencers.playeasy.view.landing;

import com.experiencers.playeasy.view.base.BaseContract;

public interface LandingContract {
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
