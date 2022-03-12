package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentType {

    @JsonProperty("id")
    public int id;

    @JsonProperty("appointment_type")
    public String appointmenttype;
}
