package com.ltrsoft.police_mannagement_system.Model;

public class QuickComplaint {

    private String station_id,
    user_id,
            photo_path,
    description,
            address,
    status_id,
            latitute,
    quick_complaint_id;

    public QuickComplaint(String station_id, String user_id, String photo_path,
                          String description, String address, String status_id,
                          String latitute, String quick_complaint_id) {
        this.station_id = station_id;
        this.user_id = user_id;
        this.photo_path = photo_path;
        this.description = description;
        this.address = address;
        this.status_id = status_id;
        this.latitute = latitute;
        this.quick_complaint_id = quick_complaint_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getQuick_complaint_id() {
        return quick_complaint_id;
    }

    public void setQuick_complaint_id(String quick_complaint_id) {
        this.quick_complaint_id = quick_complaint_id;
    }
}
