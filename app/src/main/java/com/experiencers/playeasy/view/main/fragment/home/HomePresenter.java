package com.experiencers.playeasy.view.main.fragment.home;

public class HomePresenter implements HomeContract.presenter {

    private HomeContract.view view;

    @Override
    public void setView(HomeContract.view view) {
        this.view = view;
    }


    @Override
    public void deleteView() {

    }
}
