package com.experiencers.playeasy.view.main.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.view, BottomNavigationView.OnNavigationItemSelectedListener {

    private MainContract.presenter presenter;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    private Fragment switching;
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
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public void showResult() {

    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
        viewPager = findViewById(R.id.mainViewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switching = presenter.changeFragment(item.getItemId());
        getSupportFragmentManager().beginTransaction().replace(R.id.mainViewPager,switching);
        getSupportFragmentManager().beginTransaction().commit();
        return true;
    }
}