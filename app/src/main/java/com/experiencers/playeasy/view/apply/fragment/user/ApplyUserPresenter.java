package com.experiencers.playeasy.view.apply.fragment.user;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class ApplyUserPresenter implements ApplyUserContract.presenter, RetrofitCallback {

    private ApplyUserContract.view view;
    private Repository repository;

    public ApplyUserPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(ApplyUserContract.view view) {
        this.view = view;
    }

    @Override
    public void completionApply(String userKey, Apply apply) {
        repository.postMatchApplyPersonal(userKey, apply, this);

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
