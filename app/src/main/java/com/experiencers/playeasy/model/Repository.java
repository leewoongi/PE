package com.experiencers.playeasy.model;


import android.util.Log;
import com.experiencers.playeasy.application.RetrofitClient;
import com.experiencers.playeasy.model.datasource.WebService;
import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ChangeMatchStatusRequest;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.LoginRequest;
import com.experiencers.playeasy.model.entity.MapResponse;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.apply.fragment.team.ApplyTeamPresenter;
import com.experiencers.playeasy.view.apply.fragment.user.ApplyUserPresenter;
import com.experiencers.playeasy.view.detailmatch.DetailMatchPresenter;
import com.experiencers.playeasy.view.login.LoginPresenter;
import com.experiencers.playeasy.view.main.fragment.create.CreatePresenter;
import com.experiencers.playeasy.view.main.fragment.home.HomePresenter;
import com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus.MatchApplyPresenter;
import com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register.RegisterPresenter;
import com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel.MatchCancelPresenter;
import com.experiencers.playeasy.view.modifymatch.ModifyMatchPresenter;
import com.experiencers.playeasy.view.myinformation.MyInfoPresenter;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;


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

    //메인화면 매치리스트 불러오기
    public void getMatchList(String date, HomePresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrieveMatchList(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item)->{
                    presenter.onSuccess(item);
                }, throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    //내 정보 불러오기
    public void getUserInformation(String UserKey, MyInfoPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrieveUserInfo(UserKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item) ->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }


    //매치 상세보기
    public void getMatch(int matchId, String userKey, DetailMatchPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrieveMatch(matchId, userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item) ->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    //매치 신청하기 팀
    public void postMatchApplyTeam(String userKey, Apply apply, ApplyTeamPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.sendMatchApply(userKey, apply)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item) ->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    //매치 신청하기 개인
    public void postMatchApplyPersonal(String userKey, Apply apply, ApplyUserPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.sendMatchApply(userKey, apply)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((item) ->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    // 위치 검색
    public void getPlace(String keyWord, String userKey, CreatePresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrievePlace(keyWord, userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(item -> {
                    if (item == null || item.size() == 0) {
                        item.add(new MapResponse());
                    }
                    return item;
                })
                .subscribe((item)->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    // 위치 수정
    public void getModifyPlace(String keyWord, String userKey, ModifyMatchPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrievePlace(keyWord, userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(item -> {
                    if (item == null || item.size() == 0) {
                        item.add(new MapResponse());
                    }
                    return item;
                })
                .subscribe((item)->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    public void postCreateMatch(String userKey, CreateMatchRequest createMatchRequest, CreatePresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.sendCreateMatch(userKey, createMatchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item ->{
                    presenter.CreateSuccess(item);
                },throwable ->{
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },()->{
                    Log.d("onComplete", "nothing");
                });
    }

    /**나의매치**/
    //내가 등록한 매치
    public void getRegisterMyMatch(String userKey, RegisterPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrieveRegisterMatchList(userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(item -> {
                    if (item == null || item.size() == 0) {
                        item.add(new Match());
                    }
                    return item;
                })
                .subscribe(item ->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },() ->{
                    Log.d("onComplete", "nothing");
                });
    }

    //내가 신청한 매치
    public void getApplyMyMatch(String type, String userKey, MatchApplyPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.retrieveApplyMatchList(type, userKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(item -> {
                    if (item == null || item.size() == 0) {
                        item.add(new Match());
                    }
                    return item;
                })
                .subscribe(item->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },() ->{
                    Log.d("onComplete", "nothing");
                });
    }

    //내가 신청한 매치 취소하기
    public void putApplyMatchCancel(String userKey, ChangeMatchStatusRequest changeMatchStatusRequest, MatchCancelPresenter presenter){
        WebService webService = RetrofitClient.getInstance().create(WebService.class);
        Disposable disposable = webService.ModifyApplyStatus(userKey, changeMatchStatusRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item->{
                    presenter.onSuccess(item);
                },throwable -> {
                    Log.d("error", "TT.. " + throwable.getMessage());
                    throwable.printStackTrace();
                },() ->{
                    Log.d("onComplete", "nothing");
                });
    }


}
