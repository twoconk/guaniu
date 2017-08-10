package com.example.lbw.guaniu.help;

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
 * Created by lbw on 2017/8/9.
 */

public class HelpListAdapter extends ArrayAdapter<Help> {
    private int resource;
    private TextView pinglun;
    private TextView text;
    public HelpListAdapter(@NonNull Context context, int resource, @NonNull List<Help> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Help help = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
        pinglun = (TextView)view.findViewById(R.id.pinglun_help);
        text = (TextView)view.findViewById(R.id.help_text);
        pinglun.setText(help.getPinglun());
        text.setText(help.getText());
        return view;
    }
}
