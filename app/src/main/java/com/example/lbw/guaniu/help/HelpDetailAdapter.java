package com.example.lbw.guaniu.help;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lbw.guaniu.R;

import java.util.List;

/**
 * Created by lbw on 2017/8/9.
 */

public class HelpDetailAdapter extends ArrayAdapter<HelpDetail> {
    private int resource;
    private ImageView imageView;
    private TextView name;
    private TextView time;
    private TextView text;
    public HelpDetailAdapter(@NonNull Context context, int resource, @NonNull List<HelpDetail> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HelpDetail helpDetail = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        imageView = (ImageView)view.findViewById(R.id.help_detail_image);
        name = (TextView)view.findViewById(R.id.help_detail_name);
        text = (TextView)view.findViewById(R.id.help_detail_text);
        time =(TextView)view.findViewById(R.id.help_detail_time);
        imageView.setImageResource(helpDetail.getImageId());
        name.setText(helpDetail.getName());
        text.setText(helpDetail.getText());
        time.setText(helpDetail.getTime());
        return view;
    }
}
