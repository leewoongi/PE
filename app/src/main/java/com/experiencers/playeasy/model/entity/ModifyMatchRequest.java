package com.experiencers.playeasy.model.entity;

public class ModifyMatchRequest {
    private int id;
    private String type;
    private String description;
    private String startAt;
    private String endAt;
    private int fee;
    private String phone;
    private int quota;
    private int mapId;
    private String placeName;
    private String addressName;
    private String placeDetail;

    public ModifyMatchRequest(int id, String type, String description, String startAt, String endAt, int fee, String phone, int quota, int mapId, String placeName, String addressName, String placeDetail) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.startAt = startAt;
        this.endAt = endAt;
        this.fee = fee;
        this.phone = phone;
        this.quota = quota;
        this.mapId = mapId;
        this.placeName = placeName;
        this.addressName = addressName;
        this.placeDetail = placeDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPlaceDetail() {
        return placeDetail;
    }

    public void setPlaceDetail(String placeDetail) {
        this.placeDetail = placeDetail;
    }
}
