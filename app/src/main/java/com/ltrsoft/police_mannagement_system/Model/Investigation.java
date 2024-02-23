package com.ltrsoft.police_mannagement_system.Model;

public class Investigation {
        private  String investigation_id, investigation_start_date, investigation_end_date, location,
                complaint_id, incedant_reporting, evidance_property, investigation_description;

    public String getInvestigation_id() {
        return investigation_id;
    }

    public void setInvestigation_id(String investigation_id) {
        this.investigation_id = investigation_id;
    }

    public String getInvestigation_start_date() {
        return investigation_start_date;
    }

    public void setInvestigation_start_date(String investigation_start_date) {
        this.investigation_start_date = investigation_start_date;
    }

    public String getInvestigation_end_date() {
        return investigation_end_date;
    }

    public void setInvestigation_end_date(String investigation_end_date) {
        this.investigation_end_date = investigation_end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getIncedant_reporting() {
        return incedant_reporting;
    }

    public void setIncedant_reporting(String incedant_reporting) {
        this.incedant_reporting = incedant_reporting;
    }

    public String getEvidance_property() {
        return evidance_property;
    }

    public void setEvidance_property(String evidance_property) {
        this.evidance_property = evidance_property;
    }

    public String getInvestigation_description() {
        return investigation_description;
    }

    public void setInvestigation_description(String investigation_description) {
        this.investigation_description = investigation_description;
    }
}
