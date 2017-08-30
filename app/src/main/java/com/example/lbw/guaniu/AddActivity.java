package com.example.lbw.guaniu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by lbw on 2017/8/10.
 */

public class AddActivity extends AppCompatActivity{
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_add);
        back = (LinearLayout)findViewById(R.id.back_to_square_form_add);
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
