package com.gwebcircle.softonauts.retrofit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SrvRes<T> {
    @JsonProperty("code")
    private int code;

    @JsonProperty("status")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<T> data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getData() {
        return data;
    }
}
