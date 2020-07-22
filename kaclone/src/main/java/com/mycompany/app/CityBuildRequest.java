package com.mycompany.app;

public class CityBuildRequest {
    private String ownerId;
    private String cityName;

    public String getOwnerId() {
        return ownerId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}