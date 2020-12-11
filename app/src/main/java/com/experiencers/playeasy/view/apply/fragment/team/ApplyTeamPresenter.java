package com.experiencers.playeasy.view.apply.fragment.team;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class ApplyTeamPresenter implements ApplyTeamContract.presenter, RetrofitCallback {

    private ApplyTeamContract.view view;
    private Repository repository;
    public ApplyTeamPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(ApplyTeamContract.view view) {
        this.view = view;
    }

    @Override
    public void completionApply(String userKey, Apply apply) {
        repository.postMatchApplyTeam(userKey, apply, this);
    }

    @Override
    public void onSuccess(Object object) {
        if( object instanceof  String){
            view.showResult(object);
        }else{
            ApplyStatusResponse applyResponse = (ApplyStatusResponse) object;
            view.changeActivity();
        }
    }

    @Override
    public void deleteView() {
        view = null;
    }

}
