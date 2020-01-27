package com.nextnepal.nextNepalPatro.calendar.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PatroEvent {
    @SerializedName("event_db")
    @Expose
    private List<EventDto> eventDto = null;

    public List<EventDto> getEventDto() {
        return eventDto;
    }

    public void setEventDto(List<EventDto> eventDto) {
        this.eventDto = eventDto;
    }
}
