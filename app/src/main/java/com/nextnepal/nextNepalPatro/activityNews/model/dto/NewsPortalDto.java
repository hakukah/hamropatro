package com.nextnepal.nextNepalPatro.activityNews.model.dto;

import android.graphics.Bitmap;

public class NewsPortalDto {
    private int id;
    private String newsTitle;
    private String newsBody;
    private Bitmap newsIcon;

    public NewsPortalDto() {
    }

    public NewsPortalDto(int id, String newsTitle, Bitmap newsIcon) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsIcon = newsIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public Bitmap getNewsIcon() {
        return newsIcon;
    }

    public void setNewsIcon(Bitmap newsIcon) {
        this.newsIcon = newsIcon;
    }
}
