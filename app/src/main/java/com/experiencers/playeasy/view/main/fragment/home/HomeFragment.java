package com.experiencers.playeasy.view.main.fragment.home;

import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.experiencers.playeasy.R;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeFragment extends Fragment implements HomeContract.view {

    private HomeContract.presenter presenter;
    private HorizontalCalendar horizontalCalendar;

    private View rootView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeRecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

        init();
        calenderInit();
        recyclerViewInit();

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
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,-1);

        Calendar endDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,1);

        horizontalCalendar = new HorizontalCalendar.Builder(rootView, R.id.horizontalCalendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .textSize(14f, 24f, 14f)
                .showTopText(true)
                .showBottomText(true)
                .end()
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void selectDate() {

    }

    @Override
    public void showResult() {

    }
}
