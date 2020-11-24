package com.experiencers.playeasy.model.entity;

public class CloseMatchRequest {
    private int matchId;
    private String status;

    public CloseMatchRequest(int matchId, String status) {
        this.matchId = matchId;
        this.status = status;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
