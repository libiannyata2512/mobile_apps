package com.libian.lacakaku;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    @SerializedName("salesman_id")
    private String salesman;
    @SerializedName("distributor_id")
    private String distributor;
    @SerializedName("battery_status")
    private int battery;
    @SerializedName("return_lat")
    private String lat;
    @SerializedName("return_lng")
    private String lng;
    @SerializedName("message")
    private String message;
    @SerializedName("response_code")
    private int responseCode;

    public ServerResponse(String salesman, String distributor, int battery, String lat, String lng, String message, int responseCode) {
        this.salesman = salesman;
        this.distributor = distributor;
        this.battery = battery;
        this.lat = lat;
        this.lng = lng;
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
