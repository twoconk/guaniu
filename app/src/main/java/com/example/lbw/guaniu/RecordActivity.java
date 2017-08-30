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

public class RecordActivity extends AppCompatActivity {
    private TextView text;
    private LinearLayout back;
    private Button record;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_record);
        text = (TextView)findViewById(R.id.record_text);
        text.setText("春晓_百度汉语" + "\n" + "作者:孟浩然" + "\n" + "春眠不觉晓,处处闻啼鸟" + "\n" + "夜来风雨声,花落知多少");
        back = (LinearLayout)findViewById(R.id.back_to_writer_news);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordActivity.this,WriteNews.class);
                startActivity(intent);
            }
        });
        record = (Button)findViewById(R.id.go_to_record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                record.setText("完成");
                Intent intent = new Intent(RecordActivity.this,EnsureRecordActivity.class);
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
