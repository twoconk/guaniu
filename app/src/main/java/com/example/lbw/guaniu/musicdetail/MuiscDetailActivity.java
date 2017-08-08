package com.example.lbw.guaniu.musicdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.MainActivity;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/5.
 */

public class MuiscDetailActivity extends AppCompatActivity {
    private Button back;
    private ListView listView;
    private List<Discuss> discussList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        ActivityCollector.AddActivity(this);
        back = (Button)findViewById(R.id.back_to_square_from_detail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
        listView = (ListView)findViewById(R.id.discuss_list);
        DiscueeAdapter adapter = new DiscueeAdapter(MuiscDetailActivity.this,R.layout.discuss_item,discussList);
        listView.setAdapter(adapter);
    }

    private void initData() {
        discussList = new ArrayList<>();
        Discuss discuss1 = new Discuss(R.mipmap.huluwa,"花开宝宝","如果你不能用简洁的语言来表达它,说明你对他还不够熟悉","2017/08/05 18:46");
        discussList.add(discuss1);
        Discuss discuss2 = new Discuss(R.mipmap.huluwa,"花开宝宝","如果你不能用简洁的语言来表达它,说明你对他还不够熟悉","2017/08/05 18:46");
        discussList.add(discuss2);
        discussList.add(discuss1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
