package com.experiencers.playeasy.view.main.activity;

public class MainPresenter implements MainContract.presenter{

    private MainContract.view view;


    @Override
    public void setView(MainContract.view view) {
        this.view = view;
    }

    @Override
    public void deleteView() {

    }
}
