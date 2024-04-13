package com.ltrsoft.police_mannagement_system.Model;

public class CyberCrimemodel {

    private String cyber_crime_id, cyber_crime_category_id,lost_money, date_time, is_delay,
    where_accure, evidance_photo, description, user_id,station_id,status_id;

    public CyberCrimemodel(String cyber_crime_id, String cyber_crime_category_id, String lost_money, String date_time, String is_delay, String where_accure, String evidance_photo, String description, String user_id, String station_id, String status_id) {
        this.cyber_crime_id = cyber_crime_id;
        this.cyber_crime_category_id = cyber_crime_category_id;
        this.lost_money = lost_money;
        this.date_time = date_time;
        this.is_delay = is_delay;
        this.where_accure = where_accure;
        this.evidance_photo = evidance_photo;
        this.description = description;
        this.user_id = user_id;
        this.station_id = station_id;
        this.status_id = status_id;
    }

    public String getCyber_crime_id() {
        return cyber_crime_id;
    }

    public void setCyber_crime_id(String cyber_crime_id) {
        this.cyber_crime_id = cyber_crime_id;
    }

    public String getCyber_crime_category_id() {
        return cyber_crime_category_id;
    }

    public void setCyber_crime_category_id(String cyber_crime_category_id) {
        this.cyber_crime_category_id = cyber_crime_category_id;
    }

    public String getLost_money() {
        return lost_money;
    }

    public void setLost_money(String lost_money) {
        this.lost_money = lost_money;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getIs_delay() {
        return is_delay;
    }

    public void setIs_delay(String is_delay) {
        this.is_delay = is_delay;
    }

    public String getWhere_accure() {
        return where_accure;
    }

    public void setWhere_accure(String where_accure) {
        this.where_accure = where_accure;
    }

    public String getEvidance_photo() {
        return evidance_photo;
    }

    public void setEvidance_photo(String evidance_photo) {
        this.evidance_photo = evidance_photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
}
