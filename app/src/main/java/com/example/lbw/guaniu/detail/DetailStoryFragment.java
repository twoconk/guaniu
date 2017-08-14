package com.example.lbw.guaniu.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lbw.guaniu.R;

/**
 * Created by lbw on 2017/8/14.
 */

public class DetailStoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_story,null);
        TextView textView = (TextView)view.findViewById(R.id.detail_story_text);
        textView.setText("舒克舒克舒克舒克舒克舒克舒克舒克," + "\n" + "开飞机的舒克," + "\n" + "贝塔贝塔贝塔贝塔贝塔贝塔贝塔贝塔," + "\n" + "开坦克的贝塔" + "\n" + "\n"
                            + "舒克舒克舒克舒克舒克舒克舒克舒克," + "\n" + "勇敢的舒克,聪明的舒克," + "\n" + "贝塔贝塔贝塔贝塔贝塔贝塔贝塔贝塔," + "\n" + "勇敢的贝塔,聪明的贝塔" + "\n" + "\n"
                            + "舒克舒克舒克舒克舒克舒克舒克舒克," + "\n" + "开飞机的舒克," + "\n" + "贝塔贝塔贝塔贝塔贝塔贝塔贝塔贝塔," + "\n" + "开坦克的贝塔" + "\n" + "\n"
                            + "舒克舒克舒克舒克舒克舒克舒克舒克," + "\n" + "勇敢的舒克,聪明的舒克," + "\n" + "贝塔贝塔贝塔贝塔贝塔贝塔贝塔贝塔," + "\n" + "勇敢的贝塔,聪明的贝塔" );
        return view;
    }
}
