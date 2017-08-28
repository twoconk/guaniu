package com.example.lbw.guaniu.help;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/9.
 */

public class HelpDetailActivity extends AppCompatActivity {
    private TextView text;
    private LinearLayout back;
    private ListView listView;
    private List<HelpDetail> list;
    private SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_help_detail);

        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(HelpDetailActivity.this,"这是下拉刷新",Toast.LENGTH_SHORT).show();

                swipeRefresh.setRefreshing(false);
            }
        });

        text = (TextView)findViewById(R.id.help_detail_text);
        text.setText("如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" + "\n" + "你们喜欢baby不?");
        back = (LinearLayout)findViewById(R.id.back_to_help);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData();
        listView = (ListView)findViewById(R.id.answer_list);
        HelpDetailAdapter adapter = new HelpDetailAdapter(this,R.layout.help_detail_item,list);
        listView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        HelpDetail helpDetail = new HelpDetail(R.mipmap.child4,"花开宝宝","2017/08/09 19:40","如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" +
        "\n" + "如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" + "如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" +
                "\n" + "如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解");
        list.add(helpDetail);
        list.add(helpDetail);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
