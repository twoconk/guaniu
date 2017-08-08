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

import com.example.lbw.guaniu.Poem.Poem;
import com.example.lbw.guaniu.R;

import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class MusicListAdapter extends ArrayAdapter<Music> {
    private int imageId;
    private ImageView musicImage;
    private TextView title;
    private TextView text;
    private View view;
    public MusicListAdapter(@NonNull Context context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        imageId = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Music music = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        musicImage.setImageResource(music.getImageId());
        title.setText(music.getTitle());
        text.setText(music.getText());
        return view;
    }

    private void initView() {
        musicImage = (ImageView)view.findViewById(R.id.image);
        title = (TextView)view.findViewById(R.id.title);
        text = (TextView)view.findViewById(R.id.text);
    }
}
