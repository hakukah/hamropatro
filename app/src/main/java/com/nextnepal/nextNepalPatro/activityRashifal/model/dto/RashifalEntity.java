package com.nextnepal.nextNepalPatro.activityRashifal.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RashifalEntity {

    @SerializedName("rashi")
    private List<RashifalDto> data;
    private String dates;

    public List<RashifalDto> getData() {
        return data;
    }

    public void setData(List<RashifalDto> data) {
        this.data = data;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }


}
