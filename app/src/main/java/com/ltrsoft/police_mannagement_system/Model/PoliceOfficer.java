package com.ltrsoft.police_mannagement_system.Model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.time.LocalDate;

public class PoliceOfficer implements Serializable {
    @SerializedName("police_id")
    private String policeId;
    @SerializedName("batch_no")
    private String batchNo;
    @SerializedName("police_fname")
    private String policeFname;
    @SerializedName("police_mname")
    private String policeMname;
    @SerializedName("police_lname")
    private String policeLname;
    @SerializedName("police_email")
    private String policeEmail;
    @SerializedName("police_password")
    private String policePassword;
    private String gender;
    private String DOB;
    @SerializedName("police_mobile1")
    private String policeMobile1;
    @SerializedName("police_mobile2")
    private String policeMobile2;
    @SerializedName("police_photo")
    private String policePhoto;
    @SerializedName("police_address")
    private String policeAddress;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("state_id")
    private String stateId;
    @SerializedName("district_id")
    private String districtId;
    @SerializedName("city_id")
    private String cityId;
    @SerializedName("position_id")
    private String positionId;
    @SerializedName("police_adhar")
    private String policeAdhar;
    @SerializedName("police_age")
    private String policeAge;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("position_name")
    private String positionName;
    @SerializedName("police_station_id")
    private String policeStationId;
    @SerializedName("police_station_name")
    private String policeStationName;
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
    private String other;
    @SerializedName("registration_date")
    private String registrationDate;
    @SerializedName("registration_officer")
    private String registrationOfficer;
    @SerializedName("additional_information")
    private String additionalInformation;
    private String acknowledgment;
    private String latitude;
    private String longitude;

    public PoliceOfficer(String policeId, String batchNo, String policeFname, String policeMname, String policeLname, String policeEmail, String policePassword, String gender, String DOB, String policeMobile1, String policeMobile2, String policePhoto, String policeAddress, String countryId, String stateId, String districtId, String cityId, String positionId, String policeAdhar, String policeAge, String createdAt, String updatedAt, String positionName, String policeStationId, String policeStationName, String stationAddress, String stationCode, String postalCode, String phoneNumber, String faxNumber, String emailAddress, String detentionCells, String interrogationRooms, String evidenceStorage, String vehicleParking, String conferenceMeetingRoom, String operation247, String narcoticsDivision, String cybercrimeUnit, String trafficEnforcement, String k9Unit, String swatTeam, String other, String registrationDate, String registrationOfficer, String additionalInformation, String acknowledgment, String latitude, String longitude) {
        this.policeId = policeId;
        this.batchNo = batchNo;
        this.policeFname = policeFname;
        this.policeMname = policeMname;
        this.policeLname = policeLname;
        this.policeEmail = policeEmail;
        this.policePassword = policePassword;
        this.gender = gender;
        this.DOB = DOB;
        this.policeMobile1 = policeMobile1;
        this.policeMobile2 = policeMobile2;
        this.policePhoto = policePhoto;
        this.policeAddress = policeAddress;
        this.countryId = countryId;
        this.stateId = stateId;
        this.districtId = districtId;
        this.cityId = cityId;
        this.positionId = positionId;
        this.policeAdhar = policeAdhar;
        this.policeAge = policeAge;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.positionName = positionName;
        this.policeStationId = policeStationId;
        this.policeStationName = policeStationName;
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

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPoliceFname() {
        return policeFname;
    }

    public void setPoliceFname(String policeFname) {
        this.policeFname = policeFname;
    }

    public String getPoliceMname() {
        return policeMname;
    }

    public void setPoliceMname(String policeMname) {
        this.policeMname = policeMname;
    }

    public String getPoliceLname() {
        return policeLname;
    }

    public void setPoliceLname(String policeLname) {
        this.policeLname = policeLname;
    }

    public String getPoliceEmail() {
        return policeEmail;
    }

    public void setPoliceEmail(String policeEmail) {
        this.policeEmail = policeEmail;
    }

    public String getPolicePassword() {
        return policePassword;
    }

    public void setPolicePassword(String policePassword) {
        this.policePassword = policePassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPoliceMobile1() {
        return policeMobile1;
    }

    public void setPoliceMobile1(String policeMobile1) {
        this.policeMobile1 = policeMobile1;
    }

    public String getPoliceMobile2() {
        return policeMobile2;
    }

    public void setPoliceMobile2(String policeMobile2) {
        this.policeMobile2 = policeMobile2;
    }

    public String getPolicePhoto() {
        return policePhoto;
    }

    public void setPolicePhoto(String policePhoto) {
        this.policePhoto = policePhoto;
    }

    public String getPoliceAddress() {
        return policeAddress;
    }

    public void setPoliceAddress(String policeAddress) {
        this.policeAddress = policeAddress;
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

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPoliceAdhar() {
        return policeAdhar;
    }

    public void setPoliceAdhar(String policeAdhar) {
        this.policeAdhar = policeAdhar;
    }

    public String getPoliceAge() {
        return policeAge;
    }

    public void setPoliceAge(String policeAge) {
        this.policeAge = policeAge;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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
}