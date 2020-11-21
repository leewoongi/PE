package com.experiencers.playeasy.view.main.fragment.mymatch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyMatchViewPagerAdapter extends FragmentStateAdapter implements MyMatchContract.adapterView, MyMatchContract.adapterModel {

    public MyMatchViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void add(List<Fragment> fragments) {

    }
}
