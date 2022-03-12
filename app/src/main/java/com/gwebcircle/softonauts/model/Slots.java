package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Slots {
    @JsonProperty("code")
    private int code;

    @JsonProperty("status")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timeslots")
    public ArrayList<TimeSlots> timeslotslist;

    public ArrayList<TimeSlots> getTimeslotslist() {
        return timeslotslist;
    }

    public void setTimeslotslist(ArrayList<TimeSlots> timeslotslist) {
        this.timeslotslist = timeslotslist;
    }
}
