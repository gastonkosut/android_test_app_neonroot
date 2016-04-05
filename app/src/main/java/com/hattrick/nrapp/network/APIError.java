package com.hattrick.nrapp.network;

/**
 * Created by gastonkosut on 4/5/16.
 */
public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}

