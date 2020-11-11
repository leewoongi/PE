package com.experiencers.playeasy.view.main.fragment.home;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.Calendar;

public interface HomeContract {

    interface view extends BaseContract.view{
        @Override
        void showResult(Object object);

        @Override
        void init();

        void recyclerViewInit();
        void calenderInit();

    }

    interface presenter extends BaseContract.presenter<view>{
        @Override
        void setView(view view);

        @Override
        void deleteView();
        void receiveDate(Calendar date, presenter presenter);

        void setAdapterView(HomeContract.adapterView adapter);
        void setAdapterModel(HomeContract.adapterModel adapter);
    }

    interface adapterView{
        void refresh();
    }

    interface adapterModel{
        void add(Object object);
    }

}
