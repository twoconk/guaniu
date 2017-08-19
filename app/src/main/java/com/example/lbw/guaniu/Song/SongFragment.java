package com.example.lbw.guaniu.Song;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.detail.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/19.
 */

public class SongFragment extends Fragment {
    private List<Song> songs;
    private View view;
    private SwipeRefreshLayout swipeRefresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        songs = new ArrayList<>();
        initStories();
        SongListAdapter adapter = new SongListAdapter(getContext(), R.layout.list_item, songs);
        ListView listView = (ListView) view.findViewById(R.id.story_tradition_list);
        listView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "这是下拉刷新", Toast.LENGTH_SHORT).show();
                refreshStory();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void refreshStory() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                });

            }
        }).start();
    }

    private void initStories() {
        Song huluwa = new Song("宋词1 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.katong1);
        songs.add(huluwa);
        Song qitiandashen = new Song("宋词2 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.xiongchumo);
        songs.add(qitiandashen);
        Song sanguo = new Song("宋词3 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.huluwa);
        songs.add(sanguo);
    }
}
