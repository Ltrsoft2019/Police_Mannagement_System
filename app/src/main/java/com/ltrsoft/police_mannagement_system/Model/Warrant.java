package com.ltrsoft.police_mannagement_system.Model;
import com.google.gson.annotations.SerializedName;
    public class Warrant {
        @SerializedName("warrant_id")
        private String warrantId;

        @SerializedName("warrant_number")
        private String warrantNumber;

        @SerializedName("issuing_agency_or_court")
        private String issuingAgencyOrCourt;

        @SerializedName("date_of_issue")
        private String dateOfIssue;

        @SerializedName("type_of_warrant")
        private String typeOfWarrant;

        private String description;

        @SerializedName("full_name_of_individual")
        private String fullNameOfIndividual;

        @SerializedName("date_of_birth")
        private String dateOfBirth;

        private String gender;

        @SerializedName("race_ethnicity")
        private String raceEthnicity;

        @SerializedName("physical_description")
        private String physicalDescription;

        @SerializedName("identifying_features")
        private String identifyingFeatures;

        @SerializedName("offense_description")
        private String offenseDescription;

        @SerializedName("date_and_location_of_offense")
        private String dateAndLocationOfOffense;

        @SerializedName("offense_severity")
        private String offenseSeverity;

        @SerializedName("judge_or_magistrate_name_and_title")
        private String judgeOrMagistrateNameAndTitle;

        @SerializedName("issuing_agency_or_court_contact_info")
        private String issuingAgencyOrCourtContactInfo;

        @SerializedName("warrant_status")
        private String warrantStatus;

        @SerializedName("warrant_conditions")
        private String warrantConditions;

        private String notes;

        @SerializedName("previous_warrants_history")
        private String previousWarrantsHistory;

        @SerializedName("related_cases")
        private String relatedCases;

        @SerializedName("evidance_description")
        private String evidenceDescription;

        @SerializedName("station_id")
        private String stationId;

        @SerializedName("created_at")
        private String createdAt;

        @SerializedName("updated_at")
        private String updatedAt;

        public Warrant(String warrantId, String warrantNumber, String issuingAgencyOrCourt, String dateOfIssue, String typeOfWarrant, String description, String fullNameOfIndividual, String dateOfBirth, String gender, String raceEthnicity, String physicalDescription, String identifyingFeatures, String offenseDescription, String dateAndLocationOfOffense, String offenseSeverity, String judgeOrMagistrateNameAndTitle, String issuingAgencyOrCourtContactInfo, String warrantStatus, String warrantConditions, String notes, String previousWarrantsHistory, String relatedCases, String evidenceDescription, String stationId, String createdAt, String updatedAt) {
            this.warrantId = warrantId;
            this.warrantNumber = warrantNumber;
            this.issuingAgencyOrCourt = issuingAgencyOrCourt;
            this.dateOfIssue = dateOfIssue;
            this.typeOfWarrant = typeOfWarrant;
            this.description = description;
            this.fullNameOfIndividual = fullNameOfIndividual;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
            this.raceEthnicity = raceEthnicity;
            this.physicalDescription = physicalDescription;
            this.identifyingFeatures = identifyingFeatures;
            this.offenseDescription = offenseDescription;
            this.dateAndLocationOfOffense = dateAndLocationOfOffense;
            this.offenseSeverity = offenseSeverity;
            this.judgeOrMagistrateNameAndTitle = judgeOrMagistrateNameAndTitle;
            this.issuingAgencyOrCourtContactInfo = issuingAgencyOrCourtContactInfo;
            this.warrantStatus = warrantStatus;
            this.warrantConditions = warrantConditions;
            this.notes = notes;
            this.previousWarrantsHistory = previousWarrantsHistory;
            this.relatedCases = relatedCases;
            this.evidenceDescription = evidenceDescription;
            this.stationId = stationId;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public String getWarrantId() {
            return warrantId;
        }

        public void setWarrantId(String warrantId) {
            this.warrantId = warrantId;
        }

        public String getWarrantNumber() {
            return warrantNumber;
        }

        public void setWarrantNumber(String warrantNumber) {
            this.warrantNumber = warrantNumber;
        }

        public String getIssuingAgencyOrCourt() {
            return issuingAgencyOrCourt;
        }

        public void setIssuingAgencyOrCourt(String issuingAgencyOrCourt) {
            this.issuingAgencyOrCourt = issuingAgencyOrCourt;
        }

        public String getDateOfIssue() {
            return dateOfIssue;
        }

        public void setDateOfIssue(String dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
        }

        public String getTypeOfWarrant() {
            return typeOfWarrant;
        }

        public void setTypeOfWarrant(String typeOfWarrant) {
            this.typeOfWarrant = typeOfWarrant;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFullNameOfIndividual() {
            return fullNameOfIndividual;
        }

        public void setFullNameOfIndividual(String fullNameOfIndividual) {
            this.fullNameOfIndividual = fullNameOfIndividual;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getRaceEthnicity() {
            return raceEthnicity;
        }

        public void setRaceEthnicity(String raceEthnicity) {
            this.raceEthnicity = raceEthnicity;
        }

        public String getPhysicalDescription() {
            return physicalDescription;
        }

        public void setPhysicalDescription(String physicalDescription) {
            this.physicalDescription = physicalDescription;
        }

        public String getIdentifyingFeatures() {
            return identifyingFeatures;
        }

        public void setIdentifyingFeatures(String identifyingFeatures) {
            this.identifyingFeatures = identifyingFeatures;
        }

        public String getOffenseDescription() {
            return offenseDescription;
        }

        public void setOffenseDescription(String offenseDescription) {
            this.offenseDescription = offenseDescription;
        }

        public String getDateAndLocationOfOffense() {
            return dateAndLocationOfOffense;
        }

        public void setDateAndLocationOfOffense(String dateAndLocationOfOffense) {
            this.dateAndLocationOfOffense = dateAndLocationOfOffense;
        }

        public String getOffenseSeverity() {
            return offenseSeverity;
        }

        public void setOffenseSeverity(String offenseSeverity) {
            this.offenseSeverity = offenseSeverity;
        }

        public String getJudgeOrMagistrateNameAndTitle() {
            return judgeOrMagistrateNameAndTitle;
        }

        public void setJudgeOrMagistrateNameAndTitle(String judgeOrMagistrateNameAndTitle) {
            this.judgeOrMagistrateNameAndTitle = judgeOrMagistrateNameAndTitle;
        }

        public String getIssuingAgencyOrCourtContactInfo() {
            return issuingAgencyOrCourtContactInfo;
        }

        public void setIssuingAgencyOrCourtContactInfo(String issuingAgencyOrCourtContactInfo) {
            this.issuingAgencyOrCourtContactInfo = issuingAgencyOrCourtContactInfo;
        }

        public String getWarrantStatus() {
            return warrantStatus;
        }

        public void setWarrantStatus(String warrantStatus) {
            this.warrantStatus = warrantStatus;
        }

        public String getWarrantConditions() {
            return warrantConditions;
        }

        public void setWarrantConditions(String warrantConditions) {
            this.warrantConditions = warrantConditions;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getPreviousWarrantsHistory() {
            return previousWarrantsHistory;
        }

        public void setPreviousWarrantsHistory(String previousWarrantsHistory) {
            this.previousWarrantsHistory = previousWarrantsHistory;
        }

        public String getRelatedCases() {
            return relatedCases;
        }

        public void setRelatedCases(String relatedCases) {
            this.relatedCases = relatedCases;
        }

        public String getEvidenceDescription() {
            return evidenceDescription;
        }

        public void setEvidenceDescription(String evidenceDescription) {
            this.evidenceDescription = evidenceDescription;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
