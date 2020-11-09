package com.experiencers.playeasy.view.myinformation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.view.main.activity.MainActivity;

public class MyInfoActivity extends AppCompatActivity implements MyInfoContract.view{

    private MyInfoContract.presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinformation);

        presenter = new MyInfoPresenter();
        presenter.setView(this);
    }

    @Override
    public void init() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        presenter.confirmButtonClick(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showResult() {

    }
}
