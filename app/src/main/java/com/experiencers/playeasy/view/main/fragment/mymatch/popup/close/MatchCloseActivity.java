package com.experiencers.playeasy.view.main.fragment.mymatch.popup.close;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;

public class MatchCloseActivity extends AppCompatActivity implements MatchCloseContract.view, View.OnClickListener {

    private MatchClosePresenter presenter;
    private Button closeCancelX;
    private Button closeMatchOk;
    private Button closeCancel;

    private String userKey;
    private int matchId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_match_close_popup);

        init();

        userKey = TokenManger.read(getApplicationContext());
        matchId = getIntent().getIntExtra("matchId",0);

        presenter = new MatchClosePresenter();
        presenter.setView(this);

        closeCancel.setOnClickListener(this);
        closeMatchOk.setOnClickListener(this);
        closeCancelX.setOnClickListener(this);
    }

    @Override
    public void init() {
        closeCancelX = findViewById(R.id.closeCancelX);
        closeMatchOk = findViewById(R.id.closeMatchOk);
        closeCancel = findViewById(R.id.closeCancel);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {
        int showType = (int) object;
        if(showType == 1){
            Toast.makeText(this, "매치를 마감 했습니다.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "매치를 취소 했습니다.", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.closeCancelX:
                finish();
                break;
            case R.id.closeMatchOk:
                presenter.sendCloseMatch(userKey, matchId, "CONFIRMED");
                break;
            case R.id.closeCancel:
                presenter.sendDeleteMatch(userKey, matchId, "CANCEL");
                break;
        }
    }
}
