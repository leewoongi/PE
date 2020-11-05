package com.experiencers.playeasy.view.base;

import android.view.View;

public interface BaseContract {
    interface view{
        void showResult();
    }
    interface presenter{
        void setView(View view);
    }
}
