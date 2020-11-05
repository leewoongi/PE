package com.experiencers.playeasy.view.main.fragment;

import com.experiencers.playeasy.view.base.BaseContract;

public interface HomeContract {

    interface view extends BaseContract.view{
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
