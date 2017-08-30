package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.Music.MusicDiscussDetailActivity;
import com.example.lbw.guaniu.Square.SquareActivity;

import co.mobiwise.playerview.MusicPlayerView;

/**
 * Created by lbw on 2017/8/9.
 */

public class MusicPlayerActivity extends AppCompatActivity{
    private LinearLayout discuss;
    MusicPlayerView mpv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.music_player);
        ImageView quit = (ImageView)findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        discuss = (LinearLayout)findViewById(R.id.music_player_discuss);
        discuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicPlayerActivity.this, MusicDiscussDetailActivity.class);
                startActivity(intent);
            }
        });

        initPlayerView();
    }

    void initPlayerView(){

        mpv = (MusicPlayerView) findViewById(R.id.mpv);
        mpv.setProgressVisibility(false);
        mpv.setCoverURL("http://7xiava.com1.z0.glb.clouddn.com/FhtE_xLhl1vC7xACByQVnxduZNmT?imageView2/1/w/320/h/240");

        mpv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (mpv.isRotating()) {
                    mpv.stop();
                } else {
                    mpv.start();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ActivityCollector.remoreActivity(this);
    }
}
