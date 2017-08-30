package com.example.lbw.guaniu.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.Square.SquareActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/11.
 */

public class MyLetterDetailActivity extends AppCompatActivity {
    private ListView listView;
    private List<MyLetter> list;
    private TextView text;
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_my_letter_detail);
        initData();
        listView = (ListView)findViewById(R.id.my_letter_detail_list);
        text = (TextView)findViewById(R.id.my_letter_detail_text);
        text.setText("如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" + "\n" + "你们喜欢baby不?");
        MyLetterDetailListAdapter adapter = new MyLetterDetailListAdapter(this,R.layout.my_letter_detail_item,list);
        listView.setAdapter(adapter);
        back = (LinearLayout)findViewById(R.id.back_to_square_from_my_letter_detail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        MyLetter myLetter = new MyLetter("花开宝宝","2014/08/11 9:19","如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" + "\n" + "你们喜欢baby不?");
        list.add(myLetter);
        list.add(myLetter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }
}
