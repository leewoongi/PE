package com.experiencers.playeasy.model.entity;

public class ApplyStatusResponse {
    private int id;
    private int quota;
    private String type;
    private String status;
    private StatusUser user;
    private StatusMatch match;

    public ApplyStatusResponse(int id, int quota, String type, String status, StatusUser user, StatusMatch match) {
        this.id = id;
        this.quota = quota;
        this.type = type;
        this.status = status;
        this.user = user;
        this.match = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusUser getUser() {
        return user;
    }

    public void setUser(StatusUser user) {
        this.user = user;
    }

    public StatusMatch getMatch() {
        return match;
    }

    public void setMatch(StatusMatch match) {
        this.match = match;
    }
}
