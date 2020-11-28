package com.experiencers.playeasy.view.detailapplystatus.fragment.teamStauts;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.ApplyStatusResponse;
import com.experiencers.playeasy.model.entity.ChangeMatchStatusRequest;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

import java.util.List;

public class TeamStatusPresenter implements TeamStatusContract.presenter, RetrofitCallback {

    private TeamStatusContract.view view;
    private Repository repository;
    private TeamStatusContract.adapterView adapterView;
    private TeamStatusContract.adapterModel adapterModel;
    private String userKey;

    public TeamStatusPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(TeamStatusContract.view view) {
        this.view = view;
    }

    @Override
    public void receiveTeamMatch(String userKey, int matchId, String type) {
        this.userKey = userKey;
        repository.getRetrieveTeamApplyMatchList(userKey,matchId, type, this);
    }

    @Override
    public void setRecyclerAdapterView(TeamStatusRecyclerViewAdapter adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void setRecyclerAdapterModel(TeamStatusRecyclerViewAdapter adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void matchOk(int matchId, String status) {
        ChangeMatchStatusRequest changeMatchStatusRequest = new ChangeMatchStatusRequest(matchId, status);
        repository.putApplyMatchTeamOX(userKey,changeMatchStatusRequest,this);
    }

    @Override
    public void matchReject(int matchId, String status) {
        ChangeMatchStatusRequest changeMatchStatusRequest = new ChangeMatchStatusRequest(matchId, status);
        repository.putApplyMatchTeamOX(userKey,changeMatchStatusRequest,this);
    }

    @Override
    public void teamMatchList(Object object) {
        List<ApplyStatusResponse> item = (List<ApplyStatusResponse>) object;

        adapterModel.add(item);
        adapterView.refresh();

    }


    @Override
    public void deleteView() {
        view = null;
    }

    @Override
    public void onSuccess(Object object) {
        ApplyStatusResponse applyStatusResponse = (ApplyStatusResponse) object;
        System.out.println(applyStatusResponse.getStatus());
        String statusType = applyStatusResponse.getStatus();

        if(statusType.equals("CONFIRMED")){
            view.showResult(1);
        }else{
            view.showResult(2);
        }

    }

}
