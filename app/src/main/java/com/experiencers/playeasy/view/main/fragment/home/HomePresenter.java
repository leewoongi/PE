package com.experiencers.playeasy.view.main.fragment.home;

import android.util.Log;

import java.util.Calendar;

public class HomePresenter implements HomeContract.presenter, HomeContract.adapterView, HomeContract.adapterModel {

    private HomeContract.view view;
    private HomeContract.adapterView adapterView;
    private HomeContract.adapterModel adapterModel;


    @Override
    public void setView(HomeContract.view view) {
        this.view = view;
    }


    @Override
    public void receiveDate(Calendar date) {
        String matchDay = "";
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1;
        int year = date.get(Calendar.YEAR);

        if (month <= 9) {
            matchDay = year + "-0" + month;

        } else {
            matchDay = year + "-" + month;
        }

        if(day <= 9){
            matchDay = matchDay + "-0" + day;
        }else{
            matchDay = matchDay + "-" + day;
        }
        Log.d("temp", matchDay);
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
    public void refresh() {

    }

    @Override
    public void add() {

    }

    @Override
    public void deleteView() {
        view = null;
    }
}

