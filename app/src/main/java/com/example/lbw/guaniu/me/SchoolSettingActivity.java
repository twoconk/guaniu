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
    private LinearLayout primary;
    private LinearLayout junior;
    private LinearLayout high;
    private RadioButton primaryRadio;
    private RadioButton juniorRadio;
    private RadioButton highRadio;
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_school_setting);
        initView();
        primary.setOnClickListener(this);
        junior.setOnClickListener(this);
        high.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void initView() {
        primary = (LinearLayout) findViewById(R.id.primary);
        junior = (LinearLayout)findViewById(R.id.junior);
        high = (LinearLayout)findViewById(R.id.high);
        primaryRadio = (RadioButton)findViewById(R.id.primary_rodio);
        juniorRadio = (RadioButton)findViewById(R.id.junior_rodio);
        highRadio = (RadioButton)findViewById(R.id.high_rodio);
        back = (LinearLayout)findViewById(R.id.back_to_information_setting);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.primary:
                primaryRadio.setChecked(true);
                juniorRadio.setChecked(false);
                highRadio.setChecked(false);
                break;
            case R.id.junior:
                primaryRadio.setChecked(false);
                juniorRadio.setChecked(true);
                highRadio.setChecked(false);
                break;
            case R.id.high:
                primaryRadio.setChecked(false);
                juniorRadio.setChecked(false);
                highRadio.setChecked(true);
                break;
            case R.id.back_to_information_setting:
                finish();
                break;
            default:
                break;
        }
    }
}
