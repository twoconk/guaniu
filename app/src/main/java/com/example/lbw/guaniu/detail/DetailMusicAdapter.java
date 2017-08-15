package com.example.lbw.guaniu.detail;

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
 * Created by lbw on 2017/8/14.
 */

public class DetailMusicAdapter extends ArrayAdapter<DetailMusic> {
    private ImageView image;
    private TextView title;
    private TextView text;
    private TextView zan;
    private TextView pinglun;
    private TextView time;
    private int resource;
    public DetailMusicAdapter(@NonNull Context context, int resource, @NonNull List<DetailMusic> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DetailMusic detailMusic = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        image = (ImageView)view.findViewById(R.id.detail_image_music);
        title = (TextView) view.findViewById(R.id.detail_title_music);
        text = (TextView)view.findViewById(R.id.detail_text_music);
        zan = (TextView)view.findViewById(R.id.detail_zan_music);
        pinglun = (TextView)view.findViewById(R.id.detail_pinglun_music);
        time = (TextView)view.findViewById(R.id.detail_time_music);
        image.setImageResource(detailMusic.getImageId());
        title.setText(detailMusic.getTitle());
        text.setText(detailMusic.getText());
        zan.setText(detailMusic.getPraise());
        pinglun.setText(detailMusic.getDiscuss());
        time.setText(detailMusic.getTime());
        return view;
    }
}
