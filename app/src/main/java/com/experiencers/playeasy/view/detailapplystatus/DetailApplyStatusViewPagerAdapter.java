package com.experiencers.playeasy.view.detailapplystatus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailApplyStatusViewPagerAdapter extends FragmentStateAdapter implements DetailApplyStatusContract.adapterView, DetailApplyStatusContract.adapterModel {

    private List<Fragment> fragmentList = new ArrayList<>();
    public DetailApplyStatusViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
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
    public void fresh() {
        notifyDataSetChanged();
    }

    @Override
    public void add(List<Fragment> list) {
        fragmentList = list;
    }
}
