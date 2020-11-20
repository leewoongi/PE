package com.experiencers.playeasy.view.main.fragment.create;


import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class CreatePresenter implements CreateContract.presenter, RetrofitCallback {

    private CreateContract.view view;
    private Repository repository;

    public CreatePresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(CreateContract.view view) {
        this.view = view;
    }

    @Override
    public void sendKeyWord(String word, String userKey) {
        repository.getPlace(word, userKey, this);
    }

    @Override
    public void sendMatchInfo(String userKey, CreateMatchRequest createMatchRequest) {
        repository.postCreateMatch(userKey, createMatchRequest, this);
    }

    @Override
    public void CreateSuccess(Object object) {
        view.changeActivity();
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
