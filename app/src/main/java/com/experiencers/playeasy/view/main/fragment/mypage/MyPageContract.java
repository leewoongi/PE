package com.experiencers.playeasy.view.main.fragment.mypage;

import com.experiencers.playeasy.view.base.BaseContract;

public interface MyPageContract {

    interface view extends BaseContract.view{
        @Override
        void init();

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
