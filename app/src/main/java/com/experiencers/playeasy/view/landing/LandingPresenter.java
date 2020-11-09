package com.experiencers.playeasy.view.landing;

public class LandingPresenter implements LandingContract.presenter{

    private LandingContract.view view;

    @Override
    public void setView(LandingContract.view view) {
        this.view = view;
    }

    @Override
    public void deleteView() {
        view = null;
    }
}
