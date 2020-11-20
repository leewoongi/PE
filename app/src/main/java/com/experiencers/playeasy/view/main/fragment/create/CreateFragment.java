package com.experiencers.playeasy.view.main.fragment.create;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.MapResponse;
import com.experiencers.playeasy.utill.UiHelper;
import com.experiencers.playeasy.view.main.activity.MainActivity;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class CreateFragment extends Fragment implements CreateContract.view, View.OnClickListener, AdapterView.OnItemClickListener {

    private CreatePresenter presenter;
    private ViewGroup rootView;
    private String userKey;

    private List<MapResponse> map;
    private AutoCompleteTextView matchLocationMap;
    private String[] mapInfo;
    private TextView mapId;
    private TextView addressName;

    private HorizontalCalendar horizontalCalendar;
    private EditText matchDetailMap;
    private TimePicker timePickerStart,timePickerEnd;
    private Button fiveFootSal,sixFootSal,soccer;
    private EditText matchFee;
    private EditText needPeople;
    private EditText matchPhoneNumber;
    private EditText matchEtc;
    private String today;
    private int clickResult;
    private String type;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_create, container, false);
        setHasOptionsMenu(true);

        init();
        calendarInit();

        userKey = TokenManger.read(rootView.getContext());
        presenter = new CreatePresenter();
        presenter.setView(this);

        matchLocationMap.setOnItemClickListener(this);
        fiveFootSal.setOnClickListener(this);
        sixFootSal.setOnClickListener(this);
        soccer.setOnClickListener(this);

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                today = convertDate(date);
            }
        });

        matchLocationMap.addTextChangedListener(new TextWatcher() {
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

        return rootView;
    }

    @Override
    public void init() {
        matchLocationMap = rootView.findViewById(R.id.matchLocationMap);
        matchDetailMap = rootView.findViewById(R.id.matchDetailMap);
        timePickerStart = rootView.findViewById(R.id.timePickerStart);
        timePickerEnd = rootView.findViewById(R.id.timePickerEnd);
        fiveFootSal = rootView.findViewById(R.id.fiveFootSal);
        sixFootSal = rootView.findViewById(R.id.sixFootSal);
        soccer = rootView.findViewById(R.id.soccer);
        matchFee = rootView.findViewById(R.id.matchFee);
        needPeople = rootView.findViewById(R.id.needPeople);
        matchPhoneNumber = rootView.findViewById(R.id.matchPhoneNumber);
        matchEtc = rootView.findViewById(R.id.matchEtc);
        mapId = rootView.findViewById(R.id.mapId);
        addressName = rootView.findViewById(R.id.addressName);
        UiHelper.toolBarInitialize((AppCompatActivity) getActivity(), rootView.findViewById(R.id.matchCreateToolBar));
    }

    @Override
    public void calendarInit() {

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        horizontalCalendar = new HorizontalCalendar.Builder(rootView, R.id.calendarViewMatchCreate)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

    }

    @Override
    public String convertDate(Calendar date) {
        String matchDay = "";
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH) + 1;
        int year = date.get(Calendar.YEAR);

        if (month <= 9) {
            matchDay = year + "-0" + month;

        } else {
            matchDay = year + "-" + month;
        }

        if(day <= 9) {
            matchDay = matchDay + "-0" + day;
        } else{
            matchDay = matchDay + "-" + day;
        }
        return matchDay;
    }

    @Override
    public String convertSTime() {
        String s = "";
        if(timePickerStart.getHour() > 10){
            s = String.valueOf(timePickerStart.getHour())+":";
        }else{
            s = "0"+ String.valueOf(timePickerStart.getHour()+":");
        }

        if(timePickerStart.getMinute() > 10){
            s = s + String.valueOf(timePickerStart.getMinute());
        }else{
            s = s + "0" +  String.valueOf(timePickerStart.getMinute());
        }

        s = s+":"+"00";
        return s;
    }

    @Override
    public String convertETime() {
        String s = "";
        if(timePickerEnd.getHour() > 10){
            s = String.valueOf(timePickerEnd.getHour())+":";
        }else{
            s = "0"+ String.valueOf(timePickerEnd.getHour()+":");
        }

        if(timePickerEnd.getMinute() > 10){
            s = s + String.valueOf(timePickerEnd.getMinute());
        }else{
            s = s + "0" +  String.valueOf(timePickerEnd.getMinute());
        }

        s = s+":"+"00";
        return s;
    }


    @Override
    public void changeActivity() {
        Toast.makeText(getActivity(), "매치가 작성되었습니다.", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.confirm, menu);
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String startTime = today + "T" + convertSTime();
        String endTime = today + "T" + convertETime();

        CreateMatchRequest matchRequest = new CreateMatchRequest(type, matchEtc.getText().toString(), startTime,
                endTime, Integer.parseInt(matchFee.getText().toString()),matchPhoneNumber.getText().toString(),
                Integer.parseInt(needPeople.getText().toString()), Integer.parseInt(mapId.getText().toString()),
                matchLocationMap.getText().toString(),addressName.getText().toString(), matchDetailMap.getText().toString());

        presenter.sendMatchInfo(userKey, matchRequest);
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //autocompleteview 의 아이템 클릭될시시
        mapId.setText(String.valueOf(map.get(position).getId()));
        addressName.setText(map.get(position).getAddress_name());
    }

    @Override
    public void onClick(View v) {
        //매치타입 선택할때
        switch (v.getId()){
            case R.id.fiveFootSal:
                if(clickResult != 2 || clickResult != 3){
                    clickResult = 1;
                    type = "FUTSAL5";
                    sixFootSal.setEnabled(false);
                    soccer.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    sixFootSal.setEnabled(true);
                    soccer.setEnabled(true);
                }
                break;
            case R.id.sixFootSal:
                if(clickResult != 1 || clickResult != 3){
                    clickResult = 2;
                    type = "FUTSAL6";
                    fiveFootSal.setEnabled(false);
                    soccer.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    fiveFootSal.setEnabled(true);
                    soccer.setEnabled(true);
                }
                break;
            case R.id.soccer:
                if(clickResult != 1 || clickResult != 2){
                    clickResult = 3;
                    type = "SOCCER";
                    fiveFootSal.setEnabled(false);
                    sixFootSal.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    fiveFootSal.setEnabled(true);
                    sixFootSal.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void showResult(Object object) {
        map = (List<MapResponse>) object;

        mapInfo = new String[10];
        Arrays.fill(mapInfo, "");

        if(map.size() > 10){
            for (int i = 0; i < 10; ++i) {
                mapInfo[i] = map.get(i).getPlace_name();
            }
        }else{

            for (int i = 0; i < map.size(); ++i) {
                mapInfo[i] = map.get(i).getPlace_name();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,mapInfo);
        matchLocationMap.setAdapter(adapter);
        matchLocationMap.setDropDownAnchor(matchLocationMap.getId());
        matchLocationMap.showDropDown();
    }
}
