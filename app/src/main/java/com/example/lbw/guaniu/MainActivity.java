package com.example.lbw.guaniu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private MeFragment meFragment;
    private Button home;
    private Button discovery;
    private Button me;
    private int current = 0;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Button add;
    private Button find;
    private Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);
        initView();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.fragment, homeFragment);
        transaction.commit();
        home.setTextColor(Color.parseColor("#ff9900"));
        home.setOnClickListener(this);
        discovery.setOnClickListener(this);
        me.setOnClickListener(this);
        add.setOnClickListener(this);
        play.setOnClickListener(this);
        find.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null){
            current = intent.getIntExtra("back_code",0);
            changeFragment(current);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initView() {
        home = (Button) findViewById(R.id.home);
        discovery = (Button) findViewById(R.id.discovery);
        me = (Button) findViewById(R.id.me);
        add = (Button) findViewById(R.id.add);
        play = (Button) findViewById(R.id.play);
        find = (Button) findViewById(R.id.find);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
                Intent intent = new Intent(this, WriteNews.class);
                startActivity(intent);
                break;
            case R.id.play:
                Intent intentMusic = new Intent(this, MusicPlayerActivity.class);
                startActivity(intentMusic);
                break;
            case R.id.find:
                Intent intentFind = new Intent(this, FindActivity.class);
                startActivity(intentFind);
                break;
            default:
                break;
        }
    }

    private void changeFragment(int current) {
        switch (current) {
            case 0:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, homeFragment);
                transaction.commit();
                home.setTextColor(Color.parseColor("#ff9900"));
                discovery.setTextColor(Color.parseColor("#000000"));
                me.setTextColor(Color.parseColor("#000000"));
                break;
            case 1:
                discoverFragment = new DiscoverFragment();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment, discoverFragment);
                transaction.commit();
                discovery.setTextColor(Color.parseColor("#ff9900"));
                home.setTextColor(Color.parseColor("#000000"));
                me.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                transaction = fragmentManager.beginTransaction();
                meFragment = new MeFragment();
                transaction.replace(R.id.fragment, meFragment);
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
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ActivityCollector.finishAll();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
