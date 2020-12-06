package com.experiencers.playeasy.view.detailmatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.utill.UiHelper;
import com.experiencers.playeasy.view.apply.activity.ApplyActivity;
import com.google.android.material.button.MaterialButton;

public class DetailMatchActivity extends AppCompatActivity implements DetailMatchContract.view {

    private DetailMatchPresenter presenter;

    private TextView detailTeamName;
    private TextView detailPlace;
    private TextView detailLocation;
    private TextView detailType;
    private TextView detailFee;
    private TextView detailPhone;
    private TextView detailEtc;
    private MaterialButton detailApplyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_match);

        init();

        presenter = new DetailMatchPresenter();
        presenter.setView(this);

        int matchId = Integer.valueOf(getIntent().getStringExtra("matchId"));
        String userKey = TokenManger.read(getApplicationContext());
        presenter.receiveMatchId(matchId,userKey);

        detailApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickApply(matchId);
            }
        });
    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);

        detailTeamName = findViewById(R.id.detailTeamName);
        detailPlace = findViewById(R.id.detailPlace);
        detailLocation = findViewById(R.id.detailLocation);
        detailType = findViewById(R.id.detailType);
        detailFee = findViewById(R.id.detailFee);
        detailPhone = findViewById(R.id.detailPhone);
        detailEtc = findViewById(R.id.detailEtc);
        detailApplyButton = findViewById(R.id.detailApplyButton);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showPopUp(int matchId) {
        Intent intent = new Intent(this, ApplyActivity.class);
        intent.putExtra("matchId",matchId);
        startActivity(intent);
    }

    @Override
    public void showResult(Object object) {
        Match item = (Match) object;
        detailTeamName.setText(item.getTeamName());
        detailPlace.setText(item.getLocation().getPlaceName() + " " +item.getLocation().getPlaceDetail());
        detailLocation.setText(item.getLocation().getAddressName());
        if(item.getType().equals("FUTSAL5")){
            detailType.setText("풋살 5 : 5");
        }else if(item.getType().equals("FUTSAL6")){
            detailType.setText("풋살 6 : 6");
        }else{
            detailType.setText("축구 11 : 11");
        }

        detailFee.setText(String.valueOf(item.getFee()) + " 원");
        detailPhone.setText(item.getPhone());
        detailEtc.setText(item.getDescription());
    }
}
