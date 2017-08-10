package com.example.lbw.guaniu.Music;

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
import com.example.lbw.guaniu.help.HelpDetail;

import java.util.List;

/**
 * Created by lbw on 2017/8/10.
 */

public class MusicDiscussListAdapter extends ArrayAdapter<MusicDiscuss> {
    private int resource;
    private ImageView imageView;
    private TextView name;
    private TextView time;
    private TextView text;
    public MusicDiscussListAdapter(@NonNull Context context, int resource, @NonNull List<MusicDiscuss> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MusicDiscuss musicDiscuss = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        imageView = (ImageView)view.findViewById(R.id.music_discuss_detail_image);
        name = (TextView)view.findViewById(R.id.music_discuss_detail_name);
        text = (TextView)view.findViewById(R.id.music_discuss_detail_text);
        time =(TextView)view.findViewById(R.id.music_discuss_detail_time);
        imageView.setImageResource(musicDiscuss.getImageId());
        name.setText(musicDiscuss.getName());
        text.setText(musicDiscuss.getText());
        time.setText(musicDiscuss.getTime());
        return view;
    }
}
