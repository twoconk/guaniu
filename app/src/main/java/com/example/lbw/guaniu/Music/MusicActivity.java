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
import android.widget.TextView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.AddActivity;
import com.example.lbw.guaniu.FindActivity;
import com.example.lbw.guaniu.commen_view.CommenFragmentAdapter;
import com.example.lbw.guaniu.commen_view.CommenStoryFragment;
import com.example.lbw.guaniu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/3.
 */

public class MusicActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout back;
    private List<Fragment> fragmentList;
    private ImageButton find;
    private int currentFragment;
    private ViewPager viewPager;
    private int bmpw = 0;//游标宽度
    private int offset = 0;//动画图片偏移量
    private int currIndex = 0;//当前页片标号
    private ImageView cursor;
    private ImageView add;
    private TextView school;
    private TextView ballad;
    private TextView common;
    private TextView revolutionary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ActivityCollector.addActivity(this);
        back = (LinearLayout)findViewById(R.id.music_back_to);
        back.setOnClickListener(this);
        initCursorPos();
        fragmentList = new ArrayList<>();
        fragmentList.add(new CommenStoryFragment());
        fragmentList.add(new CommenStoryFragment());
        fragmentList.add(new CommenStoryFragment());
        fragmentList.add(new CommenStoryFragment());
        viewPager = (ViewPager)findViewById(R.id.music_view_pager);
        CommenFragmentAdapter apadter = new CommenFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setOnPageChangeListener(new MusicActivity.MyPagerChangeLister());
        viewPager.setAdapter(apadter);
        find = (ImageButton)findViewById(R.id.find_music);
        find.setOnClickListener(this);
        add = (ImageView)findViewById(R.id.add_music);
        add.setOnClickListener(this);
        school = (TextView)findViewById(R.id.school);
        ballad = (TextView)findViewById(R.id.ballad);
        common = (TextView)findViewById(R.id.common);
        revolutionary = (TextView)findViewById(R.id.revolutionary);
        school.setOnClickListener(this);
        ballad.setOnClickListener(this);
        common.setOnClickListener(this);
        revolutionary.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.music_back_to:
                finish();
                break;
            case R.id.find_music:
                Intent intentFind = new Intent(MusicActivity.this, FindActivity.class);
                startActivity(intentFind);
                break;
            case R.id.add_music:
                Intent intentAdd = new Intent(MusicActivity.this, AddActivity.class);
                startActivity(intentAdd);
                break;
            case R.id.school:
                currentFragment = 0;
                viewPager.setCurrentItem(currentFragment);
                break;
            case R.id.ballad:
                currentFragment = 1;
                viewPager.setCurrentItem(currentFragment);
                break;
            case R.id.common:
                currentFragment = 2;
                viewPager.setCurrentItem(currentFragment);
                break;
            case R.id.revolutionary:
                currentFragment = 3;
                viewPager.setCurrentItem(currentFragment);
                break;
            default:
                break;
        }
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
