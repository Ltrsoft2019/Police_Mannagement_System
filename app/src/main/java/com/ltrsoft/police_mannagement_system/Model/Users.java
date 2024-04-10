package com.ltrsoft.police_mannagement_system.Model;

public class Users {
    private String user_id,user_fname,user_mname,user_lname,user_address,user_photo,country_id,
            state_id,district_id,city_id,user_email,password,gender,user_dob,user_mobile1,user_mobile2,
            user_adhar,user_pan,occupation,nationality,driving_licence,notification_token,latitude,
            longitude,station_id;

    public Users(String user_id, String user_fname, String user_mname, String user_lname, String user_address, String user_photo, String country_id, String state_id, String district_id, String city_id, String user_email, String password, String gender, String user_dob, String user_mobile1, String user_mobile2, String user_adhar, String user_pan, String occupation, String nationality, String driving_licence, String notification_token, String latitude, String longitude, String station_id) {
        this.user_id = user_id;
        this.user_fname = user_fname;
        this.user_mname = user_mname;
        this.user_lname = user_lname;
        this.user_address = user_address;
        this.user_photo = user_photo;
        this.country_id = country_id;
        this.state_id = state_id;
        this.district_id = district_id;
        this.city_id = city_id;
        this.user_email = user_email;
        this.password = password;
        this.gender = gender;
        this.user_dob = user_dob;
        this.user_mobile1 = user_mobile1;
        this.user_mobile2 = user_mobile2;
        this.user_adhar = user_adhar;
        this.user_pan = user_pan;
        this.occupation = occupation;
        this.nationality = nationality;
        this.driving_licence = driving_licence;
        this.notification_token = notification_token;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station_id = station_id;
    }

//    public Users() {
//    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getUser_mname() {
        return user_mname;
    }

    public void setUser_mname(String user_mname) {
        this.user_mname = user_mname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getUser_mobile1() {
        return user_mobile1;
    }

    public void setUser_mobile1(String user_mobile1) {
        this.user_mobile1 = user_mobile1;
    }

    public String getUser_mobile2() {
        return user_mobile2;
    }

    public void setUser_mobile2(String user_mobile2) {
        this.user_mobile2 = user_mobile2;
    }

    public String getUser_adhar() {
        return user_adhar;
    }

    public void setUser_adhar(String user_adhar) {
        this.user_adhar = user_adhar;
    }

    public String getUser_pan() {
        return user_pan;
    }

    public void setUser_pan(String user_pan) {
        this.user_pan = user_pan;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDriving_licence() {
        return driving_licence;
    }

    public void setDriving_licence(String driving_licence) {
        this.driving_licence = driving_licence;
    }

    public String getNotification_token() {
        return notification_token;
    }

    public void setNotification_token(String notification_token) {
        this.notification_token = notification_token;
    }


    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }



    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
