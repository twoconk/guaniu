package com.example.lbw.guaniu.personhome;

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

public class MyNewsAdapter extends ArrayAdapter<MyNews> {
    private int imageId;
    private View view;
    private ImageView image;
    private TextView time;
    private TextView text;
    private TextView zan;
    private TextView pinglun;
    public MyNewsAdapter(@NonNull Context context, int resource, @NonNull List<MyNews> objects) {
        super(context, resource, objects);
        this.imageId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyNews myNews = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        image.setImageResource(myNews.getImageId());
        time.setText(myNews.getTime());
        text.setText(myNews.getText());
        zan.setText(myNews.getZan());
        pinglun.setText(myNews.getPinglun());
        return view;

    }

    private void initView() {
        image = (ImageView)view.findViewById(R.id.square_image_my_list);
        time = (TextView)view.findViewById(R.id.my_list_time);
        text = (TextView)view.findViewById(R.id.my_list_text);
        zan = (TextView)view.findViewById(R.id.zan_my_list);
        pinglun = (TextView)view.findViewById(R.id.pinglun_my_list);
    }
}
