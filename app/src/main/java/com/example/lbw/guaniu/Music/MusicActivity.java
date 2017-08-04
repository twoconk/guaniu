package com.example.lbw.guaniu.Music;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.lbw.guaniu.ActivityCollector;
import com.example.lbw.guaniu.MainActivity;
import com.example.lbw.guaniu.R;

/**
 * Created by lbw on 2017/8/3.
 */

public class MusicActivity extends AppCompatActivity {
    private ImageButton back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ActivityCollector.AddActivity(this);
        back = (ImageButton)findViewById(R.id.music_back_to);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
