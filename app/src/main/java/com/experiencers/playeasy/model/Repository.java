package com.experiencers.playeasy.model;


import android.util.Log;

import com.experiencers.playeasy.application.RetrofitClient;
import com.experiencers.playeasy.model.datasource.WebService;
import com.experiencers.playeasy.view.callback.RetrofitCallback;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Repository {

    private RetrofitCallback retrofitCallback;
    public Repository(RetrofitCallback retrofitCallback) {
        this.retrofitCallback = retrofitCallback;
    }

    //카카오 로그인시 accessToken 전송 및 jwt 발급
    public void postAccessToken(String userKey){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.sendAccessToken(userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((jwt) -> {
                    //onSuccess
                    retrofitCallback.onSuccess(jwt.getAccess_token());
                }, throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    // onComplete
                    Log.d("onComplete", "nothing");
                });

    }
}
