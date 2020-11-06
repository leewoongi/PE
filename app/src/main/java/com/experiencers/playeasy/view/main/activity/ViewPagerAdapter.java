package com.experiencers.playeasy.view.main.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter implements MainContract.adapterView, MainContract.adapterModel {

    private List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull MainActivity fragment) {
        super(fragment);
    }



    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void add(List<Fragment> item) {
        fragmentList = item;
    }

    @Override
    public void remove() {

    }

    @Override
    public void getItem() {

    }
}
