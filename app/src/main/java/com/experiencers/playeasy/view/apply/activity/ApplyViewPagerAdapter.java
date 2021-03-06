package com.experiencers.playeasy.view.apply.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ApplyViewPagerAdapter extends FragmentStateAdapter implements ApplyContract.adapterView, ApplyContract.adapterModel{

    private List<Fragment> fragmentList = new ArrayList<>();

    public ApplyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
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
