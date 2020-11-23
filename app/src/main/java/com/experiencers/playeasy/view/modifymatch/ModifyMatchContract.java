package com.experiencers.playeasy.view.modifymatch;

import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.Match;
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
        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);
        void modifyMatch(String userKey, Match match);
        void sendKeyWord(String word, String userKey);
        void CreateSuccess(Object object);
        @Override
        void deleteView();
    }

}
