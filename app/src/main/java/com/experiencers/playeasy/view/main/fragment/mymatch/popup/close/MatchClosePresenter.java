package com.experiencers.playeasy.view.main.fragment.mymatch.popup.close;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.CloseMatchRequest;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class MatchClosePresenter implements MatchCloseContract.presenter, RetrofitCallback {

    private MatchCloseContract.view view;
    private Repository repository;

    public MatchClosePresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(MatchCloseContract.view view) {
        this.view = view;
    }

    @Override
    public void sendCloseMatch(String userKey, int matchId, String status) {
        CloseMatchRequest closeMatchRequest = new CloseMatchRequest(matchId, status);
        repository.putCloseMatch(userKey, closeMatchRequest, this);
    }

    @Override
    public void sendDeleteMatch(String userKey, int matchId, String status) {
        CloseMatchRequest closeMatchRequest = new CloseMatchRequest(matchId, status);
        repository.putDeleteMatch(userKey, closeMatchRequest, this);
    }

    @Override
    public void onSuccess(Object object) {
        int result = 1;
        view.showResult(result);
    }

    public void deleteSuccess(Object object){
        int result = 2;
        view.showResult(result);
    }

    @Override
    public void deleteView() {
        view = null;
    }
}
