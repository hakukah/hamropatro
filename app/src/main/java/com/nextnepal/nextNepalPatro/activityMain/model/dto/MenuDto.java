package com.nextnepal.nextNepalPatro.activityMain.model.dto;

import android.graphics.Bitmap;

public class MenuDto {
    private int id;
    private Bitmap icon;
    private String name;

    public MenuDto() {
    }

    public MenuDto(Bitmap icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
