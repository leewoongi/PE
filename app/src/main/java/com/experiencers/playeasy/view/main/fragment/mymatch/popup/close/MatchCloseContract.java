package com.experiencers.playeasy.view.main.fragment.mymatch.popup.close;

import com.experiencers.playeasy.model.entity.CloseMatchRequest;
import com.experiencers.playeasy.view.base.BaseContract;

public interface MatchCloseContract {
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

        void sendCloseMatch(String userKey, int matchId, String status);
        void sendDeleteMatch(String userKey, int matchId, String status);
        @Override
        void deleteView();
    }
}
