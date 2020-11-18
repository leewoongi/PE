package com.experiencers.playeasy.view.main.fragment.create;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.MapResponse;

import java.util.Arrays;
import java.util.List;

public class CreateFragment extends Fragment implements CreateContract.view  {

    private CreatePresenter presenter;
    private ViewGroup rootView;
    private String userKey;

    private AutoCompleteTextView matchLocationMap;
    ArrayAdapter<String> adapter;
    private String[] mapInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_create, container, false);

        init();

        userKey = TokenManger.read(rootView.getContext());
        presenter = new CreatePresenter();
        presenter.setView(this);

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
                presenter.receiveKeyWord(keyWord, userKey);

            }
        });

        return rootView;
    }

    @Override
    public void init() {
        matchLocationMap = rootView.findViewById(R.id.matchLocationMap);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {
        List<MapResponse> map = (List<MapResponse>) object;

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

        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,mapInfo);
        matchLocationMap.setAdapter(adapter);
        matchLocationMap.setDropDownAnchor(matchLocationMap.getId());
        matchLocationMap.showDropDown();
    }
}
