package com.example.lbw.guaniu.help;

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
 * Created by lbw on 2017/8/9.
 */

public class HelpActivity extends AppCompatActivity {
    private LinearLayout back;
    private ListView listView;
    private List<Help> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ActivityCollector.addActivity(this);
        back = (LinearLayout)findViewById(R.id.back_to_square_from_help);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
        listView = (ListView)findViewById(R.id.help_list);
        HelpListAdapter adapter = new HelpListAdapter(HelpActivity.this,R.layout.help_item,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HelpActivity.this,HelpDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        Help help = new Help("10条","如果你无法用简洁的语言表它,那说明你还不够了解他" + "\n" + "你们喜欢baby吗?" );
        list.add(help);
        list.add(help);
        list.add(help);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
