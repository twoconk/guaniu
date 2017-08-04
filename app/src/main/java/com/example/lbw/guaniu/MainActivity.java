package com.example.lbw.guaniu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private MeFragment meFragment;
    private Button home;
    private Button discovery;
    private Button me;
    private int current;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.AddActivity(this);
        initView();
        current = 0;
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.fragment,homeFragment);
        transaction.commit();
        home.setTextColor(Color.parseColor("#ff9900"));
        home.setOnClickListener(this);
        discovery.setOnClickListener(this);
        me.setOnClickListener(this);
        add.setOnClickListener(this);
        int[] a = {45,26,13,79,40,36,67,2};
        Log.d("LBW1",Arrays.toString(sortArray(a)));
    }

    private int[] sortArray(int[] a) {
        for(int i = 0;i < a.length -1;i++){
            for (int j = 0;j<a.length - i -1;j++){
                if (a[j] > a[j+1]){
                    int tem = a[j];
                    a[j ] = a[j+1];
                    a[j+1] = tem;
                }
            }
        }
        return a;
    }

    private void initView() {
        home = (Button)findViewById(R.id.home);
        discovery = (Button)findViewById(R.id.discovery);
        me = (Button)findViewById(R.id.me);
        add = (Button)findViewById(R.id.add);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:
                current = 0;
                changeFragment(current);
                break;
            case R.id.discovery:
                current = 1;
                changeFragment(current);
                break;
            case R.id.me:
                current = 2;
                changeFragment(current);
                break;
            case R.id.add:
                Intent intent = new Intent(this,WriteNews.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void changeFragment(int current) {
        switch (current){
            case 0:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment,homeFragment);
                transaction.commit();
                home.setTextColor(Color.parseColor("#ff9900"));
                discovery.setTextColor(Color.parseColor("#000000"));
                me.setTextColor(Color.parseColor("#000000"));
                break;
            case 1:
                discoverFragment = new DiscoverFragment();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment,discoverFragment);
                transaction.commit();
                discovery.setTextColor(Color.parseColor("#ff9900"));
                home.setTextColor(Color.parseColor("#000000"));
                me.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                transaction = fragmentManager.beginTransaction();
                meFragment = new MeFragment();
                transaction.replace(R.id.fragment,meFragment);
                transaction.commit();
                me.setTextColor(Color.parseColor("#ff9900"));
                home.setTextColor(Color.parseColor("#000000"));
                discovery.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remoreActivity(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            ActivityCollector.finishAll();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
