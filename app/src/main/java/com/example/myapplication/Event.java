package com.example.myapplication;

public class Event {
    private String eventName;
    private String eventLocation;
    private String eventTime;

    public Event(String eventName, String eventLocation, String eventTime) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventTime = eventTime;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return
                "eventName='" + eventName + '\'' +
                        ", eventLocation='" + eventLocation + '\'' +
                        ", eventTime='" + eventTime;
    }
}

