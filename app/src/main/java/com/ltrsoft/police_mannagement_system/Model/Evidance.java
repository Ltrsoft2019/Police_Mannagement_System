package com.ltrsoft.police_mannagement_system.Model;

public class Evidance {
   private String evidence_id, evidence_number, complaint_id, seizure_date_time, type_id, item_description, serial_numbers_or_identifiers;

    public String getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(String evidence_id) {
        this.evidence_id = evidence_id;
    }

    public String getEvidence_number() {
        return evidence_number;
    }

    public void setEvidence_number(String evidence_number) {
        this.evidence_number = evidence_number;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getSeizure_date_time() {
        return seizure_date_time;
    }

    public void setSeizure_date_time(String seizure_date_time) {
        this.seizure_date_time = seizure_date_time;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getSerial_numbers_or_identifiers() {
        return serial_numbers_or_identifiers;
    }

    public void setSerial_numbers_or_identifiers(String serial_numbers_or_identifiers) {
        this.serial_numbers_or_identifiers = serial_numbers_or_identifiers;
    }
}
