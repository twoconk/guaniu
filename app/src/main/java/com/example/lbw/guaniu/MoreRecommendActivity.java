package com.example.lbw.guaniu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by lbw on 2017/8/12.
 */

public class MoreRecommendActivity extends AppCompatActivity {
    private LinearLayout back;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_more_recommend);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        MoreRecommendFragment fragment = new MoreRecommendFragment();
        transaction.add(R.id.fragment_more_recommend, fragment);
        transaction.commit();
        back = (LinearLayout)findViewById(R.id.back_to_home_from_moer_commend);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }
}
