package com.pauwelsvi.blockmytime.models;

public class TimeBlock {

    private String title;
    private int time;

    public TimeBlock(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
