package com.experiencers.playeasy.view.base;

public interface BaseContract {

    interface view{
        void init();
        void showResult();
    }

    interface presenter<T>{
        void setView(T view);
        void deleteView();
    }
}
