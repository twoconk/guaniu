package com.example.lbw.guaniu.musicdetail;

/**
 * Created by lbw on 2017/8/5.
 */

public class Discuss {
    private int imageId;
    private String title;
    private String text;
    private String time;

    public Discuss(int imageId, String title, String text, String time) {
        this.imageId = imageId;
        this.title = title;
        this.text = text;
        this.time = time;
    }


    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}
