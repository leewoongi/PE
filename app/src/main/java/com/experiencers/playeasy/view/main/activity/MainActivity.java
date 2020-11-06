package com.experiencers.playeasy.view.main.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;

public class MainActivity extends FragmentActivity implements MainContract.view {

    private MainContract.presenter presenter;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        presenter = new MainPresenter();
        presenter.setView(this);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        presenter.setViewPagerView(viewPagerAdapter);
        presenter.setViewPagerModel(viewPagerAdapter);

        presenter.loadFragment();



    }

    @Override
    public void showResult() {

    }

    @Override
    public void init() {
        viewPager = findViewById(R.id.mainViewPager);
    }

}