package com.experiencers.playeasy.view.main.fragment.home;

import android.util.Log;
import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.view.callback.RetrofitCallback;
import java.util.Calendar;


public class HomePresenter implements HomeContract.presenter, RetrofitCallback {

    private HomeContract.view view;
    private Repository repository;
    private HomeContract.adapterView adapterView;
    private HomeContract.adapterModel adapterModel;

    public HomePresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(HomeContract.view view) {
        this.view = view;
    }


    @Override
    public void receiveDate(Calendar date, HomeContract.presenter presenter) {
        String matchDay = "";
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1;
        int year = date.get(Calendar.YEAR);

        if (month <= 9) {
            matchDay = year + "-0" + month;

        } else {
            matchDay = year + "-" + month;
        }

        if(day <= 9) {
            matchDay = matchDay + "-0" + day;
        } else{
            matchDay = matchDay + "-" + day;
        }
        Log.d("temp", matchDay);
        repository.getMatchList(matchDay, this);
    }


    @Override
    public void setAdapterView(HomeContract.adapterView adapter) {
        this.adapterView = adapter;
    }

    @Override
    public void setAdapterModel(HomeContract.adapterModel adapter) {
        this.adapterModel = adapter;
    }

    @Override
    public void deleteView() {
        view = null;
    }

    @Override
    public void onSuccess(Object object) {

        if(object != null){
            adapterModel.add(object);
            adapterView.refresh();
        }
    }

}

