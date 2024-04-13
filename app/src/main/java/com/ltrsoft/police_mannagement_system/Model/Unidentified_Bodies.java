package com.ltrsoft.police_mannagement_system.Model;

public class Unidentified_Bodies {

    private String unidentify_bodies_id,
            date_and_time_of_discovery,
    location_found,
    gender,
    age_estimate,
    height,
    weight,
    build,
    race_ethnicity,
    hair_color_style,
    eye_color,
    distinguishing_features,
    description_of_clothing,
    body_condition,
    latitute,
    longitute,
    station_id,user_id;

    public Unidentified_Bodies(String unidentify_bodies_id, String date_and_time_of_discovery, String location_found, String gender, String age_estimate, String height, String weight, String build, String race_ethnicity, String hair_color_style, String eye_color, String distinguishing_features, String description_of_clothing, String body_condition, String latitute, String longitute, String station_id,String user_id) {
        this.unidentify_bodies_id = unidentify_bodies_id;
        this.date_and_time_of_discovery = date_and_time_of_discovery;
        this.location_found = location_found;
        this.gender = gender;
        this.age_estimate = age_estimate;
        this.height = height;
        this.weight = weight;
        this.build = build;
        this.race_ethnicity = race_ethnicity;
        this.hair_color_style = hair_color_style;
        this.eye_color = eye_color;
        this.distinguishing_features = distinguishing_features;
        this.description_of_clothing = description_of_clothing;
        this.body_condition = body_condition;
        this.latitute = latitute;
        this.longitute = longitute;
        this.station_id = station_id;
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUnidentify_bodies_id() {
        return unidentify_bodies_id;
    }

    public void setUnidentify_bodies_id(String unidentify_bodies_id) {
        this.unidentify_bodies_id = unidentify_bodies_id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge_estimate() {
        return age_estimate;
    }

    public void setAge_estimate(String age_estimate) {
        this.age_estimate = age_estimate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getRace_ethnicity() {
        return race_ethnicity;
    }

    public void setRace_ethnicity(String race_ethnicity) {
        this.race_ethnicity = race_ethnicity;
    }

    public String getHair_color_style() {
        return hair_color_style;
    }

    public void setHair_color_style(String hair_color_style) {
        this.hair_color_style = hair_color_style;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getDistinguishing_features() {
        return distinguishing_features;
    }

    public void setDistinguishing_features(String distinguishing_features) {
        this.distinguishing_features = distinguishing_features;
    }

    public String getDescription_of_clothing() {
        return description_of_clothing;
    }

    public void setDescription_of_clothing(String description_of_clothing) {
        this.description_of_clothing = description_of_clothing;
    }

    public String getBody_condition() {
        return body_condition;
    }

    public void setBody_condition(String body_condition) {
        this.body_condition = body_condition;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
