package com.ltrsoft.police_mannagement_system.Model;

public class Station {
    private String police_station_id,police_station_name;

    public Station(String police_station_id, String police_station_name) {
        this.police_station_id = police_station_id;
        this.police_station_name = police_station_name;
    }

    public String getPolice_station_id() {
        return police_station_id;
    }

    public void setPolice_station_id(String police_station_id) {
        this.police_station_id = police_station_id;
    }

    public String getPolice_station_name() {
        return police_station_name;
    }

    public void setPolice_station_name(String police_station_name) {
        this.police_station_name = police_station_name;
    }
}
