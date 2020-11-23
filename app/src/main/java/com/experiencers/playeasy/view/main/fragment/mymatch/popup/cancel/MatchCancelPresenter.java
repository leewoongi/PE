package com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.ChangeMatchStatusRequest;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class MatchCancelPresenter implements MatchCancelContract.presenter, RetrofitCallback {

    private MatchCancelContract.view view;
    private Repository repository;

    public MatchCancelPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(MatchCancelContract.view view) {
        this.view = view;
    }

    @Override
    public void sendCancelStatus(String userKey, int matchId, String status) {
        ChangeMatchStatusRequest changeMatchStatusRequest = new ChangeMatchStatusRequest(matchId, status);
        repository.putApplyMatchCancel(userKey, changeMatchStatusRequest, this);
    }

    @Override
    public void deleteView() {
        view = null;
    }

    @Override
    public void onSuccess(Object object) {
        view.showResult(object);
    }
}
