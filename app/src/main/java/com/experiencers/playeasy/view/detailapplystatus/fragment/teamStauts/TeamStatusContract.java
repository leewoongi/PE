package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface TeamStatusContract {
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

        void receiveTeamMatch(String userKey, int matchId, String type);
        void setRecyclerAdapterView(TeamStatusRecyclerViewAdapter adapterView);
        void setRecyclerAdapterModel(TeamStatusRecyclerViewAdapter adapterModel);

        void matchOk(int matchId, String status);
        void matchReject(int matchId, String status);
        void teamMatchList(Object object);

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
