package com.ltrsoft.police_mannagement_system.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SelfProblem implements Serializable {
    @SerializedName("self_problem_id")
    private String selfProblemId;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("date_of_birth")
    private String dateOfBirth;

    @SerializedName("gender")
    private String gender;

    @SerializedName("address")
    private String address;

    @SerializedName("contact_information")
    private String contactInformation;

    @SerializedName("identification_details")
    private String identificationDetails;

    @SerializedName("case_number")
    private String caseNumber;

    @SerializedName("date_of_declaration_as_proclaimed_offender")
    private String dateOfDeclarationAsProclaimedOffender;

    @SerializedName("court_name_and_jurisdiction")
    private String courtNameAndJurisdiction;

    @SerializedName("economic_offense_details")
    private String economicOffenseDetails;

    @SerializedName("status_of_legal_proceedings")
    private String statusOfLegalProceedings;

    @SerializedName("description_and_allegations")
    private String descriptionAndAllegations;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    @SerializedName("build")
    private String build;

    @SerializedName("hair_color")
    private String hairColor;

    @SerializedName("eye_color")
    private String eyeColor;

    @SerializedName("distinguishing_features")
    private String distinguishingFeatures;

    @SerializedName("previous_convictions")
    private String previousConvictions;

    @SerializedName("previous_offenses_details")
    private String previousOffensesDetails;

    @SerializedName("station_id")
    private String stationId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("police_station_id")
    private String policeStationId;

    @SerializedName("police_station_name")
    private String policeStationName;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("state_id")
    private String stateId;

    @SerializedName("district_id")
    private String districtId;

    @SerializedName("city_id")
    private String cityId;

    @SerializedName("station_address")
    private String stationAddress;

    @SerializedName("station_code")
    private String stationCode;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("fax_number")
    private String faxNumber;

    @SerializedName("email_address")
    private String emailAddress;

    @SerializedName("detention_cells")
    private String detentionCells;

    @SerializedName("interrogation_rooms")
    private String interrogationRooms;

    @SerializedName("evidence_storage")
    private String evidenceStorage;

    @SerializedName("vehicle_parking")
    private String vehicleParking;

    @SerializedName("conference_meeting_room")
    private String conferenceMeetingRoom;

    @SerializedName("operation_24_7")
    private String operation247;

    @SerializedName("narcotics_division")
    private String narcoticsDivision;

    @SerializedName("cybercrime_unit")
    private String cybercrimeUnit;

    @SerializedName("traffic_enforcement")
    private String trafficEnforcement;

    @SerializedName("k9_unit")
    private String k9Unit;

    @SerializedName("swat_team")
    private String swatTeam;

    @SerializedName("other")
    private String other;

    @SerializedName("registration_date")
    private String registrationDate;

    @SerializedName("registration_officer")
    private String registrationOfficer;

    @SerializedName("additional_information")
    private String additionalInformation;

    @SerializedName("acknowledgment")
    private String acknowledgment;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public SelfProblem(String selfProblemId, String fullName, String dateOfBirth, String gender, String address, String contactInformation, String identificationDetails, String caseNumber, String dateOfDeclarationAsProclaimedOffender, String courtNameAndJurisdiction, String economicOffenseDetails, String statusOfLegalProceedings, String descriptionAndAllegations, String height, String weight, String build, String hairColor, String eyeColor, String distinguishingFeatures, String previousConvictions, String previousOffensesDetails, String stationId, String createdAt, String updatedAt, String policeStationId, String policeStationName, String countryId, String stateId, String districtId, String cityId, String stationAddress, String stationCode, String postalCode, String phoneNumber, String faxNumber, String emailAddress, String detentionCells, String interrogationRooms, String evidenceStorage, String vehicleParking, String conferenceMeetingRoom, String operation247, String narcoticsDivision, String cybercrimeUnit, String trafficEnforcement, String k9Unit, String swatTeam, String other, String registrationDate, String registrationOfficer, String additionalInformation, String acknowledgment, String latitude, String longitude) {
        this.selfProblemId = selfProblemId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.contactInformation = contactInformation;
        this.identificationDetails = identificationDetails;
        this.caseNumber = caseNumber;
        this.dateOfDeclarationAsProclaimedOffender = dateOfDeclarationAsProclaimedOffender;
        this.courtNameAndJurisdiction = courtNameAndJurisdiction;
        this.economicOffenseDetails = economicOffenseDetails;
        this.statusOfLegalProceedings = statusOfLegalProceedings;
        this.descriptionAndAllegations = descriptionAndAllegations;
        this.height = height;
        this.weight = weight;
        this.build = build;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.distinguishingFeatures = distinguishingFeatures;
        this.previousConvictions = previousConvictions;
        this.previousOffensesDetails = previousOffensesDetails;
        this.stationId = stationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.policeStationId = policeStationId;
        this.policeStationName = policeStationName;
        this.countryId = countryId;
        this.stateId = stateId;
        this.districtId = districtId;
        this.cityId = cityId;
        this.stationAddress = stationAddress;
        this.stationCode = stationCode;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.detentionCells = detentionCells;
        this.interrogationRooms = interrogationRooms;
        this.evidenceStorage = evidenceStorage;
        this.vehicleParking = vehicleParking;
        this.conferenceMeetingRoom = conferenceMeetingRoom;
        this.operation247 = operation247;
        this.narcoticsDivision = narcoticsDivision;
        this.cybercrimeUnit = cybercrimeUnit;
        this.trafficEnforcement = trafficEnforcement;
        this.k9Unit = k9Unit;
        this.swatTeam = swatTeam;
        this.other = other;
        this.registrationDate = registrationDate;
        this.registrationOfficer = registrationOfficer;
        this.additionalInformation = additionalInformation;
        this.acknowledgment = acknowledgment;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSelfProblemId() {
        return selfProblemId;
    }

    public void setSelfProblemId(String selfProblemId) {
        this.selfProblemId = selfProblemId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getIdentificationDetails() {
        return identificationDetails;
    }

    public void setIdentificationDetails(String identificationDetails) {
        this.identificationDetails = identificationDetails;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDateOfDeclarationAsProclaimedOffender() {
        return dateOfDeclarationAsProclaimedOffender;
    }

    public void setDateOfDeclarationAsProclaimedOffender(String dateOfDeclarationAsProclaimedOffender) {
        this.dateOfDeclarationAsProclaimedOffender = dateOfDeclarationAsProclaimedOffender;
    }

    public String getCourtNameAndJurisdiction() {
        return courtNameAndJurisdiction;
    }

    public void setCourtNameAndJurisdiction(String courtNameAndJurisdiction) {
        this.courtNameAndJurisdiction = courtNameAndJurisdiction;
    }

    public String getEconomicOffenseDetails() {
        return economicOffenseDetails;
    }

    public void setEconomicOffenseDetails(String economicOffenseDetails) {
        this.economicOffenseDetails = economicOffenseDetails;
    }

    public String getStatusOfLegalProceedings() {
        return statusOfLegalProceedings;
    }

    public void setStatusOfLegalProceedings(String statusOfLegalProceedings) {
        this.statusOfLegalProceedings = statusOfLegalProceedings;
    }

    public String getDescriptionAndAllegations() {
        return descriptionAndAllegations;
    }

    public void setDescriptionAndAllegations(String descriptionAndAllegations) {
        this.descriptionAndAllegations = descriptionAndAllegations;
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

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getDistinguishingFeatures() {
        return distinguishingFeatures;
    }

    public void setDistinguishingFeatures(String distinguishingFeatures) {
        this.distinguishingFeatures = distinguishingFeatures;
    }

    public String getPreviousConvictions() {
        return previousConvictions;
    }

    public void setPreviousConvictions(String previousConvictions) {
        this.previousConvictions = previousConvictions;
    }

    public String getPreviousOffensesDetails() {
        return previousOffensesDetails;
    }

    public void setPreviousOffensesDetails(String previousOffensesDetails) {
        this.previousOffensesDetails = previousOffensesDetails;
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

    public String getPoliceStationId() {
        return policeStationId;
    }

    public void setPoliceStationId(String policeStationId) {
        this.policeStationId = policeStationId;
    }

    public String getPoliceStationName() {
        return policeStationName;
    }

    public void setPoliceStationName(String policeStationName) {
        this.policeStationName = policeStationName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDetentionCells() {
        return detentionCells;
    }

    public void setDetentionCells(String detentionCells) {
        this.detentionCells = detentionCells;
    }

    public String getInterrogationRooms() {
        return interrogationRooms;
    }

    public void setInterrogationRooms(String interrogationRooms) {
        this.interrogationRooms = interrogationRooms;
    }

    public String getEvidenceStorage() {
        return evidenceStorage;
    }

    public void setEvidenceStorage(String evidenceStorage) {
        this.evidenceStorage = evidenceStorage;
    }

    public String getVehicleParking() {
        return vehicleParking;
    }

    public void setVehicleParking(String vehicleParking) {
        this.vehicleParking = vehicleParking;
    }

    public String getConferenceMeetingRoom() {
        return conferenceMeetingRoom;
    }

    public void setConferenceMeetingRoom(String conferenceMeetingRoom) {
        this.conferenceMeetingRoom = conferenceMeetingRoom;
    }

    public String getOperation247() {
        return operation247;
    }

    public void setOperation247(String operation247) {
        this.operation247 = operation247;
    }

    public String getNarcoticsDivision() {
        return narcoticsDivision;
    }

    public void setNarcoticsDivision(String narcoticsDivision) {
        this.narcoticsDivision = narcoticsDivision;
    }

    public String getCybercrimeUnit() {
        return cybercrimeUnit;
    }

    public void setCybercrimeUnit(String cybercrimeUnit) {
        this.cybercrimeUnit = cybercrimeUnit;
    }

    public String getTrafficEnforcement() {
        return trafficEnforcement;
    }

    public void setTrafficEnforcement(String trafficEnforcement) {
        this.trafficEnforcement = trafficEnforcement;
    }

    public String getK9Unit() {
        return k9Unit;
    }

    public void setK9Unit(String k9Unit) {
        this.k9Unit = k9Unit;
    }

    public String getSwatTeam() {
        return swatTeam;
    }

    public void setSwatTeam(String swatTeam) {
        this.swatTeam = swatTeam;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationOfficer() {
        return registrationOfficer;
    }

    public void setRegistrationOfficer(String registrationOfficer) {
        this.registrationOfficer = registrationOfficer;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAcknowledgment() {
        return acknowledgment;
    }

    public void setAcknowledgment(String acknowledgment) {
        this.acknowledgment = acknowledgment;
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
// Constructor, getters, and setters omitted for brevity
}