package com.experiencers.playeasy.model;


import android.util.Log;
import com.experiencers.playeasy.application.RetrofitClient;
import com.experiencers.playeasy.model.datasource.WebService;
import com.experiencers.playeasy.model.entity.LoginRequest;
import com.experiencers.playeasy.view.login.LoginPresenter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Repository {

    public Repository() {

    }

    //카카오 로그인시 accessToken 전송 및 jwt 발급
    public void postAccessToken(String access_token, LoginPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.sendAccessToken(new LoginRequest(access_token))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item) -> {
                    //onSuccess
                    presenter.onSuccess(item.getToken());
                }, throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    // onComplete
                    Log.d("onComplete", "nothing");
                });

    }
}
