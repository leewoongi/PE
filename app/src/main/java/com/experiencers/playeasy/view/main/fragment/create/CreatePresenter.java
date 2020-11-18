package com.experiencers.playeasy.view.main.fragment.create;


import com.experiencers.playeasy.model.Repository;
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
    public void receiveKeyWord(String word, String userKey) {
        repository.getPlace(word, userKey, this);
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
