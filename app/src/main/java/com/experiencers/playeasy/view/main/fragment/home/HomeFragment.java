package com.experiencers.playeasy.view.main.fragment.home;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.experiencers.playeasy.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HomeFragment extends Fragment implements HomeContract.view {

    private HomeContract.presenter presenter;
    private ViewGroup rootView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeRecyclerAdapter adapter;
    private HorizontalCalendar horizontalCalendar;

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
    public void showResult(Object object) {

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
        // 현재 날짜 받아오기
        startDate.add(Calendar.MONTH, -1);

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH,1);

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
                presenter.receiveDate(date, presenter);
            }
        });

    }


}
