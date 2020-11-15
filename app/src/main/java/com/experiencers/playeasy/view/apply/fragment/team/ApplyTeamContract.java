package com.experiencers.playeasy.view.apply.fragment.team;

import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.view.base.BaseContract;

public interface ApplyTeamContract {

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

        void completionApply(String userKey, Apply apply);

        @Override
        void deleteView();
    }
}
