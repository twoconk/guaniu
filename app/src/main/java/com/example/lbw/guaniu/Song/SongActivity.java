package com.example.lbw.guaniu.Song;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.MainActivity;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/3.
 */

public class SongActivity extends AppCompatActivity {
    private LinearLayout back;
    private List<Song> songList;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        ActivityCollector.AddActivity(this);
        back = (LinearLayout) findViewById(R.id.song_back_to);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        initSong();
        SongListAdapter adapter = new SongListAdapter(this,R.layout.list_item,songList);
        ListView listView = (ListView)findViewById(R.id.song_list);
        listView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_song);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(SongActivity.this,"这是下拉刷新",Toast.LENGTH_SHORT).show();
                refreshSong();
            }
        });
    }

    private void refreshSong() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initSong() {
        songList = new ArrayList<>();
        for (int i = 0;i < 3;i++){
            Song song = new Song("葫芦娃","葫芦兄弟主题曲",R.mipmap.huluwa);
            songList.add(song);
            Song siongchumo = new Song("雪岭雄风","熊出没主题曲",R.mipmap.xiongchumo);
            songList.add(siongchumo);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
