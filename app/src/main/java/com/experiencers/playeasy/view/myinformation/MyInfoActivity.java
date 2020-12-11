package com.experiencers.playeasy.view.myinformation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.experiencers.playeasy.R;
import com.experiencers.playeasy.application.TokenManger;
import com.experiencers.playeasy.model.entity.User;
import com.experiencers.playeasy.utill.UiHelper;
import com.experiencers.playeasy.view.main.activity.MainActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyInfoActivity extends AppCompatActivity implements MyInfoContract.view{

    private MyInfoContract.presenter presenter;

    private CircleImageView myImage;
    private TextView myEmail;
    private TextView myName;
    private EditText myAge;
    private EditText myTeam;
    private EditText myPhone;
    private EditText myDescription;

    private String userKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_info);

        init();

        presenter = new MyInfoPresenter();
        presenter.setView(this);
        presenter.setUserInfo(userKey);
    }

    @Override
    public void init() {
        UiHelper.hideWindow(this);
        UiHelper.toolBarInitialize(this, findViewById(R.id.myInformationToolbar));
        userKey = TokenManger.read(getApplicationContext());

        myImage = findViewById(R.id.myImage);
        myEmail = findViewById(R.id.myEmail);
        myName = findViewById(R.id.myName);
        myAge = findViewById(R.id.myAge);
        myTeam = findViewById(R.id.myTeam);
        myPhone = findViewById(R.id.myPhone);
        myDescription = findViewById(R.id.myDescription);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        presenter.confirmButtonClick(item.getItemId(), userKey);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showResult(Object object) {
        User myInfo = (User) object;
        Log.d("myInfo",myInfo.toString());

        Uri userImageUri = Uri.parse(myInfo.getPicture());

        /* Todo 이미지는 글라이드 */
        Glide.with(this).load(userImageUri).into(myImage);
        myEmail.setText(myInfo.getEmail());
        myName.setText(myInfo.getName());
        myAge.setText(String.valueOf(myInfo.getAge()));
        myTeam.setText(myInfo.getTeamName());
        myPhone.setText(myInfo.getPhone());
        myDescription.setText(myInfo.getDescription());

    }
}
