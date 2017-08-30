package com.example.lbw.guaniu.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;

/**
 * Created by lbw on 2017/8/10.
 */

public class SchoolSettingActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_school_setting);
        initView();
    }

    private void initView() {
        back = (LinearLayout)findViewById(R.id.back_to_information_setting);
        back.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_information_setting:
                finish();
                break;
            default:
                break;
        }
    }
}
