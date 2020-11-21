package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import com.experiencers.playeasy.view.base.BaseContract;

public interface RegisterContract {
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

        @Override
        void deleteView();
    }

    interface adapterView{
        void refresh();
    }
    interface adapterModel{
        void add();
    }
}
