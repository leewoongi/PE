package com.experiencers.playeasy.view.main.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.HorizontalCalendarManager;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeFragment extends Fragment implements HomeContract.view{

    private HomeContract.presenter presenter;

    private View rootView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_fragment, container, false);

        init();
        recyclerViewInit();
        calenderInit();

        presenter = new HomePresenter();
        presenter.setView(this);

        presenter.setAdapterView(adapter);
        presenter.setAdapterModel(adapter);

        return rootView;
    }

    @Override
    public void init() {
        recyclerView = rootView.findViewById(R.id.homeItem);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        adapter = new HomeRecyclerAdapter();
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void recyclerViewInit() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void calenderInit() {
        HorizontalCalendarListener listener = null;
        HorizontalCalendarManager.initialize(rootView, listener);
    }

    @Override
    public void selectDate() {

    }

    @Override
    public void showResult() {

    }


}
