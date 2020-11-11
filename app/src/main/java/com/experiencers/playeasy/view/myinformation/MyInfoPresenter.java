package com.experiencers.playeasy.view.myinformation;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.model.Repository;
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
    public void confirmButtonClick(int itemId, String userKey) {
        switch (itemId) {
            case R.id.confirm_button:
                // 서버 통신 부분
                repository.getUserInformation(userKey, this);
                view.changeActivity();
                break;
        }
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
