package com.example.lbw.guaniu.Square;

/**
 * Created by lbw on 2017/8/5.
 */

//没有设置具体内容的添加字段
public class Square {
    private int imageId;
    private String title;
    private String text;
    private String time;
    private String praise;
    private String discuss;
    private int viewType;

    public Square(int imageId, String title, String text, String time, String praise, String discuss, int viewType) {
        this.imageId = imageId;
        this.title = title;
        this.text = text;
        this.time = time;
        this.praise = praise;
        this.discuss = discuss;
        this.viewType = viewType;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getDiscuss() {
        return discuss;
    }

    public void setDiscuss(String discuss) {
        this.discuss = discuss;
    }
}
