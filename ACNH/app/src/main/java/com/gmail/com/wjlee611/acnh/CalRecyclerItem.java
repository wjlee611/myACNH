package com.gmail.com.wjlee611.acnh;

public class CalRecyclerItem {
    private String dayStr;
    private String eventStr;

    public void setDay(String day) {
        dayStr = day;
    }

    public void setEvent(String event) {
        eventStr = event;
    }


    public String getDay() {
        return this.dayStr;
    }

    public String getEvent() {
        return this.eventStr;
    }
}
