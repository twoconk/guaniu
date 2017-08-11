package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.personhome.PersonHome;


/**
 * Created by lbw on 2017/8/11.
 */

public class MyFriendActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout back;
    private ImageView friend1;
    private ImageView friend2;
    private ImageView friend3;
    private ImageView friend4;
    private ImageView friend5;
    private ImageView friend6;
    private ImageView friend7;
    private ImageView friend8;
    private ImageView friend9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_my_friend);
        initView();
        friend1.setOnClickListener(this);
        friend2.setOnClickListener(this);
        friend3.setOnClickListener(this);
        friend4.setOnClickListener(this);
        friend5.setOnClickListener(this);
        friend6.setOnClickListener(this);
        friend7.setOnClickListener(this);
        friend8.setOnClickListener(this);
        friend9.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void initView() {
        back = (LinearLayout)findViewById(R.id.back_to_home_form_my_friend);
        friend1 = (RoundImageView)findViewById(R.id.friend_1);
        friend2 = (RoundImageView)findViewById(R.id.friend_2);
        friend3 = (RoundImageView)findViewById(R.id.friend_3);
        friend4 = (RoundImageView)findViewById(R.id.friend_4);
        friend5 = (RoundImageView)findViewById(R.id.friend_5);
        friend6 = (RoundImageView)findViewById(R.id.friend_6);
        friend7 = (RoundImageView)findViewById(R.id.friend_7);
        friend8 = (RoundImageView)findViewById(R.id.friend_8);
        friend9 = (RoundImageView)findViewById(R.id.friend_9);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_to_home_form_my_friend){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, PersonHome.class);
            startActivity(intent);
        }
    }
}
