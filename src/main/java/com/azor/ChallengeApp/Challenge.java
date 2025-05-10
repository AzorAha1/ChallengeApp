package com.azor.ChallengeApp;

public class Challenge {
    private long id;
    private String month;
    private String description;
    private String status;

    public Challenge(long id, String month, String description, String status) {
        this.id = id;
        this.month = month;
        this.description = description;
        this.status = status;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
