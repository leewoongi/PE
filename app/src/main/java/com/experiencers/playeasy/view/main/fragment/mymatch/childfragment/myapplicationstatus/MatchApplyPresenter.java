package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

import java.util.List;

public class MatchApplyPresenter implements MatchApplyContract.presenter, RetrofitCallback {

    private MatchApplyContract.view view;

    private MatchApplyContract.adapterView adapterView;
    private MatchApplyContract.adapterModel adapterModel;
    private Repository repository;

    public MatchApplyPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(MatchApplyContract.view view) {
        this.view = view;
    }

    @Override
    public void setRecyclerAdapterView(MatchApplyRecyclerViewAdapter adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setRecyclerAdapterModel(MatchApplyRecyclerViewAdapter adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void sendType(String type, String userKey) {
        repository.getApplyMyMatch(type, userKey, this);
    }

    @Override
    public void onSuccess(Object object) {
        List<Match> list = (List<Match>) object;
        adapterModel.add(list);
        adapterView.refresh();
    }

    @Override
    public void deleteView() {

    }
}
