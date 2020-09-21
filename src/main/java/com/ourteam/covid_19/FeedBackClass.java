package com.ourteam.covid_19;

public class FeedBackClass {
    private String name;
    private String feedback;

    public FeedBackClass(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }

    public FeedBackClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
