package com.experiencers.playeasy.view.main.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;

public class MainActivity extends AppCompatActivity implements MainContract.view {

    private MainContract.presenter presenter;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        viewPagerAdapter = new ViewPagerAdapter(this);

        presenter.setView(this);

        presenter.setViewPagerView(viewPagerAdapter);
        presenter.setViewPagerModel(viewPagerAdapter);

        init();

    }

    @Override
    public void showResult() {

    }

    @Override
    public void init() {
        UiHelper.toolBarInitialize(this, findViewById(R.id.mainToolbar));
        UiHelper.hideWindow(this);
    }

}