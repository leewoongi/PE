package com.experiencers.playeasy.view.login;

import android.content.Context;

import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class LoginPresenter implements LoginContract.presenter, RetrofitCallback {

    private LoginContract.view view;
    private Repository repository;
    private Context mContext;


    public LoginPresenter() {
        this.repository = new Repository();
    }

    @Override
    public void setView(LoginContract.view view) {
        this.view = view;
    }

    @Override
    public void setView(LoginContract.view view, Context context) {
        this.view = view;
        this.mContext = context;
    }

    @Override
    public void sendUserKey(String access_token, LoginContract.presenter presenter) {
        repository.postAccessToken(access_token, this);
    }


    @Override
    public void onSuccess(Object jwt) {
        int result = 0;
        String tmp = TokenManger.read(mContext);
        if(TokenManger.read(mContext).length() == 0){
            String key = (String) jwt;
            TokenManger.save(mContext, key);
        }else{
            result = 1;
        }

        view.changeActivity(result);
    }

    @Override
    public void deleteView() {
        view = null;
    }

}
