package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lbw.guaniu.personhome.PersonHome;

/**
 * Created by lbw on 2017/8/12.
 */

public class MoreRecommendFragment extends Fragment implements View.OnClickListener {
    private ImageView child1;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more_recommend,container,false);
        initView();
        child1.setOnClickListener(this);
        return view;
    }

    private void initView() {
        child1 = (ImageView)view.findViewById(R.id.friend_1_0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.friend_1_0:
                Intent intent = new Intent(getContext(), PersonHome.class);
                startActivity(intent);
        }
    }
}
