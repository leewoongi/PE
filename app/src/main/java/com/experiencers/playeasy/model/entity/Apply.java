package com.experiencers.playeasy.model.entity;

public class Apply {
    private int quota;
    private String type;
    private int matchId;

    public Apply(int quota, String type, int matchId) {
        this.quota = quota;
        this.type = type;
        this.matchId = matchId;
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

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}
