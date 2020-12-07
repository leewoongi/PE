package com.experiencers.playeasy.view.apply.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;
import com.google.android.material.tabs.TabLayout;

public class ApplyActivity extends AppCompatActivity implements ApplyContract.view {
    private ApplyPresenter presenter;
    private ViewPager2 viewPager;
    private ApplyViewPagerAdapter applyViewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        init();

        applyViewPagerAdapter = new ApplyViewPagerAdapter(this);
        viewPager.setAdapter(applyViewPagerAdapter);

        presenter = new ApplyPresenter();
        presenter.setView(this);

        presenter.setViewpagerView(applyViewPagerAdapter);
        presenter.setViewPagerModel(applyViewPagerAdapter);

        int matchId = getIntent().getIntExtra("matchId",0);

        presenter.loadFragment(matchId);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                switch (pos)
                {
                    case 0 :
                        viewPager.setCurrentItem(0);
                        break;
                    case 1 :
                        viewPager.setCurrentItem(1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    @Override
    public void init() {
        UiHelper.hideWindow(this);

        viewPager = findViewById(R.id.applyViewPager);
        viewPager.setUserInputEnabled(false);

        tabLayout = findViewById(R.id.applyTab);

    }


    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
