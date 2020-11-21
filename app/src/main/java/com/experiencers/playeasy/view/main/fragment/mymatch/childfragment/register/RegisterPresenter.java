package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class RegisterPresenter implements RegisterContract.presenter, RetrofitCallback {

    private RegisterContract.view view;

    public RegisterPresenter() {

    }

    @Override
    public void setView(RegisterContract.view view) {
        this.view = view;
    }



    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void deleteView() {
        view = null;
    }
}
