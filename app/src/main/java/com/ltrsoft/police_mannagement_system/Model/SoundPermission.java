package com.ltrsoft.police_mannagement_system.Model;
import android.os.Parcel;
import android.os.Parcelable;

public class SoundPermission implements Parcelable {
    private String sound_permission_id, event_name, purpose, no_of_speaker, position_in_event, date, from_time, to_time, location, village, state, district, country, user_id, station_id, time_of_initiation, closing_time, speaker_contractor_name, contractor_address, license_no, fees, terms_condition, permission_id;

//    public SoundPermission() {
//        // Empty constructor
//    }

//    protected SoundPermission(Parcel in) {
//        sound_permission_id = in.readString();
//        event_name = in.readString();
//        purpose = in.readString();
//        no_of_speaker = in.readString();
//        position_in_event = in.readString();
//        date = in.readString();
//        from_time = in.readString();
//        to_time = in.readString();
//        location = in.readString();
//        village = in.readString();
//        state = in.readString();
//        district = in.readString();
//        country = in.readString();
//        user_id = in.readString();
//        station_id = in.readString();
//        time_of_initiation = in.readString();
//        closing_time = in.readString();
//        speaker_contractor_name = in.readString();
//        contractor_address = in.readString();
//        license_no = in.readString();
//        fees = in.readString();
//        terms_condition = in.readString();
//        permission_id = in.readString();
//    }

    public SoundPermission(String sound_permission_id, String event_name, String purpose, String no_of_speaker, String position_in_event, String date, String from_time, String to_time, String location, String village, String state, String district, String country, String user_id, String station_id, String time_of_initiation, String closing_time, String speaker_contractor_name, String contractor_address, String license_no, String fees, String terms_condition, String permission_id) {
        this.sound_permission_id = sound_permission_id;
        this.event_name = event_name;
        this.purpose = purpose;
        this.no_of_speaker = no_of_speaker;
        this.position_in_event = position_in_event;
        this.date = date;
        this.from_time = from_time;
        this.to_time = to_time;
        this.location = location;
        this.village = village;
        this.state = state;
        this.district = district;
        this.country = country;
        this.user_id = user_id;
        this.station_id = station_id;
        this.time_of_initiation = time_of_initiation;
        this.closing_time = closing_time;
        this.speaker_contractor_name = speaker_contractor_name;
        this.contractor_address = contractor_address;
        this.license_no = license_no;
        this.fees = fees;
        this.terms_condition = terms_condition;
        this.permission_id = permission_id;
    }

    public static final Creator<SoundPermission> CREATOR = new Creator<SoundPermission>() {
        @Override
        public SoundPermission createFromParcel(Parcel in) {
//            return new SoundPermission(in);
            return null;
        }

        @Override
        public SoundPermission[] newArray(int size) {
            return new SoundPermission[size];
        }
    };

    public String getSound_permission_id() {
        return sound_permission_id;
    }

    public void setSound_permission_id(String sound_permission_id) {
        this.sound_permission_id = sound_permission_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getNo_of_speaker() {
        return no_of_speaker;
    }

    public void setNo_of_speaker(String no_of_speaker) {
        this.no_of_speaker = no_of_speaker;
    }

    public String getPosition_in_event() {
        return position_in_event;
    }

    public void setPosition_in_event(String position_in_event) {
        this.position_in_event = position_in_event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom_time() {
        return from_time;
    }

    public void setFrom_time(String from_time) {
        this.from_time = from_time;
    }

    public String getTo_time() {
        return to_time;
    }

    public void setTo_time(String to_time) {
        this.to_time = to_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getTime_of_initiation() {
        return time_of_initiation;
    }

    public void setTime_of_initiation(String time_of_initiation) {
        this.time_of_initiation = time_of_initiation;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public String getSpeaker_contractor_name() {
        return speaker_contractor_name;
    }

    public void setSpeaker_contractor_name(String speaker_contractor_name) {
        this.speaker_contractor_name = speaker_contractor_name;
    }

    public String getContractor_address() {
        return contractor_address;
    }

    public void setContractor_address(String contractor_address) {
        this.contractor_address = contractor_address;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getTerms_condition() {
        return terms_condition;
    }

    public void setTerms_condition(String terms_condition) {
        this.terms_condition = terms_condition;
    }

    public String getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(String permission_id) {
        this.permission_id = permission_id;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    // Add other getters and setters...

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sound_permission_id);
        dest.writeString(event_name);
        dest.writeString(purpose);
        dest.writeString(no_of_speaker);
        dest.writeString(position_in_event);
        dest.writeString(date);
        dest.writeString(from_time);
        dest.writeString(to_time);
        dest.writeString(location);
        dest.writeString(village);
        dest.writeString(state);
        dest.writeString(district);
        dest.writeString(country);
        dest.writeString(user_id);
        dest.writeString(station_id);
        dest.writeString(time_of_initiation);
        dest.writeString(closing_time);
        dest.writeString(speaker_contractor_name);
        dest.writeString(contractor_address);
        dest.writeString(license_no);
        dest.writeString(fees);
        dest.writeString(terms_condition);
        dest.writeString(permission_id);
    }
}
