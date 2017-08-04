package com.example.lbw.guaniu.Poem;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class PoemSongciFragment extends Fragment {
    private List<Poem> poems;
    private View view;
    private SwipeRefreshLayout swipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        poems = new ArrayList<>();
        initStories();
        PoemListAdapter adapter = new PoemListAdapter(getContext(), R.layout.list_item, poems);
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
        Poem huluwa = new Poem("宋词1 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.katong1);
        poems.add(huluwa);
        Poem qitiandashen = new Poem("宋词2 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.xiongchumo);
        poems.add(qitiandashen);
        Poem sanguo = new Poem("宋词3 苏轼", "但愿人长久，千里共婵娟。", R.mipmap.huluwa);
        poems.add(sanguo);
    }
}
