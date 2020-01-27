package com.nextnepal.nextNepalPatro.activityNews.model.dto;

import com.google.gson.annotations.SerializedName;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

public class NewsDto extends BaseResponse {

    @SerializedName("data")
    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }
}
