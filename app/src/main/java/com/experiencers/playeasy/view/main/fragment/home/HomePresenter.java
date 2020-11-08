package com.experiencers.playeasy.view.main.fragment.home;

import com.experiencers.playeasy.model.entity.Match;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.presenter {

    private HomeContract.view view;
    private HomeContract.adapterView adapterView;
    private HomeContract.adapterModel adapterModel;

    @Override
    public void setView(HomeContract.view view) {
        this.view = view;
    }


    @Override
    public void receiveDate() {

    }


    @Override
    public void setAdapterView(HomeRecyclerAdapter adapter) {
        this.adapterView = adapter;
    }

    @Override
    public void setAdapterModel(HomeRecyclerAdapter adapter) {
        this.adapterModel = adapter;
    }



    @Override
    public void deleteView() {

    }
}

