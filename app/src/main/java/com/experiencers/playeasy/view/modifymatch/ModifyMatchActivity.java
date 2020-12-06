package com.experiencers.playeasy.view.modifymatch;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.CreateMatchRequest;
import com.experiencers.playeasy.model.entity.MapResponse;
import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.model.entity.ModifyMatchRequest;
import com.experiencers.playeasy.utill.UiHelper;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class ModifyMatchActivity extends AppCompatActivity implements ModifyMatchContract.view, View.OnClickListener, AdapterView.OnItemClickListener  {

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
    private int matchId;
    private String today;
    private int clickResult;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modfiy_match);

        init();
        calendarInit();

        userKey = TokenManger.read(this);
        matchId = getIntent().getIntExtra("matchId", 0);

        presenter = new ModifyMatchPresenter();
        presenter.setView(this);
        presenter.retrieveMatchInfo(userKey, matchId);

        matchModifyLocationMap.setOnItemClickListener(this);
        fiveFootSalModify.setOnClickListener(this);
        sixFootSalModify.setOnClickListener(this);
        soccerModify.setOnClickListener(this);

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
        matchModifyPhoneNumber = findViewById(R.id.matchModifyPhoneNumber);
        matchModifyEtc = findViewById(R.id.matchModifyEtc);
        mapIdModify = findViewById(R.id.mapIdModify);
        addressNameModify = findViewById(R.id.addressNameModify);
        UiHelper.hideWindow(this);
        UiHelper.toolBarInitialize(this, findViewById(R.id.matchModifyToolBar));
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
        if(timePickerStartModify.getHour() > 10){
            s = String.valueOf(timePickerStartModify.getHour())+":";
        }else{
            s = "0"+ String.valueOf(timePickerStartModify.getHour()+":");
        }

        if(timePickerStartModify.getMinute() > 10){
            s = s + String.valueOf(timePickerStartModify.getMinute());
        }else{
            s = s + "0" +  String.valueOf(timePickerStartModify.getMinute());
        }

        s = s+":"+"00";
        return s;
    }

    @Override
    public String convertETime() {
        String s = "";
        if(timePickerEndModify.getHour() > 10){
            s = String.valueOf(timePickerEndModify.getHour())+":";
        }else{
            s = "0"+ String.valueOf(timePickerEndModify.getHour()+":");
        }

        if(timePickerEndModify.getMinute() > 10){
            s = s + String.valueOf(timePickerEndModify.getMinute());
        }else{
            s = s + "0" +  String.valueOf(timePickerEndModify.getMinute());
        }

        s = s+":"+"00";
        return s;
    }

    @Override
    public void showMap(Object object) {
        modifyMap = (List<MapResponse>) object;

        modifyMapInfo = new String[10];
        Arrays.fill(modifyMapInfo, "");

        if(modifyMap.size() > 10){
            for (int i = 0; i < 10; ++i) {
                modifyMapInfo[i] = modifyMap.get(i).getPlace_name();
            }
        }else{

            for (int i = 0; i < modifyMap.size(); ++i) {
                modifyMapInfo[i] = modifyMap.get(i).getPlace_name();
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,modifyMapInfo);
        matchModifyLocationMap.setAdapter(adapter);
        matchModifyLocationMap.setDropDownAnchor(matchModifyLocationMap.getId());
        matchModifyLocationMap.showDropDown();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mapIdModify.setText(String.valueOf(modifyMap.get(position).getId()));
        addressNameModify.setText(modifyMap.get(position).getAddress_name());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.modify,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String startTime = today + "T" + convertSTime();
        String endTime = today + "T" + convertETime();

        ModifyMatchRequest modifyMatchRequest = new ModifyMatchRequest(
                matchId,
                type,
                matchModifyEtc.getText().toString(),
                startTime,
                endTime,
                Integer.parseInt(matchModifyFee.getText().toString()),
                matchModifyPhoneNumber.getText().toString(),
                Integer.parseInt(needPeopleModify.getText().toString()),
                Integer.parseInt(mapIdModify.getText().toString()),
                matchModifyLocationMap.getText().toString(),
                addressNameModify.getText().toString(),
                matchModifyDetailMap.getText().toString());

        presenter.sendMatchInfo(userKey, modifyMatchRequest);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeActivity() {
        Toast.makeText(this, "매치가 수정되었습니다.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showResult(Object object) {
        Match item = (Match) object;

        matchModifyLocationMap.setText(item.getLocation().getPlaceName());
        matchModifyDetailMap.setText(item.getLocation().getPlaceDetail());
        matchModifyFee.setText(String.valueOf(item.getFee()));
        needPeopleModify.setText(String.valueOf(item.getQuota()));
        matchModifyPhoneNumber.setText(item.getPhone());
        matchModifyEtc.setText(item.getDescription());
        mapIdModify.setText(String.valueOf(item.getLocation().getId()));
    }



    @Override
    public void onClick(View v) {
        //매치타입 선택할때
        switch (v.getId()){
            case R.id.fiveFootSalModify:
                if(clickResult != 2 || clickResult != 3){
                    clickResult = 1;
                    type = "FUTSAL5";
                    sixFootSalModify.setEnabled(false);
                    soccerModify.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    sixFootSalModify.setEnabled(true);
                    soccerModify.setEnabled(true);
                }
                break;
            case R.id.sixFootSalModify:
                if(clickResult != 1 || clickResult != 3){
                    clickResult = 2;
                    type = "FUTSAL6";
                    fiveFootSalModify.setEnabled(false);
                    soccerModify.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    fiveFootSalModify.setEnabled(true);
                    soccerModify.setEnabled(true);
                }
                break;
            case R.id.soccerModify:
                if(clickResult != 1 || clickResult != 2){
                    clickResult = 3;
                    type = "SOCCER";
                    fiveFootSalModify.setEnabled(false);
                    sixFootSalModify.setEnabled(false);
                }else{
                    clickResult = 0;
                    type = "";
                    fiveFootSalModify.setEnabled(true);
                    sixFootSalModify.setEnabled(true);
                }
                break;
        }
    }

}
