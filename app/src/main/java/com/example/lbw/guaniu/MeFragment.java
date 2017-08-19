package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.lbw.guaniu.Square.SquareActivity;
import com.example.lbw.guaniu.me.AboutUsActivity;
import com.example.lbw.guaniu.me.BaseInformationSettingActivity;
import com.example.lbw.guaniu.me.LoginActivity;
import com.example.lbw.guaniu.me.MyLetterActivity;
import com.example.lbw.guaniu.me.RegisterActivity;

import star.yx.tabview.BaseFragment;
import star.yx.tabview.ITabClickListener;

/**
 * Created by lbw on 2017/8/2.
 */

public class MeFragment extends BaseFragment implements ITabClickListener, View.OnClickListener {
    private View view;
    private Button register;
    private Button login;
    private RelativeLayout informationSetting;
    private RelativeLayout myLetter;
    private RelativeLayout myFriendsNews;
    private RelativeLayout myFriends;
    private RelativeLayout aboutUs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me,container,false);
        initView();
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        informationSetting.setOnClickListener(this);
        myLetter.setOnClickListener(this);
        myFriendsNews.setOnClickListener(this);
        myFriends.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        return view;
    }

    private void initView() {
        register = (Button)view.findViewById(R.id.register);
        login = (Button)view.findViewById(R.id.login);
        informationSetting = (RelativeLayout)view.findViewById(R.id.information_setting);
        myLetter = (RelativeLayout)view.findViewById(R.id.my_letter);
        myFriendsNews = (RelativeLayout)view.findViewById(R.id.my_friends_news);
        myFriends = (RelativeLayout)view.findViewById(R.id.my_friends);
        aboutUs = (RelativeLayout)view.findViewById(R.id.about_us);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                Intent intentRegister = new Intent(getContext(),RegisterActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.login:
                Intent intentLogin = new Intent(getContext(),LoginActivity.class);
                startActivity(intentLogin);
                break;
            case R.id.information_setting:
                Intent intentInformationSetting = new Intent(getContext(),BaseInformationSettingActivity.class);
                startActivity(intentInformationSetting);
                break;
            case R.id.my_letter:
                Intent intentMyLetter = new Intent(getContext(), MyLetterActivity.class);
                startActivity(intentMyLetter);
                break;
            case R.id.my_friends_news:
                Intent intentMyFriendNews = new Intent(getContext(), MyFriendActivity.class);
                startActivity(intentMyFriendNews);
                break;
            case R.id.my_friends:
                Intent intentMyFriend = new Intent(getContext(), MyFriendActivity.class);
                startActivity(intentMyFriend);
                break;
            case R.id.about_us:
                Intent intentAboutUs = new Intent(getContext(), AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;
            default:

                break;
        }
    }

    @Override
    public void fetchData() {

    }

    @Override
    public void onMenuItemClick() {

    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
