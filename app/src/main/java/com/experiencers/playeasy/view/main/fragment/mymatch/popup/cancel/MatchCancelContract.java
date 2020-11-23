package com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel;

import com.experiencers.playeasy.model.entity.ChangeMatchStatusRequest;
import com.experiencers.playeasy.view.base.BaseContract;

public interface MatchCancelContract {
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
        void sendCancelStatus(String userKey, int matchId, String status);
        @Override
        void deleteView();
    }
}
