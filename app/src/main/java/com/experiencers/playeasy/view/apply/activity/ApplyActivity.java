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

        popUpInit();
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
    public void popUpInit() {
        // 팝업이 올라오면 배경 블러처리
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.1f;
        getWindow().setAttributes(layoutParams);
        // 레이아웃 설정
        setContentView(R.layout.activity_apply);
        // 사이즈조절
        // 1. 디스플레이 화면 사이즈 구하기
        Display dp = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        // 2. 화면 비율 설정
        int width = (int)(dp.getWidth());
        int height = (int)(dp.getHeight()*0.6);
        // 3. 현재 화면에 적용
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
