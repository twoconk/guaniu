package com.example.lbw.guaniu.Story;

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

public class StoryTraditionFragment extends Fragment {
    private List<Story> stories;
    private View view;
    private SwipeRefreshLayout swipeRefresh;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        stories = new ArrayList<>();
        initStories();
        StoryListAdapter adapter = new StoryListAdapter(getContext(), R.layout.list_item, stories);
        ListView listView = (ListView) view.findViewById(R.id.story_tradition_list);
        listView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"这是下拉刷新",Toast.LENGTH_SHORT).show();
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
        for(int i = 0; i < 3; i++) {
            Story huluwa = new Story("葫芦娃", "要读就读金典", R.mipmap.huluwa);
            stories.add(huluwa);
            Story qitiandashen = new Story("齐天大圣", "孙猴子闹天宫", R.mipmap.qitiandashen);
            stories.add(qitiandashen);
            Story sanguo = new Story("三国演义", "一个国家,三个人的历史", R.mipmap.sanguo);
            stories.add(sanguo);
        }
    }
}
