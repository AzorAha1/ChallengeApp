package com.azor.ChallengeApp;

public class Challenge {
    private Long id;
    private String month;
    private String description;
    private String status;

    public Challenge(Long id, String month, String description, String status) {
        this.id = id;
        this.month = month;
        this.description = description;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

