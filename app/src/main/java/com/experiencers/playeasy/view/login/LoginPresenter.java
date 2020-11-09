package com.experiencers.playeasy.view.login;

import android.content.Context;

import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class LoginPresenter implements LoginContract.presenter, RetrofitCallback {

    private LoginContract.view view;
    private Repository repository;

    private Context context;

    public LoginPresenter() {
        this.repository = new Repository(this);
    }

    @Override
    public void setView(LoginContract.view view) {
        this.view = view;
    }

    @Override
    public void sendUserKey(String userKey) {
        repository.postAccessToken(userKey);
    }

    @Override
    public void onSuccess(Object jwt) {
        String userKey = (String) jwt;
        if(TokenManger.read(context) == null){
            TokenManger.save(context, userKey );
        }
    }

    @Override
    public void deleteView() {
        view = null;
    }

}
