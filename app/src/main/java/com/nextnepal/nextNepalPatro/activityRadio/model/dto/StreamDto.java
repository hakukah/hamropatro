package com.nextnepal.nextNepalPatro.activityRadio.model.dto;

import com.google.gson.annotations.SerializedName;

public class StreamDto {
    private String name;
    private String slogan;
    private String iconurl;
    private String frequency;


    @SerializedName("stream")
    private String url;

    public StreamDto() {
    }

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

    public String getIcon() { return iconurl; }

    public void setIcon(String icon) { this.iconurl = icon; }

    public String getFrequency() { return frequency; }

    public void setFrequency(String frequency) { this.frequency = frequency; }
}
