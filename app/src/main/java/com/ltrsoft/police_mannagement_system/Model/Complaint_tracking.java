package com.ltrsoft.police_mannagement_system.Model;

public class Complaint_tracking {
    private String 	tracking_id	,fir_id	,tracking_date,	description,	police_id;

    public String getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(String tracking_id) {
        this.tracking_id = tracking_id;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getTracking_date() {
        return tracking_date;
    }

    public void setTracking_date(String tracking_date) {
        this.tracking_date = tracking_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }
}
