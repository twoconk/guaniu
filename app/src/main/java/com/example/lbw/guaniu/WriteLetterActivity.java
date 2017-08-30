package com.example.lbw.guaniu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by lbw on 2017/8/12.
 */

public class WriteLetterActivity extends AppCompatActivity {
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_write_letter);
        back = (LinearLayout)findViewById(R.id.back_to_person_home);
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
        //ActivityCollector.remoreActivity(this);
    }
}
