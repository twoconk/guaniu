package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.Music.MusicActivity;
import com.example.lbw.guaniu.Poem.PoemActivity;
import com.example.lbw.guaniu.Song.SongActivity;
import com.example.lbw.guaniu.Square.SquareActivity;
import com.example.lbw.guaniu.Story.StoryActivity;
import com.example.lbw.guaniu.musicdetail.MuiscDetailActivity;
import com.example.lbw.guaniu.personhome.PersonHome;

import java.util.ArrayList;
import java.util.List;

import star.yx.tabview.BaseFragment;
import star.yx.tabview.ITabClickListener;

/**
 * Created by lbw on 2017/8/2.
 */

public class HomeFragment extends BaseFragment implements ITabClickListener, View.OnClickListener {
    private LinearLayout moerMusic;
    private LinearLayout moreRecommend;
    private HomeView homeView;
    private HomeView homeView1;
    private HomeView homeView2;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        moerMusic.setOnClickListener(this);
        moreRecommend.setOnClickListener(this);
        List<HomeView.ItemData> list = new ArrayList<>();
        HomeView.ItemData itemData1 = new HomeView.ItemData("故事",R.mipmap.story);
        HomeView.ItemData itemData2 = new HomeView.ItemData("儿歌",R.mipmap.song);
        HomeView.ItemData itemData3 = new HomeView.ItemData("诗歌",R.mipmap.poem);
        HomeView.ItemData itemData4 = new HomeView.ItemData("音乐",R.mipmap.music);
        list.add(itemData1);
        list.add(itemData2);
        list.add(itemData3);
        list.add(itemData4);
        homeView = (HomeView)view.findViewById(R.id.home_view);
        homeView.setViewType1(list);
        homeView.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StoryActivity.class);
                startActivity(intent);
            }
        });
        homeView.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SongActivity.class);
                startActivity(intent);
            }
        });
        homeView.getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PoemActivity.class);
                startActivity(intent);
            }
        });
        homeView.getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MusicActivity.class);
                startActivity(intent);
            }
        });
        List<HomeView.ItemData> list1 = new ArrayList<>();
        HomeView.ItemData itemData11 = new HomeView.ItemData("木宝宝",R.mipmap.child1);
        HomeView.ItemData itemData21= new HomeView.ItemData("木宝宝",R.mipmap.child2);
        HomeView.ItemData itemData31= new HomeView.ItemData("木宝宝",R.mipmap.child3);
        HomeView.ItemData itemData41= new HomeView.ItemData("木宝宝",R.mipmap.child4);
        list1.add(itemData11);
        list1.add(itemData21);
        list1.add(itemData31);
        list1.add(itemData41);
        homeView1 = (HomeView)view.findViewById(R.id.home_view_1);
        homeView1.setViewType2(list1);
        for (int i = 0;i<list.size();i++) {
            homeView1.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), PersonHome.class);
                    startActivity(intent);
                }
            });
        }
        List<HomeView.ItemData> list2 = new ArrayList<>();
        HomeView.ItemData itemData12 = new HomeView.ItemData("木宝宝",R.mipmap.child5);
        HomeView.ItemData itemData22= new HomeView.ItemData("木宝宝",R.mipmap.child6);
        HomeView.ItemData itemData32= new HomeView.ItemData("木宝宝",R.mipmap.child7);
        HomeView.ItemData itemData42= new HomeView.ItemData("木宝宝",R.mipmap.child8);
        list2.add(itemData12);
        list2.add(itemData22);
        list2.add(itemData32);
        list2.add(itemData42);
        homeView2 = (HomeView)view.findViewById(R.id.home_view_2);
        homeView2.setViewType2(list2);
        for (int i = 0;i<list.size();i++) {
            homeView2.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), MusicPlayerActivity.class);
                    startActivity(intent);
                }
            });
        }
        return view;
    }

    private void initView() {
        moerMusic = (LinearLayout) view.findViewById(R.id.more_music);
        moreRecommend = (LinearLayout)view.findViewById(R.id.more_recommend);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more_music:
                Intent intentSquare = new Intent(getContext(), SquareActivity.class);
                startActivity(intentSquare);
                break;
            case R.id.more_recommend:
                Intent intentMoreRecommend = new Intent(getContext(),MoreRecommendActivity.class);
                startActivity(intentMoreRecommend);
                break;
            default:
                break;
        }
    }

    @Override
    public void fetchData() {

    }

    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
