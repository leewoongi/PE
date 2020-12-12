package com.experiencers.playeasy.view.myinformation;

import com.experiencers.playeasy.model.entity.User;
import com.experiencers.playeasy.view.base.BaseContract;

public interface MyInfoContract {
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
        void setUserInfo(String userKey);
        void confirmButtonClick(int itemId, String userKey, User user);
        void getUserImage();

        @Override
        void deleteView();
    }
}
