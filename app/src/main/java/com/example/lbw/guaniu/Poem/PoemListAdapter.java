package com.example.lbw.guaniu.Poem;

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

public class PoemListAdapter extends ArrayAdapter<Poem> {
    private int imageId;
    private ImageView poemImage;
    private TextView title;
    private TextView text;
    private View view;
    public PoemListAdapter(@NonNull Context context, int resource, @NonNull List<Poem> objects) {
        super(context, resource, objects);
        imageId = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Poem poem = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        poemImage.setImageResource(poem.getImageId());
        title.setText(poem.getTitle());
        text.setText(poem.getText());
        return view;
    }

    private void initView() {
        poemImage = (ImageView)view.findViewById(R.id.image);
        title = (TextView)view.findViewById(R.id.title);
        text = (TextView)view.findViewById(R.id.text);
    }
}
