package com.experiencers.playeasy.view.main.fragment.mymatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.experiencers.playeasy.R;
import com.google.android.material.tabs.TabLayout;

public class MyMatchFragment extends Fragment implements MyMatchContract.view{

    private MyMatchPresenter presenter;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private MyMatchViewPagerAdapter myMatchViewPagerAdapter;
    private ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mymatch, container, false);

        init();

        myMatchViewPagerAdapter = new MyMatchViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        presenter = new MyMatchPresenter();
        presenter.setView(this);

        presenter.setPageAdapterView(myMatchViewPagerAdapter);
        presenter.setPageAdapterModel(myMatchViewPagerAdapter);

        presenter.loadFragment();
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
        return rootView;
    }

    @Override
    public void init() {
        viewPager = rootView.findViewById(R.id.myMatchViewpager);
        viewPager.setUserInputEnabled(false);
        tabLayout = rootView.findViewById(R.id.myMatchTab);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
