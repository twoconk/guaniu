package com.example.lbw.guaniu.detail;

/**
 * Created by lbw on 2017/8/14.
 */

public class DetailMusic {
    private int imageId;
    private String title;
    private String text;
    private String time;
    private String praise;
    private String discuss;

    public DetailMusic(int imageId, String title, String text, String time, String praise, String discuss, int viewType) {
        this.imageId = imageId;
        this.title = title;
        this.text = text;
        this.time = time;
        this.praise = praise;
        this.discuss = discuss;
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


    public String getPraise() {
        return praise;
    }


    public String getDiscuss() {
        return discuss;
    }

}
