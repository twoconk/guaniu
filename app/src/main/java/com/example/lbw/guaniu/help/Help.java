package com.example.lbw.guaniu.help;

/**
 * Created by lbw on 2017/8/9.
 */

public class Help {
    private String pinglun;
    private String text;

    public Help(String pinglun, String text) {
        this.pinglun = pinglun;
        this.text = text;
    }


    public String getPinglun() {
        return pinglun;
    }

    public String getText() {
        return text;
    }
}
