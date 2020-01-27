package com.nextnepal.nextNepalPatro.activityLiveStream.model.dto;

import java.util.List;

public class LiveStreamEntity {

    private List<LiveStreamDataDto> data;

    public List<LiveStreamDataDto> getData() {
        return data;
    }

    public void setData(List<LiveStreamDataDto> data) {
        this.data = data;
    }
}
