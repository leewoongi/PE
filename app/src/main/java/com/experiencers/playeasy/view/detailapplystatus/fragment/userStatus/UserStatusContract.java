package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.base.BaseContract;
import com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts.TeamStatusContract;
import com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts.TeamStatusRecyclerViewAdapter;

import java.util.List;

public interface UserStatusContract {
    interface view extends BaseContract.view{
        @Override
        void init();
        void recyclerInit();
        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }
    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void receiveUserMatch(String userKey, int matchId, String type);
        void setRecyclerAdapterView(UserStatusRecyclerViewAdapter adapterView);
        void setRecyclerAdapterModel(UserStatusRecyclerViewAdapter adapterModel);

        @Override
        void deleteView();
    }
    interface adapterView{
        void refresh();
    }
    interface adapterModel{
        void add(List<ApplyStatusResponse> item);
    }
}
