package com.ltrsoft.police_mannagement_system.Model;

public class DomesticWorkers {

    private String domestic_id, user_id, full_name_of_domestic_help, gender, date_of_birth, permanent_address, contact_number, email_address, name_of_previous_employer, duration_of_employment, reason_for_leaving, identification_documents_submitted, identity_proof_doc_number, identity_proof_issuing_authority, identity_proof_date_of_issue, identity_proof_date_of_expiry, address_proof_doc_number, address_proof_issuing_authority, address_proof_date_of_issue, purpose_of_employment, job_title_or_role, start_date_of_employment, salary_or_compensation_details, additional_information_about_employment, station_id, status_id, permission_id;

    public DomesticWorkers(String domestic_id, String user_id, String full_name_of_domestic_help, String gender, String date_of_birth, String permanent_address, String contact_number, String email_address, String name_of_previous_employer, String duration_of_employment, String reason_for_leaving, String identification_documents_submitted, String identity_proof_doc_number, String identity_proof_issuing_authority, String identity_proof_date_of_issue, String identity_proof_date_of_expiry, String address_proof_doc_number, String address_proof_issuing_authority, String address_proof_date_of_issue, String purpose_of_employment, String job_title_or_role, String start_date_of_employment, String salary_or_compensation_details, String additional_information_about_employment, String station_id, String status_id, String permission_id) {
        this.domestic_id = domestic_id;
        this.user_id = user_id;
        this.full_name_of_domestic_help = full_name_of_domestic_help;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.permanent_address = permanent_address;
        this.contact_number = contact_number;
        this.email_address = email_address;
        this.name_of_previous_employer = name_of_previous_employer;
        this.duration_of_employment = duration_of_employment;
        this.reason_for_leaving = reason_for_leaving;
        this.identification_documents_submitted = identification_documents_submitted;
        this.identity_proof_doc_number = identity_proof_doc_number;
        this.identity_proof_issuing_authority = identity_proof_issuing_authority;
        this.identity_proof_date_of_issue = identity_proof_date_of_issue;
        this.identity_proof_date_of_expiry = identity_proof_date_of_expiry;
        this.address_proof_doc_number = address_proof_doc_number;
        this.address_proof_issuing_authority = address_proof_issuing_authority;
        this.address_proof_date_of_issue = address_proof_date_of_issue;
        this.purpose_of_employment = purpose_of_employment;
        this.job_title_or_role = job_title_or_role;
        this.start_date_of_employment = start_date_of_employment;
        this.salary_or_compensation_details = salary_or_compensation_details;
        this.additional_information_about_employment = additional_information_about_employment;
        this.station_id = station_id;
        this.status_id = status_id;
        this.permission_id = permission_id;
    }

    public String getDomestic_id() {
        return domestic_id;
    }

    public void setDomestic_id(String domestic_id) {
        this.domestic_id = domestic_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFull_name_of_domestic_help() {
        return full_name_of_domestic_help;
    }

    public void setFull_name_of_domestic_help(String full_name_of_domestic_help) {
        this.full_name_of_domestic_help = full_name_of_domestic_help;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getName_of_previous_employer() {
        return name_of_previous_employer;
    }

    public void setName_of_previous_employer(String name_of_previous_employer) {
        this.name_of_previous_employer = name_of_previous_employer;
    }

    public String getDuration_of_employment() {
        return duration_of_employment;
    }

    public void setDuration_of_employment(String duration_of_employment) {
        this.duration_of_employment = duration_of_employment;
    }

    public String getReason_for_leaving() {
        return reason_for_leaving;
    }

    public void setReason_for_leaving(String reason_for_leaving) {
        this.reason_for_leaving = reason_for_leaving;
    }

    public String getIdentification_documents_submitted() {
        return identification_documents_submitted;
    }

    public void setIdentification_documents_submitted(String identification_documents_submitted) {
        this.identification_documents_submitted = identification_documents_submitted;
    }

    public String getIdentity_proof_doc_number() {
        return identity_proof_doc_number;
    }

    public void setIdentity_proof_doc_number(String identity_proof_doc_number) {
        this.identity_proof_doc_number = identity_proof_doc_number;
    }

    public String getIdentity_proof_issuing_authority() {
        return identity_proof_issuing_authority;
    }

    public void setIdentity_proof_issuing_authority(String identity_proof_issuing_authority) {
        this.identity_proof_issuing_authority = identity_proof_issuing_authority;
    }

    public String getIdentity_proof_date_of_issue() {
        return identity_proof_date_of_issue;
    }

    public void setIdentity_proof_date_of_issue(String identity_proof_date_of_issue) {
        this.identity_proof_date_of_issue = identity_proof_date_of_issue;
    }

    public String getIdentity_proof_date_of_expiry() {
        return identity_proof_date_of_expiry;
    }

    public void setIdentity_proof_date_of_expiry(String identity_proof_date_of_expiry) {
        this.identity_proof_date_of_expiry = identity_proof_date_of_expiry;
    }

    public String getAddress_proof_doc_number() {
        return address_proof_doc_number;
    }

    public void setAddress_proof_doc_number(String address_proof_doc_number) {
        this.address_proof_doc_number = address_proof_doc_number;
    }

    public String getAddress_proof_issuing_authority() {
        return address_proof_issuing_authority;
    }

    public void setAddress_proof_issuing_authority(String address_proof_issuing_authority) {
        this.address_proof_issuing_authority = address_proof_issuing_authority;
    }

    public String getAddress_proof_date_of_issue() {
        return address_proof_date_of_issue;
    }

    public void setAddress_proof_date_of_issue(String address_proof_date_of_issue) {
        this.address_proof_date_of_issue = address_proof_date_of_issue;
    }

    public String getPurpose_of_employment() {
        return purpose_of_employment;
    }

    public void setPurpose_of_employment(String purpose_of_employment) {
        this.purpose_of_employment = purpose_of_employment;
    }

    public String getJob_title_or_role() {
        return job_title_or_role;
    }

    public void setJob_title_or_role(String job_title_or_role) {
        this.job_title_or_role = job_title_or_role;
    }

    public String getStart_date_of_employment() {
        return start_date_of_employment;
    }

    public void setStart_date_of_employment(String start_date_of_employment) {
        this.start_date_of_employment = start_date_of_employment;
    }

    public String getSalary_or_compensation_details() {
        return salary_or_compensation_details;
    }

    public void setSalary_or_compensation_details(String salary_or_compensation_details) {
        this.salary_or_compensation_details = salary_or_compensation_details;
    }

    public String getAdditional_information_about_employment() {
        return additional_information_about_employment;
    }

    public void setAdditional_information_about_employment(String additional_information_about_employment) {
        this.additional_information_about_employment = additional_information_about_employment;
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

    public String getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(String permission_id) {
        this.permission_id = permission_id;
    }
}
