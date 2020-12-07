package com.experiencers.playeasy.view.apply.fragment.team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.Apply;
import com.experiencers.playeasy.model.entity.ApplyResponse;
import com.google.android.material.button.MaterialButton;

public class ApplyTeamFragment extends Fragment implements ApplyTeamContract.view {

    private ApplyTeamPresenter presenter;
    private ViewGroup rootView;
    private TextView applyTeamMember;
    private Button applyTeamButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_apply_team, container, false);

        init();
        int matchId = this.getArguments().getInt("matchId");

        presenter = new ApplyTeamPresenter();
        presenter.setView(this);
        applyTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Apply apply = new Apply(Integer.valueOf(applyTeamMember.getText().toString()),
                        "TEAM",matchId);
                presenter.completionApply(TokenManger.read(rootView.getContext()), apply);
            }
        });

        return rootView;
    }

    @Override
    public void init() {
        applyTeamMember = rootView.findViewById(R.id.applyTeamMember);
        applyTeamButton = rootView.findViewById(R.id.applyTeamButton);
    }

    @Override
    public void changeActivity() {
        Toast.makeText(rootView.getContext(), "신청이 완료되었습니다.", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void showResult(Object object) {
        ApplyResponse applyResponse = (ApplyResponse) object;
        Toast.makeText(rootView.getContext(), applyResponse.getMessage(), Toast.LENGTH_LONG).show();

    }
}
