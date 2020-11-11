package com.experiencers.playeasy.model.entity;

public class MatchLocation {

    private int id;
    private String address;
    private String detail;

    public MatchLocation(int id, String address, String detail) {
        this.id = id;
        this.address = address;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
