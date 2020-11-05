package com.experiencers.playeasy.view.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.experiencers.playeasy.R;

public class MainActivity extends AppCompatActivity implements MainContract.view {

    private MainContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.setView(this);
    }

    @Override
    public void showResult() {

    }
}