package com.experiencers.playeasy.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.experiencers.playeasy.R;
import com.experiencers.playeasy.utill.UiHelper;
import com.experiencers.playeasy.view.main.activity.MainActivity;
import com.experiencers.playeasy.view.myinformation.MyInfoActivity;
import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.util.exception.KakaoException;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {

    private LoginPresenter presenter;
    private String access_token;
    private TextView loginTitle;

    // 세션 콜백 구현
    private ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Log.i("KAKAO_SESSION", "로그인 성공");
            AuthService.getInstance()
                    .requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "토큰 정보 요청 실패: " + errorResult);
                        }

                        @Override
                        public void onSuccess(AccessTokenInfoResponse result) {
                            Log.i("KAKAO_API", "사용자 아이디: " + result.getUserId());
                            Log.i("KAKAO_API", "남은 시간(s): " + result.getExpiresIn());;
                            access_token = Session.getCurrentSession().getAccessToken();
                            Log.d("KAKAO_ACCESS_TOKEN", access_token);

                            presenter.sendUserKey(access_token, presenter);
                        }
                    });
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Log.e("KAKAO_SESSION", "로그인 실패", exception);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        Session.getCurrentSession().addCallback(sessionCallback);

        presenter = new LoginPresenter();
        presenter.setView(this, getApplicationContext());


    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
        loginTitle = findViewById(R.id.login_title);
    }

    @Override
    public void changeActivity() {

    }

    @Override
    public void changeActivity(int result) {
        Intent intent;
        if(result == 0){
            intent = new Intent(this, MyInfoActivity.class);
        }else{
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void showResult(Object object) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
