package com.ltrsoft.police_mannagement_system.Model;
import android.os.Parcel;
import android.os.Parcelable;

public class CharacterCertificate implements Parcelable {

    private String character_certificate_id, user_id, station_id, pbuilding, pstreet, plandmark, plocality, pstate_id, pdistrict_id, pincode, cbuilding, cstreet, clandmark, clocality, cstate_id, cdistrict_id, cpincode, visible_mark, have_arrested, active_politics, is_criminal, status_id, permission_id;

    public CharacterCertificate(String character_certificate_id, String user_id, String station_id, String pbuilding, String pstreet, String plandmark, String plocality, String pstate_id, String pdistrict_id, String pincode, String cbuilding, String cstreet, String clandmark, String clocality, String cstate_id, String cdistrict_id, String cpincode, String visible_mark, String have_arrested, String active_politics, String is_criminal, String status_id, String permission_id) {
        this.character_certificate_id = character_certificate_id;
        this.user_id = user_id;
        this.station_id = station_id;
        this.pbuilding = pbuilding;
        this.pstreet = pstreet;
        this.plandmark = plandmark;
        this.plocality = plocality;
        this.pstate_id = pstate_id;
        this.pdistrict_id = pdistrict_id;
        this.pincode = pincode;
        this.cbuilding = cbuilding;
        this.cstreet = cstreet;
        this.clandmark = clandmark;
        this.clocality = clocality;
        this.cstate_id = cstate_id;
        this.cdistrict_id = cdistrict_id;
        this.cpincode = cpincode;
        this.visible_mark = visible_mark;
        this.have_arrested = have_arrested;
        this.active_politics = active_politics;
        this.is_criminal = is_criminal;
        this.status_id = status_id;
        this.permission_id = permission_id;
    }

    protected CharacterCertificate(Parcel in) {
        character_certificate_id = in.readString();
        user_id = in.readString();
        station_id = in.readString();
        pbuilding = in.readString();
        pstreet = in.readString();
        plandmark = in.readString();
        plocality = in.readString();
        pstate_id = in.readString();
        pdistrict_id = in.readString();
        pincode = in.readString();
        cbuilding = in.readString();
        cstreet = in.readString();
        clandmark = in.readString();
        clocality = in.readString();
        cstate_id = in.readString();
        cdistrict_id = in.readString();
        cpincode = in.readString();
        visible_mark = in.readString();
        have_arrested = in.readString();
        active_politics = in.readString();
        is_criminal = in.readString();
        status_id = in.readString();
        permission_id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(character_certificate_id);
        dest.writeString(user_id);
        dest.writeString(station_id);
        dest.writeString(pbuilding);
        dest.writeString(pstreet);
        dest.writeString(plandmark);
        dest.writeString(plocality);
        dest.writeString(pstate_id);
        dest.writeString(pdistrict_id);
        dest.writeString(pincode);
        dest.writeString(cbuilding);
        dest.writeString(cstreet);
        dest.writeString(clandmark);
        dest.writeString(clocality);
        dest.writeString(cstate_id);
        dest.writeString(cdistrict_id);
        dest.writeString(cpincode);
        dest.writeString(visible_mark);
        dest.writeString(have_arrested);
        dest.writeString(active_politics);
        dest.writeString(is_criminal);
        dest.writeString(status_id);
        dest.writeString(permission_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CharacterCertificate> CREATOR = new Creator<CharacterCertificate>() {
        @Override
        public CharacterCertificate createFromParcel(Parcel in) {
            return new CharacterCertificate(in);
        }

        @Override
        public CharacterCertificate[] newArray(int size) {
            return new CharacterCertificate[size];
        }
    };

    public String getCharacter_certificate_id() {
        return character_certificate_id;
    }

    public void setCharacter_certificate_id(String character_certificate_id) {
        this.character_certificate_id = character_certificate_id;
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

    public String getPbuilding() {
        return pbuilding;
    }

    public void setPbuilding(String pbuilding) {
        this.pbuilding = pbuilding;
    }

    public String getPstreet() {
        return pstreet;
    }

    public void setPstreet(String pstreet) {
        this.pstreet = pstreet;
    }

    public String getPlandmark() {
        return plandmark;
    }

    public void setPlandmark(String plandmark) {
        this.plandmark = plandmark;
    }

    public String getPlocality() {
        return plocality;
    }

    public void setPlocality(String plocality) {
        this.plocality = plocality;
    }

    public String getPstate_id() {
        return pstate_id;
    }

    public void setPstate_id(String pstate_id) {
        this.pstate_id = pstate_id;
    }

    public String getPdistrict_id() {
        return pdistrict_id;
    }

    public void setPdistrict_id(String pdistrict_id) {
        this.pdistrict_id = pdistrict_id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCbuilding() {
        return cbuilding;
    }

    public void setCbuilding(String cbuilding) {
        this.cbuilding = cbuilding;
    }

    public String getCstreet() {
        return cstreet;
    }

    public void setCstreet(String cstreet) {
        this.cstreet = cstreet;
    }

    public String getClandmark() {
        return clandmark;
    }

    public void setClandmark(String clandmark) {
        this.clandmark = clandmark;
    }

    public String getClocality() {
        return clocality;
    }

    public void setClocality(String clocality) {
        this.clocality = clocality;
    }

    public String getCstate_id() {
        return cstate_id;
    }

    public void setCstate_id(String cstate_id) {
        this.cstate_id = cstate_id;
    }

    public String getCdistrict_id() {
        return cdistrict_id;
    }

    public void setCdistrict_id(String cdistrict_id) {
        this.cdistrict_id = cdistrict_id;
    }

    public String getCpincode() {
        return cpincode;
    }

    public void setCpincode(String cpincode) {
        this.cpincode = cpincode;
    }

    public String getVisible_mark() {
        return visible_mark;
    }

    public void setVisible_mark(String visible_mark) {
        this.visible_mark = visible_mark;
    }

    public String getHave_arrested() {
        return have_arrested;
    }

    public void setHave_arrested(String have_arrested) {
        this.have_arrested = have_arrested;
    }

    public String getActive_politics() {
        return active_politics;
    }

    public void setActive_politics(String active_politics) {
        this.active_politics = active_politics;
    }

    public String getIs_criminal() {
        return is_criminal;
    }

    public void setIs_criminal(String is_criminal) {
        this.is_criminal = is_criminal;
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
// Getters and Setters
}
