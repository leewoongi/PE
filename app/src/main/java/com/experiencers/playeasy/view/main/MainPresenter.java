package com.experiencers.playeasy.view.main;

import android.view.View;

public class MainPresenter implements MainContract.presenter{

    private MainContract.view view;
    @Override
    public void setView(View view) {
        this.view = (MainContract.view) view;
    }
}
