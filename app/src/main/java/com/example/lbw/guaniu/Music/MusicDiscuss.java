package com.example.lbw.guaniu.Music;

/**
 * Created by lbw on 2017/8/10.
 */

public class MusicDiscuss {
    private int imageId;
    private String name;
    private String time;
    private String text;

    public MusicDiscuss(int imageId, String name, String time, String text) {
        this.imageId = imageId;
        this.name = name;
        this.time = time;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}
