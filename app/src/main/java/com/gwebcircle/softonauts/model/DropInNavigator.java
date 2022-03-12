package com.gwebcircle.softonauts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DropInNavigator {
    @JsonProperty("code")
    private int code;

    @JsonProperty("status")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("drop_in_navigator_list")
    public ArrayList<DropInNavigatorTwo> dropinlist;


    public ArrayList<DropInNavigatorTwo> getDropinlist() {
        return dropinlist;
    }

    public void setDropinlist(ArrayList<DropInNavigatorTwo> dropinlist) {
        this.dropinlist = dropinlist;
    }
}
