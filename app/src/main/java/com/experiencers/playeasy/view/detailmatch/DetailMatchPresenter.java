package com.experiencers.playeasy.view.detailmatch;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class DetailMatchPresenter implements DetailMatchContract.presenter, RetrofitCallback {

    private DetailMatchContract.view view;
    private Repository repository;

    public DetailMatchPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(DetailMatchContract.view view) {
        this.view = view;
    }

    @Override
    public void receiveMatchId(int matchId, String userKey) {
        repository.getMatch(matchId, userKey, this);
    }

    @Override
    public void clickApply(int matchId) {
        view.showPopUp(matchId);
    }


    @Override
    public void onSuccess(Object object) {
        view.showResult(object);
    }

    @Override
    public void deleteView() {
        view = null;
    }

}
