package com.example.lbw.guaniu.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/10.
 */

public class MyLetterActivity extends AppCompatActivity {
    private ListView listView;
    private List<Letter> list;
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_my_letter);
        initData();
        listView = (ListView)findViewById(R.id.my_letter_list);
        MyLetterListAdapter adapter = new MyLetterListAdapter(MyLetterActivity.this,R.layout.letter_item,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyLetterActivity.this,MyLetterDetailActivity.class);
                startActivity(intent);
            }
        });
        back = (LinearLayout)findViewById(R.id.back_to_me_form_letter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        Letter letter = new Letter(R.mipmap.child4,"如果你无法用简洁的语言表达你的意思,那说明你对他还不够熟悉" + "\n" + "你们喜欢baby不?","花开宝宝","2017/08/10 20:34");
        list.add(letter);
        list.add(letter);
        list.add(letter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
