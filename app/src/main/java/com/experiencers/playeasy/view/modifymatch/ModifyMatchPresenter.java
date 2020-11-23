package com.experiencers.playeasy.view.modifymatch;

import com.experiencers.playeasy.model.Repository;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.model.entity.ModifyMatchRequest;
import com.experiencers.playeasy.view.callback.RetrofitCallback;

public class ModifyMatchPresenter implements ModifyMatchContract.presenter, RetrofitCallback {

    private ModifyMatchContract.view view;
    private Repository repository;
    public ModifyMatchPresenter() {
        repository = new Repository();
    }

    @Override
    public void setView(ModifyMatchContract.view view) {
        this.view = view;
    }

    // 작성된거 가져오기
    @Override
    public void retrieveMatchInfo(String userKey, int matchId) {
        repository.getModifyMatch(matchId, userKey, this);
    }
    @Override
    public void onSuccess(Object object) {
        view.showResult(object);
    }

    //지도 위치
    @Override
    public void sendKeyWord(String word, String userKey) {
        repository.getModifyPlace(word, userKey, this);
    }
    // 위치 변경 성공
    public void searchMap(Object object){
        view.showMap(object);
    }


    // 수정한거 보내기
    @Override
    public void sendMatchInfo(String userKey, ModifyMatchRequest modifyMatchRequest) {
        repository.putMatch(userKey, modifyMatchRequest, this);
    }
    // 수정 성공
    public void putSuccess(Object object){
        view.changeActivity();
    }

    @Override
    public void deleteView() {
        view = null;
    }
}
