package com.ltrsoft.police_mannagement_system.Model;

public class City {
        private String city_id,city_name,district_id;

    public City(String city_id, String city_name, String district_id) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.district_id = district_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }
}
