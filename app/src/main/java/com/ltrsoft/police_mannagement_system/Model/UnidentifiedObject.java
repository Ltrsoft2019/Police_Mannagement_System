package com.ltrsoft.police_mannagement_system.Model;

public class UnidentifiedObject {

    private String unidentified_object_id,
            date_and_time_of_discovery,
            location_found,
            object_condition,
            identifying_marks_or_features,
            object_description,
            photo_path,
            latitude,
            longitude,
            station_id,
            user_id;

    public UnidentifiedObject(String unidentified_object_id, String date_and_time_of_discovery, String location_found, String object_condition, String identifying_marks_or_features, String object_description, String photo_path, String latitude, String longitude, String station_id, String user_id) {
        this.unidentified_object_id = unidentified_object_id;
        this.date_and_time_of_discovery = date_and_time_of_discovery;
        this.location_found = location_found;
        this.object_condition = object_condition;
        this.identifying_marks_or_features = identifying_marks_or_features;
        this.object_description = object_description;
        this.photo_path = photo_path;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station_id = station_id;
        this.user_id=user_id;
    }

    public String getUnidentified_object_id() {
        return unidentified_object_id;
    }

    public void setUnidentified_object_id(String unidentified_object_id) {
        this.unidentified_object_id = unidentified_object_id;
    }

    public String getDate_and_time_of_discovery() {
        return date_and_time_of_discovery;
    }

    public void setDate_and_time_of_discovery(String date_and_time_of_discovery) {
        this.date_and_time_of_discovery = date_and_time_of_discovery;
    }

    public String getLocation_found() {
        return location_found;
    }

    public void setLocation_found(String location_found) {
        this.location_found = location_found;
    }

    public String getObject_condition() {
        return object_condition;
    }

    public void setObject_condition(String object_condition) {
        this.object_condition = object_condition;
    }

    public String getIdentifying_marks_or_features() {
        return identifying_marks_or_features;
    }

    public void setIdentifying_marks_or_features(String identifying_marks_or_features) {
        this.identifying_marks_or_features = identifying_marks_or_features;
    }

    public String getObject_description() {
        return object_description;
    }

    public void setObject_description(String object_description) {
        this.object_description = object_description;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
