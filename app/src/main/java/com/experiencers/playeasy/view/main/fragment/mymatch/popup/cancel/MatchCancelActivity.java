package com.experiencers.playeasy.view.main.fragment.mymatch.popup.cancel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;

public class MatchCancelActivity extends AppCompatActivity implements MatchCancelContract.view, View.OnClickListener {

    private MatchCancelPresenter presenter;
    private Button cancelX;
    private Button cancelOk;
    private Button cancelBack;
    private String userKey;
    private int matchId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_cancel_popup);

        init();
        userKey = TokenManger.read(getApplicationContext());
        matchId = getIntent().getIntExtra("matchId",0);

        presenter = new MatchCancelPresenter();
        presenter.setView(this);

        cancelX.setOnClickListener(this);
        cancelOk.setOnClickListener(this);
        cancelBack.setOnClickListener(this);

    }

    @Override
    public void init() {
        cancelX = findViewById(R.id.cancelX);
        cancelOk = findViewById(R.id.cancelOk);
        cancelBack = findViewById(R.id.cancelBack);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {
        Toast.makeText(getApplicationContext(),"신청이 취소 되었습니다", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancelX:
                finish();
                break;
            case R.id.cancelOk:
                presenter.sendCancelStatus(userKey, matchId, "CANCEL");
                break;
            case R.id.cancelBack:
                finish();
                break;
        }
    }
}
