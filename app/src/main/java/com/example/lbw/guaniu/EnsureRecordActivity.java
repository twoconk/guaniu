package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lbw on 2017/8/11.
 */

public class EnsureRecordActivity extends AppCompatActivity {
    private TextView text;
    private Button cancel;
    private Button save;
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_ensure_record);
        text = (TextView)findViewById(R.id.ensure_record_text);
        text.setText("春晓_百度汉语" + "\n" + "作者:孟浩然" + "\n" + "春眠不觉晓,处处闻啼鸟" + "\n" + "夜来风雨声,花落知多少");
        cancel = (Button)findViewById(R.id.cancel_record);
        save = (Button)findViewById(R.id.save_record);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnsureRecordActivity.this,WriteNews.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogEditFragment dialogEditFragment = new DialogEditFragment();
                dialogEditFragment.show(getFragmentManager(),"DialogEditFragment");
            }
        });
        back = (LinearLayout)findViewById(R.id.back_to_record);
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
