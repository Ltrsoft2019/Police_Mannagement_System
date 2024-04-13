package com.ltrsoft.police_mannagement_system.Model;

import com.google.gson.annotations.SerializedName;

public class Criminal {
    @SerializedName("criminal_id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("date_of_birth")
    private String dateOfBirth;

    @SerializedName("gender")
    private String gender;

    @SerializedName("race_ethnicity")
    private String raceEthnicity;

    @SerializedName("social_security_number")
    private String socialSecurityNumber;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    @SerializedName("eye_color")
    private String eyeColor;

    @SerializedName("hair_color")
    private String hairColor;

    @SerializedName("identifying_features")
    private String identifyingFeatures;

    @SerializedName("home_address")
    private String homeAddress;

    @SerializedName("phone_numbers")
    private String phoneNumbers;

    @SerializedName("email_address")
    private String emailAddress;

    @SerializedName("occupation")
    private String occupation;

    @SerializedName("education_level")
    private String educationLevel;

    @SerializedName("station_id")
    private String stationId;

    public Criminal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRaceEthnicity() {
        return raceEthnicity;
    }

    public void setRaceEthnicity(String raceEthnicity) {
        this.raceEthnicity = raceEthnicity;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
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

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getIdentifyingFeatures() {
        return identifyingFeatures;
    }

    public void setIdentifyingFeatures(String identifyingFeatures) {
        this.identifyingFeatures = identifyingFeatures;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public Criminal(String id, String fullName, String dateOfBirth, String gender, String raceEthnicity, String socialSecurityNumber, String height, String weight, String eyeColor, String hairColor, String identifyingFeatures, String homeAddress, String phoneNumbers, String emailAddress, String occupation, String educationLevel, String stationId) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.raceEthnicity = raceEthnicity;
        this.socialSecurityNumber = socialSecurityNumber;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.identifyingFeatures = identifyingFeatures;
        this.homeAddress = homeAddress;
        this.phoneNumbers = phoneNumbers;
        this.emailAddress = emailAddress;
        this.occupation = occupation;
        this.educationLevel = educationLevel;
        this.stationId = stationId;
    }
}
