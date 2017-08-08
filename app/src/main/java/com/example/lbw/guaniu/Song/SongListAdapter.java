package com.example.lbw.guaniu.Song;

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
 * Created by lbw on 2017/8/4.
 */

public class SongListAdapter extends ArrayAdapter<Song> {
    private int imageId;
    private ImageView songImage;
    private TextView title;
    private TextView text;
    private View view;
    public SongListAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        imageId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song song = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        songImage.setImageResource(song.getImageId());
        title.setText(song.getTitle());
        text.setText(song.getText());
        return view;
    }

    private void initView() {
        songImage = (ImageView)view.findViewById(R.id.image);
        title = (TextView)view.findViewById(R.id.title);
        text = (TextView)view.findViewById(R.id.text);
    }
}
