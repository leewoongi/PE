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

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;

public class HomeFragment extends Fragment implements HomeContract.view {

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
    public void recyclerViewInit() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void calenderInit() {
        /** end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        /** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(rootView,R.id.horizontalCalendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
    }

    @Override
    public void selectDate() {

    }

    @Override
    public void showResult() {

    }
}
