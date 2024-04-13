package com.ltrsoft.police_mannagement_system.Model;

public class Grivence {

    private String grievance_id, nature_of_grievance, date, location, description,
            photo, audio_video, action_required, outcome, user_id, status_id, station_id;

    public Grivence(String grievance_id, String nature_of_grievance, String date,
                    String location, String description, String photo, String audio_video,
                    String action_required, String outcome, String user_id, String status_id,
                    String station_id) {
        this.grievance_id = grievance_id;
        this.nature_of_grievance = nature_of_grievance;
        this.date = date;
        this.location = location;
        this.description = description;
        this.photo = photo;
        this.audio_video = audio_video;
        this.action_required = action_required;
        this.outcome = outcome;
        this.user_id = user_id;
        this.status_id = status_id;
        this.station_id = station_id;
    }

    public String getGrievance_id() {
        return grievance_id;
    }

    public void setGrievance_id(String grievance_id) {
        this.grievance_id = grievance_id;
    }

    public String getNature_of_grievance() {
        return nature_of_grievance;
    }

    public void setNature_of_grievance(String nature_of_grievance) {
        this.nature_of_grievance = nature_of_grievance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAudio_video() {
        return audio_video;
    }

    public void setAudio_video(String audio_video) {
        this.audio_video = audio_video;
    }

    public String getAction_required() {
        return action_required;
    }

    public void setAction_required(String action_required) {
        this.action_required = action_required;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
