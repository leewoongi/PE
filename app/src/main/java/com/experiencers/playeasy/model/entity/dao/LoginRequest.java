package com.experiencers.playeasy.model.entity.dao;

public class LoginRequest {
    private String access_token;

    public LoginRequest(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
