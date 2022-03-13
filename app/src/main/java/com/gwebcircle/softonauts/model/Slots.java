package com.gwebcircle.softonauts.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Slots implements Parcelable {

   public String showdate, currentdate , day;
   public ArrayList<TimeSlots> slots = new ArrayList<>();
   public int count;
   public List<String> booked = new ArrayList<>();
   public String nextavlbl;
   public String nextavlblserch;

    public Slots() {
    }

    public Slots(String showdate, String currentdate, String day, ArrayList<TimeSlots> slots, int count, List<String> booked, String nextavlbl, String nextavlblserch) {
        this.showdate = showdate;
        this.currentdate = currentdate;
        this.day = day;
        this.slots = slots;
        this.count = count;
        this.booked = booked;
        this.nextavlbl = nextavlbl;
        this.nextavlblserch = nextavlblserch;
    }

    public static final Creator<Slots> CREATOR = new Creator<Slots>() {
        @Override
        public Slots createFromParcel(Parcel in) {
            return new Slots(in);
        }

        @Override
        public Slots[] newArray(int size) {
            return new Slots[size];
        }
    };

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<TimeSlots> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<TimeSlots> slots) {
        this.slots = slots;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getBooked() {
        return booked;
    }

    public void setBooked(List<String> booked) {
        this.booked = booked;
    }

    public String getNextavlbl() {
        return nextavlbl;
    }

    public void setNextavlbl(String nextavlbl) {
        this.nextavlbl = nextavlbl;
    }

    public String getNextavlblserch() {
        return nextavlblserch;
    }

    public void setNextavlblserch(String nextavlblserch) {
        this.nextavlblserch = nextavlblserch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Slots(Parcel in){

        showdate = in.readString();
        currentdate = in.readString();
        day = in.readString();
        count = in.readInt();
        booked = in.createStringArrayList();
        nextavlbl = in.readString();
        nextavlblserch = in.readString();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(showdate);
        parcel.writeString(currentdate);
        parcel.writeString(day);
        parcel.writeInt(count);
        parcel.writeStringList(booked);
        parcel.writeString(nextavlbl);
        parcel.writeString(nextavlblserch);
    }
}
