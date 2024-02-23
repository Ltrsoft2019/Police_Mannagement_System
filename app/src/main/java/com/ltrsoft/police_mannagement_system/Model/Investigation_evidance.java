package com.ltrsoft.police_mannagement_system.Model;

public class Investigation_evidance {
    private  String investigation_evidence_id,	evidence_number_identifier,	complaint_id,	date_and_time_of_evidence_seizure,
    type_id,	description_of_item,	serial_numbers_or_unique_identifiers,	packaging_details,	investigation_id;

    public String getInvestigation_evidence_id() {
        return investigation_evidence_id;
    }

    public void setInvestigation_evidence_id(String investigation_evidence_id) {
        this.investigation_evidence_id = investigation_evidence_id;
    }

    public String getEvidence_number_identifier() {
        return evidence_number_identifier;
    }

    public void setEvidence_number_identifier(String evidence_number_identifier) {
        this.evidence_number_identifier = evidence_number_identifier;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getDate_and_time_of_evidence_seizure() {
        return date_and_time_of_evidence_seizure;
    }

    public void setDate_and_time_of_evidence_seizure(String date_and_time_of_evidence_seizure) {
        this.date_and_time_of_evidence_seizure = date_and_time_of_evidence_seizure;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getDescription_of_item() {
        return description_of_item;
    }

    public void setDescription_of_item(String description_of_item) {
        this.description_of_item = description_of_item;
    }

    public String getSerial_numbers_or_unique_identifiers() {
        return serial_numbers_or_unique_identifiers;
    }

    public void setSerial_numbers_or_unique_identifiers(String serial_numbers_or_unique_identifiers) {
        this.serial_numbers_or_unique_identifiers = serial_numbers_or_unique_identifiers;
    }

    public String getPackaging_details() {
        return packaging_details;
    }

    public void setPackaging_details(String packaging_details) {
        this.packaging_details = packaging_details;
    }

    public String getInvestigation_id() {
        return investigation_id;
    }

    public void setInvestigation_id(String investigation_id) {
        this.investigation_id = investigation_id;
    }
}
