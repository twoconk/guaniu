package com.example.lbw.guaniu.commen_view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lbw.guaniu.Poem.Poem;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class CommenStoryFragment extends Fragment {
    private List<Poem> poems;
    private View view;
    private SwipeRefreshLayout swipeRefresh;

    private int type;//
    private int subType;

    public void setType(int type, int subType){
        this.type = type;
        this.subType = subType;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        poems = new ArrayList<>();
        initStories();

        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "这是下拉刷新", Toast.LENGTH_SHORT).show();
                refreshStory();
            }
        });
        initRecycleView();
        return view;
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private void initRecycleView(){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        mAdapter = new CommenListAdapter(getContext(), R.layout.list_item, poems);
        mRecyclerView.setAdapter(mAdapter);
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
