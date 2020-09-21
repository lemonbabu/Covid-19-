package com.ourteam.covid_19;

public class TriggerUpdate {
    private String triggerValue;

    public TriggerUpdate(String triggerValue) {
        this.triggerValue = triggerValue;
    }

    public TriggerUpdate() {
    }

    public String getTriggerValue() {
        return triggerValue;
    }

    public void setTriggerValue(String triggerValue) {
        this.triggerValue = triggerValue;
    }
}
