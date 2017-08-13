package com.example.lbw.guaniu.Music;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.AddActivity;
import com.example.lbw.guaniu.FindActivity;
import com.example.lbw.guaniu.MusicFlokFragment;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.Story.StoryFragmentApadter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/3.
 */

public class MusicActivity extends AppCompatActivity {
    private LinearLayout back;
    private List<Fragment> fragmentList;
    private ImageButton find;
    private int bmpw = 0;//游标宽度
    private int offset = 0;//动画图片偏移量
    private int currIndex = 0;//当前页片标号
    private ImageView cursor;
    private ImageView add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ActivityCollector.addActivity(this);
        back = (LinearLayout)findViewById(R.id.music_back_to);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initCursorPos();
        fragmentList = new ArrayList<>();
        fragmentList.add(new MusicSchoolFragment());
        fragmentList.add(new MusicPopFragment());
        fragmentList.add(new MusicCommonFragment());
        fragmentList.add(new MusicFlokFragment());
        ViewPager viewPager = (ViewPager)findViewById(R.id.music_view_pager);
        StoryFragmentApadter apadter = new StoryFragmentApadter(getSupportFragmentManager(),fragmentList);
        viewPager.setOnPageChangeListener(new MusicActivity.MyPagerChangeLister());
        viewPager.setAdapter(apadter);
        find = (ImageButton)findViewById(R.id.find_music);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, FindActivity.class);
                startActivity(intent);
            }
        });
        add = (ImageView)findViewById(R.id.add_music);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
    private void initCursorPos() {
        cursor = (ImageView)findViewById(R.id.cursor_music);
        bmpw = 60;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels/4;
        offset = (screenW/2 - bmpw)/2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);
        cursor.setImageMatrix(matrix);
    }
    public class MyPagerChangeLister implements ViewPager.OnPageChangeListener {
        int one = offset * 2 + bmpw;
        int two = one * 2;
        int three = one * 3;
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = null;
            switch (position) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    } else if (currIndex == 3){
                        animation = new TranslateAnimation(three,0,0,0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }else if (currIndex == 3){
                        animation = new TranslateAnimation(three,one,0,0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    } else if (currIndex == 3){
                        animation = new TranslateAnimation(three,two,0,0);
                    }
                    break;
                case 3:
                    if (currIndex == 0){
                        animation = new TranslateAnimation(offset,three,0,0);
                    }else if (currIndex == 1){
                        animation = new TranslateAnimation(one,three,0,0);
                    }else if (currIndex == 2){
                        animation = new TranslateAnimation(two,three,0,0);
                    }
                    break;
                default:
                    break;
            }
            currIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            cursor.startAnimation(animation);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
