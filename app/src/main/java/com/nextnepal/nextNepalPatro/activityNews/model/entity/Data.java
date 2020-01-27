package com.nextnepal.nextNepalPatro.activityNews.model.entity;

public class Data {
    private String media;
    private String comments;

    private String link;

    private String guid;

    private String[] description;

    private String title;

    private String[][] category;

    private String pubDate;

    private String url;

    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[][] getCategory() {
        return category;
    }

    public void setCategory(String[][] category) {
        this.category = category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "ClassPojo [comments = " + comments + ", link = " + link + ", guid = " + guid + ", description = " + description + ", title = " + title + ", category = " + category + ", pubDate = " + pubDate + ", url = " + url + "]";
    }
}
