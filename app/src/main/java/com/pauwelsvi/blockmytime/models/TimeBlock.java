package com.pauwelsvi.blockmytime.models;

import java.io.Serializable;

public class TimeBlock implements Serializable {

    private Long _id;
    private String title;
    private long time;

    public TimeBlock() {
        // empty constructor for cupboard
    }

    public TimeBlock(String title, long time) {
        this.title = title;
        this.time = time;
    }

    public Long getId() {
        return _id;
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

    public void setTime(long time) {
        this.time = time;
    }

}
