package com.ltrsoft.police_mannagement_system.Model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PoliceInfo implements Serializable {
    @SerializedName("police_id")
    private String police_id;

    @SerializedName("batch_no")
    private String batch_no;

    @SerializedName("police_fname")
    private String police_fname;

    @SerializedName("police_mname")
    private String police_mname;

    @SerializedName("police_lname")
    private String police_lname;

    @SerializedName("police_email")
    private String police_email;

    @SerializedName("police_password")
    private String police_password;

    @SerializedName("gender")
    private String gender;

    @SerializedName("DOB")
    private String DOB;

    @SerializedName("police_mobile1")
    private String police_mobile1;

    @SerializedName("police_mobile2")
    private String police_mobile2;

    @SerializedName("police_photo")
    private String police_photo;

    @SerializedName("police_address")
    private String police_address;

    @SerializedName("country_id")
    private String country_id;

    @SerializedName("state_id")
    private String state_id;

    @SerializedName("district_id")
    private String district_id;

    @SerializedName("city_id")
    private String city_id;

    @SerializedName("position_id")
    private String position_id;

    @SerializedName("police_adhar")
    private String police_adhar;

    @SerializedName("police_age")
    private String police_age;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    public PoliceInfo(String police_id, String batch_no, String police_fname, String police_mname, String police_lname, String police_email, String police_password, String gender, String DOB, String police_mobile1, String police_mobile2, String police_photo, String police_address, String country_id, String state_id, String district_id, String city_id, String position_id, String police_adhar, String police_age, String created_at, String updated_at) {
        this.police_id = police_id;
        this.batch_no = batch_no;
        this.police_fname = police_fname;
        this.police_mname = police_mname;
        this.police_lname = police_lname;
        this.police_email = police_email;
        this.police_password = police_password;
        this.gender = gender;
        this.DOB = DOB;
        this.police_mobile1 = police_mobile1;
        this.police_mobile2 = police_mobile2;
        this.police_photo = police_photo;
        this.police_address = police_address;
        this.country_id = country_id;
        this.state_id = state_id;
        this.district_id = district_id;
        this.city_id = city_id;
        this.position_id = position_id;
        this.police_adhar = police_adhar;
        this.police_age = police_age;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getPolice_fname() {
        return police_fname;
    }

    public void setPolice_fname(String police_fname) {
        this.police_fname = police_fname;
    }

    public String getPolice_mname() {
        return police_mname;
    }

    public void setPolice_mname(String police_mname) {
        this.police_mname = police_mname;
    }

    public String getPolice_lname() {
        return police_lname;
    }

    public void setPolice_lname(String police_lname) {
        this.police_lname = police_lname;
    }

    public String getPolice_email() {
        return police_email;
    }

    public void setPolice_email(String police_email) {
        this.police_email = police_email;
    }

    public String getPolice_password() {
        return police_password;
    }

    public void setPolice_password(String police_password) {
        this.police_password = police_password;
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

    public String getPolice_mobile1() {
        return police_mobile1;
    }

    public void setPolice_mobile1(String police_mobile1) {
        this.police_mobile1 = police_mobile1;
    }

    public String getPolice_mobile2() {
        return police_mobile2;
    }

    public void setPolice_mobile2(String police_mobile2) {
        this.police_mobile2 = police_mobile2;
    }

    public String getPolice_photo() {
        return police_photo;
    }

    public void setPolice_photo(String police_photo) {
        this.police_photo = police_photo;
    }

    public String getPolice_address() {
        return police_address;
    }

    public void setPolice_address(String police_address) {
        this.police_address = police_address;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getPolice_adhar() {
        return police_adhar;
    }

    public void setPolice_adhar(String police_adhar) {
        this.police_adhar = police_adhar;
    }

    public String getPolice_age() {
        return police_age;
    }

    public void setPolice_age(String police_age) {
        this.police_age = police_age;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
