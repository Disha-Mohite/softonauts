package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DropInNavigatorTwo {

    @JsonProperty("navigator_name")
    public String navigatorname;

    @JsonProperty("location_id")
    public List<String> locationid = null;

    @JsonProperty("navigator_location")
    private List<String> navigatorlocation = null;

    @JsonProperty("navigator_city")
    private List<String> navigatorcity = null;

    @JsonProperty("navigator_zipcode")
    private List<String> navigatorzipcode = null;

    @JsonProperty("appointment_type")
    private ArrayList<AppointmentType> appointmenttype = null;

    public List<String> getLocationid() {
        return locationid;
    }

    public void setLocationid(List<String> locationid) {
        this.locationid = locationid;
    }

    public List<String> getNavigatorlocation() {
        return navigatorlocation;
    }

    public void setNavigatorlocation(List<String> navigatorlocation) {
        this.navigatorlocation = navigatorlocation;
    }

    public List<String> getNavigatorcity() {
        return navigatorcity;
    }

    public void setNavigatorcity(List<String> navigatorcity) {
        this.navigatorcity = navigatorcity;
    }

    public List<String> getNavigatorzipcode() {
        return navigatorzipcode;
    }

    public void setNavigatorzipcode(List<String> navigatorzipcode) {
        this.navigatorzipcode = navigatorzipcode;
    }

    public ArrayList<AppointmentType> getAppointmenttype() {
        return appointmenttype;
    }

    public void setAppointmenttype(ArrayList<AppointmentType> appointmenttype) {
        this.appointmenttype = appointmenttype;
    }
}
