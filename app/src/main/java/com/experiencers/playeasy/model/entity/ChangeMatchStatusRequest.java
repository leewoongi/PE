package com.experiencers.playeasy.model.entity;

public class ChangeMatchStatusRequest {
    private int applicationId;
    private String status;

    public ChangeMatchStatusRequest(int applicationId, String status) {
        this.applicationId = applicationId;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
