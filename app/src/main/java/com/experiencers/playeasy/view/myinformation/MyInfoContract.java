package com.experiencers.playeasy.view.myinformation;

import com.experiencers.playeasy.view.base.BaseContract;

public interface MyInfoContract {
    interface view extends BaseContract.view{
        @Override
        void init();

        @Override
        void changeActivity();

        @Override
        void showResult();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void confirmButtonClick(int itemId);

        @Override
        void deleteView();
    }
}
