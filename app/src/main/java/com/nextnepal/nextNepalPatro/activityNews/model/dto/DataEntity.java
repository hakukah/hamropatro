package com.nextnepal.nextNepalPatro.activityNews.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataEntity {
    @SerializedName("item")
    private ArrayList<ItemEntity> item;
    @SerializedName("image")
    private ImageEntity image;
    private String generator;
    private String language;
    private String lastbuildDate;
    private String description;
    private String link;
    private String title;

    public ArrayList<ItemEntity> getItem() {
        return item;
    }

    public void setItem(ArrayList<ItemEntity> item) {
        this.item = item;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastbuildDate() {
        return lastbuildDate;
    }

    public void setLastbuildDate(String lastbuildDate) {
        this.lastbuildDate = lastbuildDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
