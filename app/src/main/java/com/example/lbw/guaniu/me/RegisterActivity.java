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

public class RegisterActivity extends AppCompatActivity {
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActivityCollector.addActivity(this);
        back = (LinearLayout) findViewById(R.id.back_to_me_form_register);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
