package com.example.lbw.guaniu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.utils.L;

import java.util.List;

/**
 * Created by lbw on 2017/8/15.
 */

public class HomeView extends LinearLayout {
    private ImageView imageView;
    private TextView textView;

    public HomeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setViewType1(List<ItemData> list) {
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.home_view_item, null, false);
            ItemData itemData = list.get(i);
            imageView = (ImageView) view.findViewById(R.id.item_image);
            textView = (TextView) view.findViewById(R.id.item_text);
            imageView.setImageResource(itemData.getImageId());
            textView.setText(itemData.getText());
            this.addView(view);
        }
    }

    public static class ItemData {
        private String text;
        private int imageId;

        public ItemData(String text, int imageId) {
            this.text = text;
            this.imageId = imageId;
        }

        public String getText() {
            return text;
        }

        public int getImageId() {
            return imageId;
        }
    }

    public void setViewType2(List<ItemData> list) {
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.home_view_item_2, null, false);
            ItemData itemData = list.get(i);
            imageView = (ImageView) view.findViewById(R.id.item_image_2);
            textView = (TextView) view.findViewById(R.id.item_text_2);
            imageView.setImageResource(itemData.getImageId());
            textView.setText(itemData.getText());
            this.addView(view);
        }
    }
}