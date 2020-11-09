package com.experiencers.playeasy.view.landing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.utill.UiHelper;
import com.experiencers.playeasy.view.login.LoginActivity;
import com.experiencers.playeasy.view.main.activity.MainActivity;

public class LandingActivity extends AppCompatActivity implements LandingContract.view {

    private LandingContract.presenter presenter;
    private Handler handler;
    private Runnable runnable;

    //jwt 키
    public static String userKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        init();

        presenter = new LandingPresenter();
        presenter.setView(this);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                changeActivity();
            }
        };

    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
    }

    @Override
    public void changeActivity() {
        Intent intent;
        String key = TokenManger.read(getApplicationContext());
        Log.d("토큰값", key);

        if(key == ""){
            intent = new Intent(getApplicationContext(), LoginActivity.class);
        }else{
            intent = new Intent(getApplicationContext(), MainActivity.class);
        }

        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        finish();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        handler.postDelayed(runnable, 2500);

    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void showResult() {

    }
}
