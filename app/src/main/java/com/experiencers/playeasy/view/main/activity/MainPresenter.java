package com.experiencers.playeasy.view.main.activity;

import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.view.main.fragment.create.CreateFragment;
import com.experiencers.playeasy.view.main.fragment.home.HomeFragment;
import com.experiencers.playeasy.view.main.fragment.mypage.MyPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.presenter{

    private MainContract.view view;
    private MainContract.adapterView adapterView;
    private MainContract.adapterModel adapterModel;

    private HomeFragment homeFragment;
    private MyPageFragment myPageFragment;
    private CreateFragment createFragment;

    public MainPresenter() {
        homeFragment = new HomeFragment();
        myPageFragment = new MyPageFragment();
        createFragment = new CreateFragment();
    }

    @Override
    public void setView(MainContract.view view) {
        this.view = view;
    }

    @Override
    public void setViewPagerView(MainViewPagerAdapter mainViewPagerAdapter) {
        this.adapterView = mainViewPagerAdapter;
    }

    @Override
    public void setViewPagerModel(MainViewPagerAdapter mainViewPagerAdapter) {
        this.adapterModel = mainViewPagerAdapter;
    }

    @Override
    public void loadFragment() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(createFragment);
        fragments.add(myPageFragment);

        adapterModel.add(fragments);
        adapterView.refresh();
    }

    @Override
    public int changeFragment(int fragmentId) {
        switch (fragmentId){
            case R.id.home:
                return 0;
            case R.id.register:
                return 1;
            case R.id.myMatch:
                return 2;
            case R.id.myPage:
                return 3;
        }
        return 0;
    }


    @Override
    public void deleteView() {

    }
}
