package com.ltrsoft.police_mannagement_system.Model;

public class PoliceStation {
    private String district_id,station_name,station_id;

    public PoliceStation(String district_id, String station_name, String station_id) {
        this.district_id = district_id;
        this.station_name = station_name;
        this.station_id = station_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
