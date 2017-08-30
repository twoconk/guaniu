package com.example.lbw.guaniu.help;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.commen_view.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/9.
 */

public class HelpActivity extends AppCompatActivity {
    private LinearLayout back;
    private ListView listView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Help> list;
    private SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //ActivityCollector.addActivity(this);

        back = (LinearLayout)findViewById(R.id.back_to_square_from_help);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();

        initRecycleView();

        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(HelpActivity.this,"这是下拉刷新",Toast.LENGTH_SHORT).show();

                swipeRefresh.setRefreshing(false);
            }
        });
//        listView = (ListView)findViewById(R.id.help_list);
//        HelpListAdapter adapter = new HelpListAdapter(HelpActivity.this,R.layout.help_item,list);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(HelpActivity.this,HelpDetailActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void initRecycleView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        list = new ArrayList<Help>();
        Help help = new Help("10条","如果你无法用简洁的语言表它,那说明你还不够了解他" + "\n" + "你们喜欢baby吗?" );
        list.add(help);
        list.add(help);
        list.add(help);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }

    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<Help> mDataset;
        private Context context;


        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(Context context,List<Help> data) {
            this.mDataset = data;
            this.context = context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.help_item, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(context, v);
            return vh;
        }


        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            TextView tv = holder.getView(R.id.pinglun_help);
            tv.setText(mDataset.get(position).getPinglun());
            tv = holder.getView(R.id.help_text);
            tv.setText(mDataset.get(position).getText());

            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 点击事件
                    Intent intent = new Intent(HelpActivity.this,HelpDetailActivity.class);
                    startActivity(intent);
                }
            });

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

}
