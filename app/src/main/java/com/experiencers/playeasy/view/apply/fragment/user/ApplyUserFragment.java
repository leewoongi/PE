package com.experiencers.playeasy.view.apply.fragment.user;

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

public class ApplyUserFragment extends Fragment implements ApplyUserContract.view{

    private ViewGroup rootView;
    private ApplyUserPresenter presenter;

    private TextView applyUserMember;
    private Button applyUserButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_apply_user, container, false);

        init();
        int matchId = this.getArguments().getInt("matchId");

        presenter = new ApplyUserPresenter();
        presenter.setView(this);

        applyUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(applyUserMember.getText().toString().equals("") || Integer.valueOf(applyUserMember.getText().toString()) == 0){
                    Toast.makeText(rootView.getContext(), "참여 인원을 입력해 주세요.", Toast.LENGTH_SHORT).show();

                }else {
                    Apply apply = new Apply(Integer.valueOf(applyUserMember.getText().toString()),
                            "PERSONAL",matchId);
                    presenter.completionApply(TokenManger.read(rootView.getContext()), apply);
                }
            }
        });

        return rootView;
    }

    @Override
    public void init() {
        applyUserMember = rootView.findViewById(R.id.applyUserMember);
        applyUserButton = rootView.findViewById(R.id.applyUserButton);
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
