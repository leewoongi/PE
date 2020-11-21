package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

import java.util.List;

public class RegisterPresenter implements RegisterContract.presenter, RetrofitCallback {

    private RegisterContract.view view;
    private RegisterContract.adapterView adapterView;
    private RegisterContract.adapterModel adapterModel;
    private Repository repository;
    public RegisterPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(RegisterContract.view view) {
        this.view = view;
    }


    @Override
    public void setRecyclerAdapterView(RegisterRecyclerViewAdapter adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setRecyclerAdapterModel(RegisterRecyclerViewAdapter adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void receiveMatchList(String userKey) {
        repository.getRegisterMyMatch(userKey, this);
    }


    @Override
    public void onSuccess(Object object) {
        List<Match> list = (List<Match>) object;
        adapterModel.add(list);
        adapterView.refresh();
    }

    @Override
    public void deleteView() {
        view = null;
    }
}
