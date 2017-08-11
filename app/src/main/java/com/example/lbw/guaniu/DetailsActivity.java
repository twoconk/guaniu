package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by lbw on 2017/8/11.
 */

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton back;
    private ImageView playMusic;
    private Button record;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_details);
        back = (ImageButton)findViewById(R.id.back_to_home_from_details);
        playMusic = (ImageView)findViewById(R.id.music_play);
        record = (Button)findViewById(R.id.record_details);
        back.setOnClickListener(this);
        playMusic.setOnClickListener(this);
        record.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_home_from_details:
                Intent intentBack = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(intentBack);
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
}
