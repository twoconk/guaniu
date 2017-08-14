package com.example.lbw.guaniu.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.Square.Square;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lbw on 2017/8/14.
 */

public class DetailMusicFragment extends Fragment {
    private ListView listView;
    private List<DetailMusic> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_music,null);
        listView = (ListView)view.findViewById(R.id.detail_view_pager);
        initData();
        DetailMusicAdapter adapter = new DetailMusicAdapter(getContext(),R.layout.detail_music_item,list);
        listView.setAdapter(adapter);
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        DetailMusic music = new DetailMusic(R.mipmap.huluwa,"友友宝宝","我读了春晓,很好听","2017/8/5","100个","10条",0);
        list.add(music);
        list.add(music);
        list.add(music);
    }
}
