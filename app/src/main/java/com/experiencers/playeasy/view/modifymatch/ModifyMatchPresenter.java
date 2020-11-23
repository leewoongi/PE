package com.experiencers.playeasy.view.modifymatch;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class ModifyMatchPresenter implements ModifyMatchContract.presenter, RetrofitCallback {

    private ModifyMatchContract.view view;
    private Repository repository;
    public ModifyMatchPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(ModifyMatchContract.view view) {
        this.view = view;
    }

    @Override
    public void modifyMatch(String userKey, Match match) {

    }

    @Override
    public void sendKeyWord(String word, String userKey) {
        repository.getModifyPlace(word, userKey, this);
    }

    @Override
    public void CreateSuccess(Object object) {

    }

    @Override
    public void deleteView() {
        view = null;
    }

    @Override
    public void onSuccess(Object object) {

    }
}
