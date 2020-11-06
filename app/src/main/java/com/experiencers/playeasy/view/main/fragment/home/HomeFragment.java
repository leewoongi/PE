package com.experiencers.playeasy.view.main.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.R;

public class HomeFragment extends Fragment implements HomeContract.view {

    private HomeContract.presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

        presenter.setView(this);
        return rootView;
    }

    @Override
    public void init() {

    }

    @Override
    public void showResult() {

    }
}
