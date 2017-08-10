package com.example.lbw.guaniu;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.lbw.guaniu.Square.SquareActivity;

/**
 * Created by lbw on 2017/8/3.
 */

public class WriteNews extends AppCompatActivity {
    private ImageButton backToSquare;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_news);
        ActivityCollector.addActivity(this);
        backToSquare = (ImageButton)findViewById(R.id.back_to_square);
        backToSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteNews.this, SquareActivity.class);
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
