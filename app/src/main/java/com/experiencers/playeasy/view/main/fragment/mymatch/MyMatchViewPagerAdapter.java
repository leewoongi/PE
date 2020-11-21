package com.experiencers.playeasy.view.main.fragment.mymatch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.experiencers.playeasy.view.main.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MyMatchViewPagerAdapter extends FragmentStateAdapter implements MyMatchContract.adapterView, MyMatchContract.adapterModel {

    private List<Fragment> fragmentList = new ArrayList<>();

    public MyMatchViewPagerAdapter(@NonNull MyMatchFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override
    public void add(List<Fragment> fragments) {
        fragmentList = fragments;
    }
}
