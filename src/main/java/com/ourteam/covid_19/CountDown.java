package com.ourteam.covid_19;

public class CountDown {
    private String totalCase;
    private String deaths;
    private String country;

    public CountDown(String totalCase, String deaths, String country) {
        this.totalCase = totalCase;
        this.deaths = deaths;
        this.country = country;
    }

    public CountDown() {
    }

    public String getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(String totalCase) {
        this.totalCase = totalCase;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
