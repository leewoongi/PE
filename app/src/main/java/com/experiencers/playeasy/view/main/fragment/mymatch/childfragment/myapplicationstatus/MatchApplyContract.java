package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus;

import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface MatchApplyContract {

    interface view extends BaseContract.view{
        @Override
        void init();
        void spinnerInit();
        void recyclerInit();
        @Override
        void changeActivity();

        @Override
        void showResult(Object object);
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        void setRecyclerAdapterView(MatchApplyRecyclerViewAdapter adapterView);
        void setRecyclerAdapterModel(MatchApplyRecyclerViewAdapter adapterModel);
        void sendType(String type, String userKey);

        @Override
        void deleteView();
    }

    interface adapterView{
        void refresh();
    }

    interface adapterModel{
        void add(List<ApplyStatusResponse> list);
    }

}
