package com.experiencers.playeasy.view.modifymatch;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.MapResponse;

import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class ModifyMatchActivity extends AppCompatActivity implements ModifyMatchContract.view  {

    private ModifyMatchPresenter presenter;
    private List<MapResponse> modifyMap;
    private AutoCompleteTextView matchModifyLocationMap;
    private String[] modifyMapInfo;
    private TextView mapIdModify;
    private TextView addressNameModify;

    private HorizontalCalendar calendarViewMatchModify;
    private EditText matchModifyDetailMap;
    private TimePicker timePickerStartModify,timePickerEndModify;
    private Button fiveFootSalModify,sixFootSalModify,soccerModify;
    private EditText matchModifyFee;
    private EditText needPeopleModify;
    private EditText matchModifyPhoneNumber;
    private EditText matchModifyEtc;

    private String userKey;
    private String today;
    private int clickResult;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modfiy_match);

        init();

        userKey = TokenManger.read(this);
        presenter = new ModifyMatchPresenter();
        presenter.setView(this);

        calendarViewMatchModify.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                today = convertDate(date);
            }
        });

        matchModifyLocationMap.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String keyWord = s.toString();
                System.out.println("현재 텍스트 : " + keyWord);
                presenter.sendKeyWord(keyWord, userKey);

            }
        });

    }

    @Override
    public void init() {
        matchModifyLocationMap = findViewById(R.id.matchModifyLocationMap);
        matchModifyDetailMap = findViewById(R.id.matchModifyDetailMap);
        timePickerStartModify = findViewById(R.id.timePickerStartModify);
        timePickerEndModify = findViewById(R.id.timePickerEndModify);
        fiveFootSalModify = findViewById(R.id.fiveFootSalModify);
        sixFootSalModify = findViewById(R.id.sixFootSalModify);
        soccerModify = findViewById(R.id.soccerModify);
        matchModifyFee = findViewById(R.id.matchModifyFee);
        needPeopleModify = findViewById(R.id.needPeopleModify);
        matchModifyPhoneNumber = findViewById(R.id.matchModifyPhoneNumber);
        matchModifyEtc = findViewById(R.id.matchModifyEtc);
        mapIdModify = findViewById(R.id.mapIdModify);
        addressNameModify = findViewById(R.id.addressNameModify);
    }

    @Override
    public void calendarInit() {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        calendarViewMatchModify = new HorizontalCalendar.Builder(this, R.id.calendarViewMatchModify)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
    }

    @Override
    public String convertDate(Calendar date) {
        return null;
    }

    @Override
    public String convertSTime() {
        return null;
    }

    @Override
    public String convertETime() {
        return null;
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
