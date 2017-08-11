package com.example.lbw.guaniu.me;

/**
 * Created by lbw on 2017/8/11.
 */

public class MyLetter {
    private String name;
    private String time;
    private String text;

    public MyLetter(String name, String time, String text) {
        this.name = name;
        this.time = time;
        this.text = text;
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
