package com.experiencers.playeasy.view.main.fragment.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.RecyclerViewDeco;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeFragment extends Fragment implements HomeContract.view {

    private HomeContract.presenter presenter;
    private View rootView;
    private TextView matchMonth;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeRecyclerAdapter adapter;
    private HorizontalCalendar horizontalCalendar;
    private String nowDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        init();
        calenderInit();
        recyclerViewInit();
        findDate();

        presenter = new HomePresenter();
        presenter.setView(this);

        presenter.setAdapterView(adapter);
        presenter.setAdapterModel(adapter);

        presenter.initMatchList(nowDate, presenter);


        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                dateInit(date);
                presenter.receiveDate(date, presenter);
            }
        });

        return rootView;
    }

    private void dateInit(Calendar date) {
        int month = date.get(Calendar.MONTH) + 1;
        matchMonth.setText(month + "월");
    }

    @Override
    public void showResult(Object object) {

    }

    @Override
    public void init() {
        matchMonth = rootView.findViewById(R.id.matchMonth);
        recyclerView = rootView.findViewById(R.id.homeItem);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        adapter = new HomeRecyclerAdapter();

        GregorianCalendar today = new GregorianCalendar();
        int Month = today.get(Calendar.MONTH);
        matchMonth.setText((Month + 1) + "월");
    }

    @Override
    public void findDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        nowDate = format.format(date);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void recyclerViewInit() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerViewDeco(30));
    }

    @Override
    public void calenderInit() {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, 0);

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH,11);

        horizontalCalendar = new HorizontalCalendar.Builder(rootView, R.id.horizontalCalendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                    .showTopText(false)
                    .selectedDateBackground(rootView.getContext().getDrawable(R.drawable.calendar_round_corner))
                    .selectorColor(Color.TRANSPARENT)
                    .sizeBottomText(15)
                    .sizeBottomText(15)
                    .end()
                .build();
    }


}
