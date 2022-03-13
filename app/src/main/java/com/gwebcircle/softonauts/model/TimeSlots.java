package com.gwebcircle.softonauts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class TimeSlots  {


    public List<String> morning;
    public List<String> noonlist;
    public List<String> eveninglist;
    public List<String> nightlist;


    public TimeSlots() {
    }

    public TimeSlots(List<String> morning, List<String> noonlist, List<String> eveninglist, List<String> nightlist) {
        this.morning = morning;
        this.noonlist = noonlist;
        this.eveninglist = eveninglist;
        this.nightlist = nightlist;
    }

    public List<String> getMorning() {
        return morning;
    }

    public void setMorning(List<String> morning) {
        this.morning = morning;
    }

    public List<String> getNoonlist() {
        return noonlist;
    }

    public void setNoonlist(List<String> noonlist) {
        this.noonlist = noonlist;
    }

    public List<String> getEveninglist() {
        return eveninglist;
    }

    public void setEveninglist(List<String> eveninglist) {
        this.eveninglist = eveninglist;
    }

    public List<String> getNightlist() {
        return nightlist;
    }

    public void setNightlist(List<String> nightlist) {
        this.nightlist = nightlist;
    }
}
