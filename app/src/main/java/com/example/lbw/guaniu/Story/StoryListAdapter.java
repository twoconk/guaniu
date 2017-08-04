package com.example.lbw.guaniu.Story;

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
import com.example.lbw.guaniu.Story.Story;

import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class StoryListAdapter extends ArrayAdapter<Story> {
    private int imageId;
    private ImageView storyImage;
    private TextView title;
    private TextView text;
    private View view;

    public StoryListAdapter(@NonNull Context context, int resource, @NonNull List<Story> objects) {
        super(context, resource, objects);
        imageId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Story story = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        storyImage.setImageResource(story.getImageId());
        title.setText(story.getTitle());
        text.setText(story.getText());
        return view;
    }

    private void initView() {
        storyImage = (ImageView)view.findViewById(R.id.image);
        title = (TextView)view.findViewById(R.id.title);
        text = (TextView)view.findViewById(R.id.text);
    }
}
