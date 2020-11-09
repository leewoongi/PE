package com.experiencers.playeasy.view.login;

import com.experiencers.playeasy.model.Repository;

public class LoginPresenter implements LoginContract.presenter{

    private LoginContract.view view;
    private Repository repository;

    public LoginPresenter() {
        repository = new Repository(this);
    }

    @Override
    public void setView(LoginContract.view view) {
        this.view = view;
    }

    @Override
    public void sendUserKey(String userKey) {

    }


    @Override
    public void deleteView() {

    }
}
