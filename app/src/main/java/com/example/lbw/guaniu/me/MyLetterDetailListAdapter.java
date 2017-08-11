package com.example.lbw.guaniu.me;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lbw.guaniu.R;

import java.util.List;

/**
 * Created by lbw on 2017/8/11.
 */

public class MyLetterDetailListAdapter extends ArrayAdapter<MyLetter> {
    private int resource;
    private TextView name;
    private TextView time;
    private TextView text;
    public MyLetterDetailListAdapter(@NonNull Context context, int resource, @NonNull List<MyLetter> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MyLetter myLetter = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        name = (TextView) view.findViewById(R.id.my_letter_detail_name);
        text = (TextView)view.findViewById(R.id.my_letter_detail_text);
        time = (TextView)view.findViewById(R.id.my_letter_detail_time);
        name.setText(myLetter.getName());
        time.setText(myLetter.getTime());
        text.setText(myLetter.getText());
        return view;
    }
}
