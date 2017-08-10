package com.example.lbw.guaniu.me;

/**
 * Created by lbw on 2017/8/10.
 */

public class Letter {
    private int imageId;
    private String text;
    private String name;
    private String time;

    public Letter(int imageId, String text, String name, String time) {
        this.imageId = imageId;
        this.text = text;
        this.name = name;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
