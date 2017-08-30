package com.example.lbw.guaniu.detail;

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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.MusicPlayerActivity;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.RecordActivity;
import com.example.lbw.guaniu.Story.StoryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbw on 2017/8/11.
 */

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton back;
    private ImageView playMusic;
    private Button record;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private int bmpw = 0;//游标宽度
    private int offset = 0;//动画图片偏移量
    private int currIndex = 0;//当前页片标号
    private ImageView cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_details);
        initCursorPos();
        back = (ImageButton)findViewById(R.id.back_to_home_from_details);
        playMusic = (ImageView)findViewById(R.id.music_play);
        record = (Button)findViewById(R.id.record_details);
        back.setOnClickListener(this);
        playMusic.setOnClickListener(this);
        record.setOnClickListener(this);
        fragmentList = new ArrayList<>();
        fragmentList.add(new DetailStoryFragment());
        fragmentList.add(new DetailMusicFragment());
        DetailViewPagerFragmentAdapter adapter = new DetailViewPagerFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager = (ViewPager)findViewById(R.id.detail_view_pager);
        viewPager.setOnPageChangeListener(new DetailsActivity.MyPagerChangeLister());
        viewPager.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_home_from_details:

                finish();
                break;
            case R.id.music_play:
                Intent intentMusic = new Intent(DetailsActivity.this,MusicPlayerActivity.class);
                startActivity(intentMusic);
                break;
            case R.id.record_details:
                Intent intentRecord = new Intent(DetailsActivity.this,RecordActivity.class);
                startActivity(intentRecord);
                break;
            default:
                break;

        }
    }
    private void initCursorPos() {
        cursor = (ImageView)findViewById(R.id.tab_detail_music);
        bmpw = 60;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels/2;
        offset = (screenW/3 - bmpw)/2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);
        cursor.setImageMatrix(matrix);
    }

    public class MyPagerChangeLister implements ViewPager.OnPageChangeListener {
        int one = offset * 2 + bmpw;
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
                    }
                    break;
                 case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
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
