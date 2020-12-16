package com.experiencers.playeasy.view.main.fragment.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.experiencers.playeasy.R;
import com.experiencers.playeasy.view.myinformation.MyInfoActivity;
import com.google.android.material.button.MaterialButton;

public class MyPageFragment extends Fragment implements MyPageContract.view, View.OnClickListener {

    private ViewGroup rootView;

    private MaterialButton myInfo;
    private MaterialButton alarmSetting;
    private MaterialButton myTeamManagement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.mypage_frament, container, false);

        init();

        myInfo.setOnClickListener(this);
        alarmSetting.setOnClickListener(this);
        myTeamManagement.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void init() {
        myInfo = rootView.findViewById(R.id.firstButton);
        alarmSetting = rootView.findViewById(R.id.thirdButton);
        myTeamManagement = rootView.findViewById(R.id.forthButton);
    }

    @Override
    public void showResult(Object object) {

    }

    @Override
    public void changeActivity() {

    }



    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.firstButton:
                intent = new Intent(getActivity(), MyInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
