package star.yx.tabview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lbw.guaniu.DiscoverFragment;
import com.example.lbw.guaniu.FindActivity;
import com.example.lbw.guaniu.HomeFragment;
import com.example.lbw.guaniu.MeFragment;
import com.example.lbw.guaniu.MusicPlayerActivity;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.WriteNews;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabClickListener, View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<TabItem> tabs;
    private ActionBar actionBar;
    BaseFragment fragment;

    private ImageButton add;
    private ImageButton find;
    private ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        add = (ImageButton) findViewById(R.id.add);
        play = (ImageButton) findViewById(R.id.play);
        find = (ImageButton) findViewById(R.id.find);
        add.setOnClickListener(this);
        play.setOnClickListener(this);
        find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

    private void initData() {

        tabs = new ArrayList<>();
        tabs.add(new TabItem(R.drawable.selector_tab_moments, R.string.tab_home, HomeFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_msg, R.string.tab_find, DiscoverFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_profile, R.string.tab_my, MeFragment.class));

        mTabLayout.initData(tabs, this);
        mTabLayout.setCurrentTab(0);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
                if (tabs.get(position).lableResId != -1) {
//                    actionBar.setTitle(tabs.get(position).lableResId);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    boolean  bIsFirstClick;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // Do something.

            if (bIsFirstClick) {
                bIsFirstClick = false;
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static interface OnBackPressedListener{
        boolean onBackPressed();
    }

    OnBackPressedListener mOnBackPressedListener;
    public void setBackPressedListener(OnBackPressedListener listen){
        mOnBackPressedListener = listen;
    }

    @Override
    public void onBackPressed(){
        if(mOnBackPressedListener != null && mOnBackPressedListener.onBackPressed()){
            return;
        }
        super.onBackPressed();
        return;
    }

    @Override
    public void onTabClick(TabItem tabItem) {

        mViewPager.setCurrentItem(tabs.indexOf(tabItem));
        /*        try {
            BaseFragment fragment= tabItem.tagFragmentClz.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commitAllowingStateLoss();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Log.d("TAG", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    public class FragAdapter extends FragmentPagerAdapter {


        public FragAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            try {
                return tabs.get(arg0).tagFragmentClz.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return tabs.size();
        }

    }
}
