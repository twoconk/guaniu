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

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public int getViewType() {
        return viewType;
    }

    public String getPraise() {
        return praise;
    }

    public String getDiscuss() {
        return discuss;
    }
    public void setPraise(String praise){
        this.praise = praise;
    }

}
