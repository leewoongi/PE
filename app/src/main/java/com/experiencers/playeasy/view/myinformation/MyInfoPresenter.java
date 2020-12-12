package com.experiencers.playeasy.view.myinformation;

import android.content.Intent;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.User;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class MyInfoPresenter implements MyInfoContract.presenter, RetrofitCallback {

    private MyInfoContract.view view;
    private Repository repository;
    public MyInfoPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(MyInfoContract.view view) {
        this.view = view;
    }

    @Override
    public void setUserInfo(String userKey) {
        repository.getUserInformation(userKey, this);
    }

    @Override
    public void confirmButtonClick(int itemId, String userKey, User user) {
        switch (itemId) {
            case R.id.confirm_button:
                // 서버 통신 부분
                repository.putUserInformation(userKey, user, this);
                view.changeActivity();
                break;
        }
    }

    @Override
    public void getUserImage() {
        // TODO 사진 업데이트 하기
        /*Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);*/
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
