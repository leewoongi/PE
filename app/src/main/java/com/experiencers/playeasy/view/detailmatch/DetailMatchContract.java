package com.experiencers.playeasy.view.detailmatch;

import com.experiencers.playeasy.view.base.BaseContract;

public interface DetailMatchContract {

    interface view extends BaseContract.view{
        @Override
        void init();

        @Override
        void changeActivity();
        void showPopUp(int matchId);
        @Override
        void showResult(Object object);
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void receiveMatchId(int matchId, String userKey);
        void clickApply(int matchId);


        @Override
        void deleteView();
    }
}
