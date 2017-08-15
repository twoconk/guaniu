package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.Square.SquareActivity;
import com.example.lbw.guaniu.Story.StoryActivity;
import com.example.lbw.guaniu.help.HelpActivity;

import java.util.ArrayList;
import java.util.List;

import star.yx.tabview.BaseFragment;
import star.yx.tabview.ITabClickListener;

/**
 * Created by lbw on 2017/8/2.
 */

public class DiscoverFragment extends BaseFragment implements ITabClickListener {
    private LinearLayout square;
    private LinearLayout help;
    private HomeView homeView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,container,false);
        square = (LinearLayout)view.findViewById(R.id.square);
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SquareActivity.class);
                startActivity(intent);
            }
        });
        help = (LinearLayout)view.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HelpActivity.class);
                startActivity(intent);
            }
        });
        return view;
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
