package com.example.lbw.guaniu.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;

/**
 * Created by lbw on 2017/8/10.
 */

public class BaseInformationSettingActivity extends AppCompatActivity {
    private LinearLayout back;
    private LinearLayout school;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_base_information_setting);
        back = (LinearLayout)findViewById(R.id.back_to_me_form_setting);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        school = (LinearLayout)findViewById(R.id.school_setting);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseInformationSettingActivity.this,SchoolSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }
}
