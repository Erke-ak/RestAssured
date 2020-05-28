package com.automation.pojos;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("location_id")
    private int locationId;

    @SerializedName("street_address")
    private String street_address;

    @SerializedName("postal_code")
    private String postal_code;

    @SerializedName("city")
    private String city;

    @SerializedName("state_province")
    private String stateProvince;

    @SerializedName("country_id")
    private String country_id;

    public Location(){

    }

    public Location(int location_id, String street_address, String postal_code, String city, String stateProvince, String country_id) {
        this.locationId = location_id;
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country_id = country_id;
    }

    public int getLocation_id() {
        return locationId;
    }

    public void setLocation_id(int location_id) {
        this.locationId = location_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + locationId +
                ", street_address='" + street_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country_id='" + country_id + '\'' +
                '}';
    }
}
