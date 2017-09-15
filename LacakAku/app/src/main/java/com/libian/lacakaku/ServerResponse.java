package com.libian.lacakaku;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    @SerializedName("slsno")
    private String slsno;
    @SerializedName("dist")
    private String dist;
    @SerializedName("battery")
    private int battery;
    @SerializedName("la")
    private String la;
    @SerializedName("lg")
    private String lg;

    public ServerResponse(String slsno, String dist, int battery, String la, String lg) {
        this.slsno = slsno;
        this.dist = dist;
        this.battery = battery;
        this.la = la;
        this.lg = lg;
    }

    public String getSlsno() {
        return slsno;
    }

    public void setSlsno(String slsno) {
        this.slsno = slsno;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }
}
