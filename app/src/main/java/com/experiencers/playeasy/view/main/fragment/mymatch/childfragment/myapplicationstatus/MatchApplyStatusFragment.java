package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.myapplicationstatus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.utill.RecyclerViewDeco;

public class MatchApplyStatusFragment extends Fragment implements MatchApplyContract.view {


    private ViewGroup rootView;
    private MatchApplyPresenter presenter;

    private AppCompatSpinner selectType;

    private RecyclerView recyclerView;
    private MatchApplyRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewDeco recyclerViewDeco;

    private String type;
    private String userKey;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mymatch_status, container, false);

        init();
        spinnerInit();
        recyclerInit();

        userKey = TokenManger.read(getContext());
        presenter = new MatchApplyPresenter();
        presenter.setView(this);

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(recyclerViewDeco);

        selectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = selectType.getItemAtPosition(position).toString();
                if(type.equals("개인")){
                    type = "PERSONAL";
                }else{
                    type = "TEAM";
                }
                presenter.sendType(type, userKey);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.sendType(type, userKey);
    }

    @Override
    public void init() {
        selectType = rootView.findViewById(R.id.selectType);
        recyclerView = rootView.findViewById(R.id.myMatchApplyStatus);
    }

    @Override
    public void spinnerInit() {
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.selectType, android.R.layout.simple_spinner_item);
        selectType.setAdapter(spinnerAdapter);
    }

    @Override
    public void recyclerInit() {
        adapter = new MatchApplyRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerViewDeco = new RecyclerViewDeco(30);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
