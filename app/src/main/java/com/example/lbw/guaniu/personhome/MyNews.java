package com.example.lbw.guaniu.personhome;


/**
 * Created by lbw on 2017/8/9.
 */

public class MyNews {
    private String time;
    private int imageId;
    private String text;
    private String zan;
    private String pinglun;

    public MyNews(String time, int imageId, String text, String zan, String pinglun) {
        this.time = time;
        this.imageId = imageId;
        this.text = text;
        this.zan = zan;
        this.pinglun = pinglun;
    }


    public String getTime() {
        return time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public String getZan() {
        return zan;
    }

    public String getPinglun() {
        return pinglun;
    }
}
