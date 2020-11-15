package com.experiencers.playeasy.model.entity;

public class Location {

    private int id;
    private int mapId;
    private String placeName;
    private String addressName;
    private String placeDetail;

    public Location(int id, int mapId, String placeName, String addressName, String placeDetail) {
        this.id = id;
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

