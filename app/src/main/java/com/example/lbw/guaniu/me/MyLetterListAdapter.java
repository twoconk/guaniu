package com.example.lbw.guaniu.me;

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
 * Created by lbw on 2017/8/10.
 */

public class MyLetterListAdapter extends ArrayAdapter<Letter> {
    private ImageView imageView;
    private TextView text;
    private TextView time;
    private TextView name;
    private int resource;
    public MyLetterListAdapter(@NonNull Context context, int resource, @NonNull List<Letter> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Letter letter = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        imageView = (ImageView)view.findViewById(R.id.letter_image);
        text = (TextView) view.findViewById(R.id.letter_text);
        time = (TextView) view.findViewById(R.id.letter_time);
        name = (TextView) view.findViewById(R.id.letter_name);
        imageView.setImageResource(letter.getImageId());
        text.setText(letter.getText());
        time.setText(letter.getTime());
        name.setText(letter.getName());
        return view;
    }
}
