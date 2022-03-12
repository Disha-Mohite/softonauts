package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NavigatorListt {

    @JsonProperty("location_id")
    public List<String> locationid = null;
}
