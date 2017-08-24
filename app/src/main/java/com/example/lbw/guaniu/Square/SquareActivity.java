package com.example.lbw.guaniu.Square;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.MusicPlayerActivity;
import com.example.lbw.guaniu.musicdetail.MuiscDetailActivity;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.WriteNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/5.
 */

public class SquareActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private LinearLayout back;
    private ImageButton squareAdd;
    private ListView listView;
    private List<Square> list;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        ActivityCollector.addActivity(this);
        back = (LinearLayout)findViewById(R.id.square_back_to);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        squareAdd = (ImageButton)findViewById(R.id.square_add);
        squareAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareActivity.this, WriteNews.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(R.id.square_list);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(SquareActivity.this, "这是下拉刷新", Toast.LENGTH_SHORT).show();
                swipeRefresh.setRefreshing(false);

            }
        });

        initData();
        SquareAdapter adapter = new SquareAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        Square music = new Square(R.mipmap.huluwa,"友友宝宝","我读了春晓,很好听","2017/8/5","100个","10条",0);
        list.add(music);
        Square picture = new Square(R.mipmap.tonghua2,"周心怡","快乐点歌赞吧,我听可好听了","2017/8/5","110个","15条",1);
        list.add(picture);
        Square video = new Square(R.mipmap.tonghua3,"爱心心","快乐点歌赞吧,我听可好听了","2017/8/5","60个","9条",2);
        list.add(video);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Square square = list.get(position);
        if (square.getViewType() == 0){
            Intent intent = new Intent(SquareActivity.this, MusicPlayerActivity.class);
            startActivity(intent);
        }
    }
}
