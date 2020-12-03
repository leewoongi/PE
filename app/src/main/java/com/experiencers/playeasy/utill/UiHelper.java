package com.experiencers.playeasy.utill;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.experiencers.playeasy.view.main.activity.MainActivity;

public class UiHelper {

    public static void toolBarInitialize(AppCompatActivity activity, View view) {
        Toolbar toolBar = (Toolbar) view;
        activity.setSupportActionBar(toolBar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setDisplayShowTitleEnabled(false); // 제목 없애기
    }

    public static void hideWindow(AppCompatActivity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static SpannableString getUnderLineColor(String string, String targetString, int color){
        SpannableString spannableString = new SpannableString(string);
        int targetStartIndex = string.indexOf(targetString);
        int targetEndIndex = targetStartIndex + targetString.length();
        spannableString.setSpan(new ForegroundColorSpan(color), targetStartIndex, targetEndIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), targetStartIndex, targetEndIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

}
