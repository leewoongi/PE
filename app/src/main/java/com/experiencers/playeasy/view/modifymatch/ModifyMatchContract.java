package com.experiencers.playeasy.view.modifymatch;


import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.ModifyMatchRequest;
import com.experiencers.playeasy.view.base.BaseContract;

import java.util.Calendar;


public interface ModifyMatchContract {

    interface view extends BaseContract.view{
        @Override
        void init();
        void calendarInit();
        String convertDate(Calendar date);
        String convertSTime();
        String convertETime();
        void showMap(Object object);
        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void retrieveMatchInfo(String userKey, int matchId);
        void sendKeyWord(String word, String userKey);
        void sendMatchInfo(String userKey, ModifyMatchRequest modifyMatchRequest);

        @Override
        void deleteView();
    }

}
