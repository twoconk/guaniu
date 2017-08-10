package com.example.lbw.guaniu.Square;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lbw.guaniu.Music.MusicDiscussDetailActivity;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.help.HelpDetailActivity;

import java.util.List;

/**
 * Created by lbw on 2017/8/5.
 */

public class SquareAdapter extends BaseAdapter {
    private Context context;
    private int resourceId;
    private List<Square> list;
    private LayoutInflater inflater;
    //为三种布局定义一个标识
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;

    public SquareAdapter (Context context,List<Square> list){
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        Square square = list.get(position);
        if (square.getViewType() == 0){
            return TYPE1;
        }else if (square.getViewType() == 1){
            return TYPE2;
        }else {
            return TYPE3;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        int type = getItemViewType(position);
        if (convertView == null){
            switch (type){
                case TYPE1:
                    convertView = inflater.inflate(R.layout.square_music,null,false);
                    holder1 = new ViewHolder1();
                    holder1.image = (ImageView)convertView.findViewById(R.id.square_image_music);
                    holder1.title = (TextView)convertView.findViewById(R.id.square_title_music);
                    holder1.text = (TextView)convertView.findViewById(R.id.square_text_music);
                    holder1.zan = (TextView)convertView.findViewById(R.id.zan_music);
                    holder1.pinglun = (TextView)convertView.findViewById(R.id.pinglun_music);
                    holder1.time = (TextView)convertView.findViewById(R.id.time_music);
                    holder1.zanDetail = (ImageView)convertView.findViewById(R.id.zan_detail_music);
                    holder1.zanDetail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context,MusicDiscussDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    convertView.setTag(holder1);
                    break;
                case TYPE2:
                    convertView = inflater.inflate(R.layout.square_picture,null,false);
                    holder2 = new ViewHolder2();
                    holder2.image = (ImageView)convertView.findViewById(R.id.square_image_picture);
                    holder2.title = (TextView)convertView.findViewById(R.id.square_title_picture);
                    holder2.text = (TextView)convertView.findViewById(R.id.square_text_picture);
                    holder2.zan = (TextView)convertView.findViewById(R.id.zan_picture);
                    holder2.pinglun = (TextView)convertView.findViewById(R.id.pinglun_picture);
                    holder2.time = (TextView)convertView.findViewById(R.id.time_picture);
                    holder2.zanDetail = (ImageView)convertView.findViewById(R.id.zan_detail_picture);
                    holder2.zanDetail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context,MusicDiscussDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    convertView.setTag(holder2);
                    break;
                case TYPE3:
                    convertView = inflater.inflate(R.layout.square_video,null,false);
                    holder3 = new ViewHolder3();
                    holder3.image = (ImageView)convertView.findViewById(R.id.square_image_video);
                    holder3.title = (TextView)convertView.findViewById(R.id.square_title_video);
                    holder3.text = (TextView)convertView.findViewById(R.id.square_text_video);
                    holder3.zan = (TextView)convertView.findViewById(R.id.zan_video);
                    holder3.pinglun = (TextView)convertView.findViewById(R.id.pinglun_video);
                    holder3.time = (TextView)convertView.findViewById(R.id.time_video);
                    holder3.zanDetail = (ImageView)convertView.findViewById(R.id.zan_detail_video);
                    holder3.zanDetail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context,MusicDiscussDetailActivity.class);
                            context.startActivity(intent);
                        }
                    });
                    convertView.setTag(holder3);
                    break;
                default:
                    break;
            }
        }else {
            switch (type) {
                case TYPE1:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE2:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case TYPE3:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
            }
        }
        switch (type) {
            case TYPE1:
                holder1.image.setImageResource(list.get(position).getImageId());
                holder1.title.setText(list.get(position).getTitle());
                holder1.text.setText(list.get(position).getText());
                holder1.zan.setText(list.get(position).getPraise());
                holder1.pinglun.setText(list.get(position).getDiscuss());
                holder1.time.setText(list.get(position).getTime());
                break;
            case TYPE2:
                holder2.image.setImageResource(list.get(position).getImageId());
                holder2.title.setText(list.get(position).getTitle());
                holder2.text.setText(list.get(position).getText());
                holder2.zan.setText(list.get(position).getPraise());
                holder2.pinglun.setText(list.get(position).getDiscuss());
                holder2.time.setText(list.get(position).getTime());
                break;
            case TYPE3:
                holder3.image.setImageResource(list.get(position).getImageId());
                holder3.title.setText(list.get(position).getTitle());
                holder3.text.setText(list.get(position).getText());
                holder3.zan.setText(list.get(position).getPraise());
                holder3.pinglun.setText(list.get(position).getDiscuss());
                holder3.time.setText(list.get(position).getTime());
                break;
        }
        return convertView;
    }

    class ViewHolder1 {
        ImageView image;
        TextView title;
        TextView text;
        TextView zan;
        TextView pinglun;
        TextView time;
        ImageView zanDetail;
    }
    class ViewHolder2 {
        ImageView image;
        TextView title;
        TextView text;
        TextView zan;
        TextView pinglun;
        TextView time;
        ImageView zanDetail;
    }
    class ViewHolder3 {
        ImageView image;
        TextView title;
        TextView text;
        TextView zan;
        TextView pinglun;
        TextView time;
        ImageView zanDetail;
    }
}
