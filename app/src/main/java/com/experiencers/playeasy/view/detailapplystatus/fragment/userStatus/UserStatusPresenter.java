package com.experiencers.playeasy.view.detailapplystatus.fragment.userStatus;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

import java.util.List;

public class UserStatusPresenter implements UserStatusContract.presenter, RetrofitCallback {

    private UserStatusContract.view view;
    private Repository repository;
    private UserStatusContract.adapterView adapterView;
    private UserStatusContract.adapterModel adapterModel;

    public UserStatusPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(UserStatusContract.view view) {
        this.view = view;
    }

    @Override
    public void receiveUserMatch(String userKey, int matchId, String type) {
        repository.getRetrieveUserApplyMatchList(userKey, matchId, type, this);
    }

    @Override
    public void setRecyclerAdapterView(UserStatusRecyclerViewAdapter adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setRecyclerAdapterModel(UserStatusRecyclerViewAdapter adapterModel) {
        this.adapterModel = adapterModel;
    }


    @Override
    public void onSuccess(Object object) {
        List<ApplyStatusResponse> item = (List<ApplyStatusResponse>) object;

        adapterModel.add(item);
        adapterView.refresh();

    }

    @Override
    public void deleteView() {
        view = null;
    }
}
