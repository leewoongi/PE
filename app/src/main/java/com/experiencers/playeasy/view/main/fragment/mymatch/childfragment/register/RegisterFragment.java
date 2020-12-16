package com.experiencers.playeasy.view.main.fragment.mymatch.childfragment.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.utill.RecyclerViewDeco;

public class RegisterFragment extends Fragment implements RegisterContract.view{

    private RegisterPresenter presenter;
    private ViewGroup rootView;
    private RecyclerView recyclerView;
    private RegisterRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewDeco recyclerViewDeco;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mymatch_register, container, false);

        init();
        recyclerInit();


        presenter = new RegisterPresenter();
        presenter.setView(this);

        presenter.setRecyclerAdapterView(adapter);
        presenter.setRecyclerAdapterModel(adapter);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        String userKey = TokenManger.read(getActivity());
        presenter.receiveMatchList(userKey);
    }

    @Override
    public void init() {
        recyclerView = rootView.findViewById(R.id.registerRecyclerView);
    }

    @Override
    public void recyclerInit() {
        adapter = new RegisterRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerViewDeco = new RecyclerViewDeco(30);
        recyclerView.addItemDecoration(recyclerViewDeco);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
