package com.example.lbw.guaniu.musicdetail;

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
 * Created by lbw on 2017/8/5.
 */

public class DiscueeAdapter extends ArrayAdapter<Discuss> {
    private int imageId;
    private ImageView dicussImage;
    private TextView title;
    private TextView text;
    private View view;
    private TextView time;

    public DiscueeAdapter(@NonNull Context context, int resource, @NonNull List<Discuss> objects) {
        super(context, resource, objects);
        imageId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Discuss discuss = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(imageId,parent,false);
        initView();
        dicussImage.setImageResource(discuss.getImageId());
        time.setText(discuss.getTime());
        text.setText(discuss.getText());
        title.setText(discuss.getTitle());
        return view;
    }

    private void initView() {
        dicussImage = (ImageView)view.findViewById(R.id.discuss_image);
        text = (TextView)view.findViewById(R.id.discuss_text);
        title = (TextView)view.findViewById(R.id.discuss_title);
        time =(TextView)view.findViewById(R.id.discuss_time);
    }
}
