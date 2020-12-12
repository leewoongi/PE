package com.experiencers.playeasy.view.main.fragment.create;

import android.text.Editable;

import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.view.base.BaseContract;

import java.util.Calendar;

public interface CreateContract {
    interface view extends BaseContract.view{
        @Override
        void init();
        void calendarInit();
        String convertDate(Calendar date);
        String convertSTime();
        String convertETime();
        @Override
        void changeActivity();
        void viewInit();

        @Override
        void showResult(Object object);
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void sendKeyWord(String word, String userKey);
        void sendMatchInfo(String userKey, CreateMatchRequest createMatchRequest);
        void CreateSuccess(Object object);
        @Override
        void deleteView();
    }
}
