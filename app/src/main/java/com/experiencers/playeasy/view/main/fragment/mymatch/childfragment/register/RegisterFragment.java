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

public class RegisterFragment extends Fragment implements RegisterContract.view{

    private RegisterPresenter presenter;
    private ViewGroup rootView;
    private RecyclerView recyclerView;
    private RegisterRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mymatch_register, container, false);

        presenter = new RegisterPresenter();
        presenter.setView(this);
        return rootView;
    }

    @Override
    public void init() {
        recyclerView = rootView.findViewById(R.id.registerRecyclerView);
    }

    @Override
    public void recyclerInit() {
        adapter = new RegisterRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(rootView.getContext());
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void showResult(Object object) {

    }
}
