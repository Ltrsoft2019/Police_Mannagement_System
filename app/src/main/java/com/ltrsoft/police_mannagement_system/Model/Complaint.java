package com.ltrsoft.police_mannagement_system.Model;

public class Complaint {

    private String complaint_id,complaint_subject, complaint_description,against,inscidant_date,
    status_id, latitude,longitude, user_id,complaint_fir_id,subtype_id,complaint_type;

    public Complaint(String complaint_id, String complaint_subject, String complaint_description, String against, String inscidant_date, String status_id, String latitude, String longitude, String user_id, String complaint_fir_id, String subtype_id,String complaint_type) {
        this.complaint_id = complaint_id;
        this.complaint_subject = complaint_subject;
        this.complaint_description = complaint_description;
        this.against = against;
        this.inscidant_date = inscidant_date;
        this.status_id = status_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user_id = user_id;
        this.complaint_fir_id = complaint_fir_id;
        this.subtype_id = subtype_id;
        this.complaint_type=complaint_type;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getComplaint_subject() {
        return complaint_subject;
    }

    public void setComplaint_subject(String complaint_subject) {
        this.complaint_subject = complaint_subject;
    }

    public String getComplaint_description() {
        return complaint_description;
    }

    public void setComplaint_description(String complaint_description) {
        this.complaint_description = complaint_description;
    }

    public String getAgainst() {
        return against;
    }

    public void setAgainst(String against) {
        this.against = against;
    }

    public String getInscidant_date() {
        return inscidant_date;
    }

    public void setInscidant_date(String inscidant_date) {
        this.inscidant_date = inscidant_date;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComplaint_fir_id() {
        return complaint_fir_id;
    }

    public void setComplaint_fir_id(String complaint_fir_id) {
        this.complaint_fir_id = complaint_fir_id;
    }

    public String getSubtype_id() {
        return subtype_id;
    }

    public void setSubtype_id(String subtype_id) {
        this.subtype_id = subtype_id;
    }

}
