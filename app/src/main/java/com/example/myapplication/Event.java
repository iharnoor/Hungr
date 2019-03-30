package com.example.myapplication;

public class Event {
    private String eventName;
    private String eventLocation;
    private String comeBy;

    public Event(String eventName, String eventLocation, String comeBy) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.comeBy = comeBy;
    }

    public String getComeBy() {
        return comeBy;
    }

    public void setComeBy(String comeBy) {
        this.comeBy = comeBy;
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
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", comeBy='" + comeBy + '\'' +
                '}';
    }
}

