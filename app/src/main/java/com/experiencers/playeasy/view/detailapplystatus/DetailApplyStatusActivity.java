package com.experiencers.playeasy.view.detailapplystatus;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.utill.UiHelper;
import com.google.android.material.tabs.TabLayout;

public class DetailApplyStatusActivity extends AppCompatActivity implements DetailApplyStatusContract.view {

    private DetailApplyStatusPresenter presenter;
    private DetailApplyStatusViewPagerAdapter adapter;
    private TabLayout detailApplyStatusTabLayout;
    private ViewPager2 detailApplyViewpager;

    private int matchId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_apply_status);

        init();

        matchId = getIntent().getIntExtra("matchId", 0);

        presenter = new DetailApplyStatusPresenter();
        presenter.setView(this);

        adapter = new DetailApplyStatusViewPagerAdapter(this);
        detailApplyViewpager.setAdapter(adapter);

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        presenter.loadFragment(matchId);
        detailApplyViewpager.setUserInputEnabled(false);

        detailApplyStatusTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

                switch (pos)
                {
                    case 0 :
                        detailApplyViewpager.setCurrentItem(0);
                        break;
                    case 1 :
                        detailApplyViewpager.setCurrentItem(1);
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
        UiHelper.toolBarInitialize(this, findViewById(R.id.detailApplyStatusToolbar));
        UiHelper.hideWindow(this);

        detailApplyStatusTabLayout = findViewById(R.id.detailApplyStatusTabLayout);
        detailApplyViewpager = findViewById(R.id.detailApplyViewpager);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
