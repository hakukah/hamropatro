package com.nextnepal.nextNepalPatro.activityRadio.model.dto;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class StreamDto {
    private String name;
    private String slogan;
    private Bitmap icon;


    @SerializedName("stream")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
