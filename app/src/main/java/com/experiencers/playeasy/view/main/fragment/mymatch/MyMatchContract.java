package com.experiencers.playeasy.view.main.fragment.mymatch;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface MyMatchContract {
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

        void loadFragment();
        void setPageAdapterView(MyMatchViewPagerAdapter adapter);
        void setPageAdapterModel(MyMatchViewPagerAdapter adapter);
        @Override
        void deleteView();
    }

    interface adapterView{
        void refresh();
    }

    interface adapterModel{
        void add(List<Fragment> fragments);
    }
}
