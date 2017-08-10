package com.example.lbw.guaniu.Music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/10.
 */

public class MusicDiscussDetailActivity extends AppCompatActivity {
    private ListView listView;
    private List<MusicDiscuss> list;
    private LinearLayout back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_music_discuss_detail);
        initData();
        listView = (ListView)findViewById(R.id.music_discuss_list);
        MusicDiscussListAdapter adapter = new MusicDiscussListAdapter(this,R.layout.music_detail_discuss_item,list);
        listView.setAdapter(adapter);
        back = (LinearLayout)findViewById(R.id.back_to_square_from_music_discuss);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        MusicDiscuss musicDiscuss = new MusicDiscuss(R.mipmap.child4,"花开宝宝","2017/08/09 19;40","如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解" +
                "\n" + "如果你不能用简洁的语言表达出它的意思,那说明你对它还不够了解");
        list.add(musicDiscuss);
        list.add(musicDiscuss);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
