package com.experiencers.playeasy.view.detailapplystatus;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.view.base.BaseContract;

import java.util.List;

public interface DetailApplyStatusContract {
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
        void setRecyclerAdapterView(DetailApplyStatusContract.adapterView adapterView);
        void setRecyclerAdapterModel(DetailApplyStatusContract.adapterModel adapterModel);
        void loadFragment(int matchId);
        @Override
        void deleteView();
    }

    interface adapterView{
        void fresh();
    }
    interface adapterModel{
        void add(List<Fragment> list);
    }
}
