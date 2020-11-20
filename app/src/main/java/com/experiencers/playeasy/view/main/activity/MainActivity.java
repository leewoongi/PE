package com.experiencers.playeasy.view.main.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.view, BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private MainContract.presenter presenter;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        presenter = new MainPresenter();
        presenter.setView(this);

        mainViewPagerAdapter = new MainViewPagerAdapter(this);
        viewPager.setAdapter(mainViewPagerAdapter);

        presenter.setViewPagerView(mainViewPagerAdapter);
        presenter.setViewPagerModel(mainViewPagerAdapter);

        presenter.loadFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }


    @Override
    public void showResult(Object object) {

    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
        viewPager = findViewById(R.id.mainViewPager);
        viewPager.setUserInputEnabled(false);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int num = presenter.changeFragment(item.getItemId());
        viewPager.setCurrentItem(num);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                break;
            case 1:
                bottomNavigationView.getMenu().findItem(R.id.register).setChecked(true);
                break;
            case 2:
                bottomNavigationView.getMenu().findItem(R.id.myMatch).setChecked(true);
                break;
            case 3:
                bottomNavigationView.getMenu().findItem(R.id.myPage).setChecked(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}