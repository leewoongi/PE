package com.experiencers.playeasy.view.main.fragment.home;

import com.experiencers.playeasy.view.base.BaseContract;

public interface HomeContract {

    interface view extends BaseContract.view{
        @Override
        void showResult();

        @Override
        void init();
        void recyclerViewInit();
        void calenderInit();

        void selectDate();
    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        @Override
        void deleteView();
        void receiveDate();

        void setAdapterView(HomeRecyclerAdapter adapter);
        void setAdapterModel(HomeRecyclerAdapter adapter);
    }

    interface adapterView{
        void refresh();
    }

    interface adapterModel{
        void add();
    }

}
