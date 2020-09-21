package com.ourteam.covid_19;

public class Hospital {
    private String name;
    private String Address;
    private String phone;
    private String lat;
    private String lon;

    public Hospital(String name, String address, String phone, String lat, String lon) {
        this.name = name;
        Address = address;
        this.phone = phone;
        this.lat = lat;
        this.lon = lon;
    }

    public Hospital() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}