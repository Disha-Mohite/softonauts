package com.gwebcircle.softonauts.model;

import android.widget.ArrayAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSlots {

    @JsonProperty("show_date")
    private String showdate;

    @JsonProperty("current_date")
    private String currentdate;

    @JsonProperty("day")
    private String day;

    @JsonProperty("slotes")
    private ArrayList<TimeSlotstwo> slotstwoaraylist = null;

    @JsonProperty("count")
    private int count;

    @JsonProperty("booked")
    private ArrayList<String> bookedlist = null;

    @JsonProperty("next_availability")
    private String nextavilable;

    @JsonProperty("next_availability_search")
    private String nextavailablesearch;


    public ArrayList<TimeSlotstwo> getSlotstwoaraylist() {
        return slotstwoaraylist;
    }

    public void setSlotstwoaraylist(ArrayList<TimeSlotstwo> slotstwoaraylist) {
        this.slotstwoaraylist = slotstwoaraylist;
    }

    public ArrayList<String> getBookedlist() {
        return bookedlist;
    }

    public void setBookedlist(ArrayList<String> bookedlist) {
        this.bookedlist = bookedlist;
    }
}
