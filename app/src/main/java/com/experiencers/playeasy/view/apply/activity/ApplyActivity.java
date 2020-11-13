package com.experiencers.playeasy.view.apply.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;

public class ApplyActivity extends AppCompatActivity implements ApplyContract.view {
    private ApplyPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
        UiHelper.toolBarInitialize(this, findViewById(R.id.applyToolbar));
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
