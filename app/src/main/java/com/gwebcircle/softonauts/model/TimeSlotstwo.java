package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSlotstwo {


    @JsonProperty("morning")
    private ArrayList<String> morlingslots = null;


    @JsonProperty("afternoon")
    private ArrayList<String> afternoonslots = null;

    @JsonProperty("evening")
    private ArrayList<String> eveningslots = null;

    @JsonProperty("night")
    private ArrayList<String> nightslots = null;


    public ArrayList<String> getMorlingslots() {
        return morlingslots;
    }

    public void setMorlingslots(ArrayList<String> morlingslots) {
        this.morlingslots = morlingslots;
    }

    public ArrayList<String> getAfternoonslots() {
        return afternoonslots;
    }

    public void setAfternoonslots(ArrayList<String> afternoonslots) {
        this.afternoonslots = afternoonslots;
    }

    public ArrayList<String> getEveningslots() {
        return eveningslots;
    }

    public void setEveningslots(ArrayList<String> eveningslots) {
        this.eveningslots = eveningslots;
    }

    public ArrayList<String> getNightslots() {
        return nightslots;
    }

    public void setNightslots(ArrayList<String> nightslots) {
        this.nightslots = nightslots;
    }
}
