package com.example.lbw.guaniu.Story;

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

public class StoryActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout back;
    private List<Fragment> fragmentList;
    private ImageButton find;
    private ViewPager viewPager;
    private int bmpw = 0;//游标宽度
    private int offset = 0;//动画图片偏移量
    private int currIndex = 0;//当前页片标号
    private ImageView cursor;
    private ImageView add;
    private TextView tradition;
    private TextView fariy;
    private TextView book;
    private int currentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        //ActivityCollector.addActivity(this);
        back = (LinearLayout)findViewById(R.id.story_back_to);
        back.setOnClickListener(this);
        initCursorPos();
        fragmentList = new ArrayList<>();
        fragmentList.add(new CommenStoryFragment());
        fragmentList.add(new CommenStoryFragment());
        fragmentList.add(new CommenStoryFragment());
        viewPager = (ViewPager)findViewById(R.id.story_view_pager);
        CommenFragmentAdapter apadter = new CommenFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setOnPageChangeListener(new MyPagerChangeLister());
        viewPager.setAdapter(apadter);
        find = (ImageButton)findViewById(R.id.find_story);
        find.setOnClickListener(this);
        add = (ImageView)findViewById(R.id.add_story);
        add.setOnClickListener(this);
        tradition = (TextView)findViewById(R.id.tradition);
        tradition.setOnClickListener(this);
        fariy = (TextView)findViewById(R.id.fairy);
        fariy.setOnClickListener(this);
        book = (TextView)findViewById(R.id.book);
        book.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }
    private void initCursorPos() {
        cursor = (ImageView)findViewById(R.id.cursor);
        bmpw = 60;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels/3;
        offset = (screenW/3 - bmpw)/2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);
        cursor.setImageMatrix(matrix);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.story_back_to:
                finish();;
                break;
            case R.id.find_story:
                Intent intentFind = new Intent(StoryActivity.this, FindActivity.class);
                startActivity(intentFind);
                break;
            case R.id.add_story:
                Intent intentAdd = new Intent(StoryActivity.this, AddActivity.class);
                startActivity(intentAdd);
                break;
            case R.id.tradition:
                currentFragment = 0;
                viewPager.setCurrentItem(currentFragment);
                break;
            case R.id.fairy:
                currentFragment = 1;
                viewPager.setCurrentItem(currentFragment);
                break;
            case R.id.book:
                currentFragment = 2;
                viewPager.setCurrentItem(currentFragment);
                break;
            default:
                break;
        }
    }

    public class MyPagerChangeLister implements ViewPager.OnPageChangeListener {
        int one = offset * 2 + bmpw;
        int two = one * 2;
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
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
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
