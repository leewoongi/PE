package com.experiencers.playeasy.application;

import android.app.Activity;
import android.view.View;

import com.experiencers.playeasy.R;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HorizontalCalendarManager {

    public static void initialize(View view, HorizontalCalendarListener listener){
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,-1);

        Calendar endDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.horizontalCalendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(listener);
    }
}
