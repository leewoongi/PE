package com.experiencers.playeasy.view.myinformation;

import com.experiencers.playeasy.R;

public class MyInfoPresenter implements MyInfoContract.presenter{

    private MyInfoContract.view view;
    public MyInfoPresenter() {
    }

    @Override
    public void setView(MyInfoContract.view view) {
        this.view = view;
    }

    @Override
    public void confirmButtonClick(int itemId) {
        switch (itemId) {
            case R.id.confirm_button:
                // 서버 통신 부분
                view.changeActivity();
                break;
        }
    }

    @Override
    public void deleteView() {
        view = null;
    }
}
