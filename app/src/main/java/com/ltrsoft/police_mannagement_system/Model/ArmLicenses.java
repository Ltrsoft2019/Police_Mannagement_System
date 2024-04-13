package com.ltrsoft.police_mannagement_system.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ArmLicenses implements Parcelable {

    private String arm_license_id, parent_or_spouse_name, village, present_address, residing_since,
            office_no, residence_no, station_id, office_or_business_address, additional_particulars,
            area_or_land_of_cultivation, location_of_cultivation, whether_applicant_convicted,
            whether_applicant_ordered_to_convicted, whether_applicant_prohibited, whether_applicant_applied_before,
            whether_applicant_family_member_suspended_for_using_weapon, whether_applicant_suspended,
            has_safe_place_to_keep_arm, has_training, need_for_license, arms_type, ammunition_desc,
            area_of_arm_carry, special_consideration, detail_for_form_IV, place_of_birth, dob_in_words,
            status_id, permission_id;

    // Constructor


    public ArmLicenses(String arm_license_id, String parent_or_spouse_name,
                       String village, String present_address, String residing_since,
                       String office_no, String residence_no, String station_id,
                       String office_or_business_address, String additional_particulars,
                       String area_or_land_of_cultivation, String location_of_cultivation,
                       String whether_applicant_convicted, String whether_applicant_ordered_to_convicted,
                       String whether_applicant_prohibited, String whether_applicant_applied_before,
                       String whether_applicant_family_member_suspended_for_using_weapon,
                       String whether_applicant_suspended, String has_safe_place_to_keep_arm,
                       String has_training, String need_for_license, String arms_type,
                       String ammunition_desc, String area_of_arm_carry, String special_consideration,
                       String detail_for_form_IV, String place_of_birth, String dob_in_words,
                       String status_id, String permission_id) {
        this.arm_license_id = arm_license_id;
        this.parent_or_spouse_name = parent_or_spouse_name;
        this.village = village;
        this.present_address = present_address;
        this.residing_since = residing_since;
        this.office_no = office_no;
        this.residence_no = residence_no;
        this.station_id = station_id;
        this.office_or_business_address = office_or_business_address;
        this.additional_particulars = additional_particulars;
        this.area_or_land_of_cultivation = area_or_land_of_cultivation;
        this.location_of_cultivation = location_of_cultivation;
        this.whether_applicant_convicted = whether_applicant_convicted;
        this.whether_applicant_ordered_to_convicted = whether_applicant_ordered_to_convicted;
        this.whether_applicant_prohibited = whether_applicant_prohibited;
        this.whether_applicant_applied_before = whether_applicant_applied_before;
        this.whether_applicant_family_member_suspended_for_using_weapon = whether_applicant_family_member_suspended_for_using_weapon;
        this.whether_applicant_suspended = whether_applicant_suspended;
        this.has_safe_place_to_keep_arm = has_safe_place_to_keep_arm;
        this.has_training = has_training;
        this.need_for_license = need_for_license;
        this.arms_type = arms_type;
        this.ammunition_desc = ammunition_desc;
        this.area_of_arm_carry = area_of_arm_carry;
        this.special_consideration = special_consideration;
        this.detail_for_form_IV = detail_for_form_IV;
        this.place_of_birth = place_of_birth;
        this.dob_in_words = dob_in_words;
        this.status_id = status_id;
        this.permission_id = permission_id;
    }

    // Parcelable implementation
    protected ArmLicenses(Parcel in) {
        arm_license_id = in.readString();
        parent_or_spouse_name = in.readString();
        village = in.readString();
        present_address = in.readString();
        residing_since = in.readString();
        office_no = in.readString();
        residence_no = in.readString();
        station_id = in.readString();
        office_or_business_address = in.readString();
        additional_particulars = in.readString();
        area_or_land_of_cultivation = in.readString();
        location_of_cultivation = in.readString();
        whether_applicant_convicted = in.readString();
        whether_applicant_ordered_to_convicted = in.readString();
        whether_applicant_prohibited = in.readString();
        whether_applicant_applied_before = in.readString();
        whether_applicant_family_member_suspended_for_using_weapon = in.readString();
        whether_applicant_suspended = in.readString();
        has_safe_place_to_keep_arm = in.readString();
        has_training = in.readString();
        need_for_license = in.readString();
        arms_type = in.readString();
        ammunition_desc = in.readString();
        area_of_arm_carry = in.readString();
        special_consideration = in.readString();
        detail_for_form_IV = in.readString();
        place_of_birth = in.readString();
        dob_in_words = in.readString();
        status_id = in.readString();
        permission_id = in.readString();
    }

    public static final Creator<ArmLicenses> CREATOR = new Creator<ArmLicenses>() {
        @Override
        public ArmLicenses createFromParcel(Parcel in) {
            return new ArmLicenses(in);
        }

        @Override
        public ArmLicenses[] newArray(int size) {
            return new ArmLicenses[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(arm_license_id);
        parcel.writeString(parent_or_spouse_name);
        parcel.writeString(village);
        parcel.writeString(present_address);
        parcel.writeString(residing_since);
        parcel.writeString(office_no);
        parcel.writeString(residence_no);
        parcel.writeString(station_id);
        parcel.writeString(office_or_business_address);
        parcel.writeString(additional_particulars);
        parcel.writeString(area_or_land_of_cultivation);
        parcel.writeString(location_of_cultivation);
        parcel.writeString(whether_applicant_convicted);
        parcel.writeString(whether_applicant_ordered_to_convicted);
        parcel.writeString(whether_applicant_prohibited);
        parcel.writeString(whether_applicant_applied_before);
        parcel.writeString(whether_applicant_family_member_suspended_for_using_weapon);
        parcel.writeString(whether_applicant_suspended);
        parcel.writeString(has_safe_place_to_keep_arm);
        parcel.writeString(has_training);
        parcel.writeString(need_for_license);
        parcel.writeString(arms_type);
        parcel.writeString(ammunition_desc);
        parcel.writeString(area_of_arm_carry);
        parcel.writeString(special_consideration);
        parcel.writeString(detail_for_form_IV);
        parcel.writeString(place_of_birth);
        parcel.writeString(dob_in_words);
        parcel.writeString(status_id);
        parcel.writeString(permission_id);
    }

    public String getArm_license_id() {
        return arm_license_id;
    }

    public void setArm_license_id(String arm_license_id) {
        this.arm_license_id = arm_license_id;
    }

    public String getParent_or_spouse_name() {
        return parent_or_spouse_name;
    }

    public void setParent_or_spouse_name(String parent_or_spouse_name) {
        this.parent_or_spouse_name = parent_or_spouse_name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPresent_address() {
        return present_address;
    }

    public void setPresent_address(String present_address) {
        this.present_address = present_address;
    }

    public String getResiding_since() {
        return residing_since;
    }

    public void setResiding_since(String residing_since) {
        this.residing_since = residing_since;
    }

    public String getOffice_no() {
        return office_no;
    }

    public void setOffice_no(String office_no) {
        this.office_no = office_no;
    }

    public String getResidence_no() {
        return residence_no;
    }

    public void setResidence_no(String residence_no) {
        this.residence_no = residence_no;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getOffice_or_business_address() {
        return office_or_business_address;
    }

    public void setOffice_or_business_address(String office_or_business_address) {
        this.office_or_business_address = office_or_business_address;
    }

    public String getAdditional_particulars() {
        return additional_particulars;
    }

    public void setAdditional_particulars(String additional_particulars) {
        this.additional_particulars = additional_particulars;
    }

    public String getArea_or_land_of_cultivation() {
        return area_or_land_of_cultivation;
    }

    public void setArea_or_land_of_cultivation(String area_or_land_of_cultivation) {
        this.area_or_land_of_cultivation = area_or_land_of_cultivation;
    }

    public String getLocation_of_cultivation() {
        return location_of_cultivation;
    }

    public void setLocation_of_cultivation(String location_of_cultivation) {
        this.location_of_cultivation = location_of_cultivation;
    }

    public String getWhether_applicant_convicted() {
        return whether_applicant_convicted;
    }

    public void setWhether_applicant_convicted(String whether_applicant_convicted) {
        this.whether_applicant_convicted = whether_applicant_convicted;
    }

    public String getWhether_applicant_ordered_to_convicted() {
        return whether_applicant_ordered_to_convicted;
    }

    public void setWhether_applicant_ordered_to_convicted(String whether_applicant_ordered_to_convicted) {
        this.whether_applicant_ordered_to_convicted = whether_applicant_ordered_to_convicted;
    }

    public String getWhether_applicant_prohibited() {
        return whether_applicant_prohibited;
    }

    public void setWhether_applicant_prohibited(String whether_applicant_prohibited) {
        this.whether_applicant_prohibited = whether_applicant_prohibited;
    }

    public String getWhether_applicant_applied_before() {
        return whether_applicant_applied_before;
    }

    public void setWhether_applicant_applied_before(String whether_applicant_applied_before) {
        this.whether_applicant_applied_before = whether_applicant_applied_before;
    }

    public String getWhether_applicant_family_member_suspended_for_using_weapon() {
        return whether_applicant_family_member_suspended_for_using_weapon;
    }

    public void setWhether_applicant_family_member_suspended_for_using_weapon(String whether_applicant_family_member_suspended_for_using_weapon) {
        this.whether_applicant_family_member_suspended_for_using_weapon = whether_applicant_family_member_suspended_for_using_weapon;
    }

    public String getWhether_applicant_suspended() {
        return whether_applicant_suspended;
    }

    public void setWhether_applicant_suspended(String whether_applicant_suspended) {
        this.whether_applicant_suspended = whether_applicant_suspended;
    }

    public String getHas_safe_place_to_keep_arm() {
        return has_safe_place_to_keep_arm;
    }

    public void setHas_safe_place_to_keep_arm(String has_safe_place_to_keep_arm) {
        this.has_safe_place_to_keep_arm = has_safe_place_to_keep_arm;
    }

    public String getHas_training() {
        return has_training;
    }

    public void setHas_training(String has_training) {
        this.has_training = has_training;
    }

    public String getNeed_for_license() {
        return need_for_license;
    }

    public void setNeed_for_license(String need_for_license) {
        this.need_for_license = need_for_license;
    }

    public String getArms_type() {
        return arms_type;
    }

    public void setArms_type(String arms_type) {
        this.arms_type = arms_type;
    }

    public String getAmmunition_desc() {
        return ammunition_desc;
    }

    public void setAmmunition_desc(String ammunition_desc) {
        this.ammunition_desc = ammunition_desc;
    }

    public String getArea_of_arm_carry() {
        return area_of_arm_carry;
    }

    public void setArea_of_arm_carry(String area_of_arm_carry) {
        this.area_of_arm_carry = area_of_arm_carry;
    }

    public String getSpecial_consideration() {
        return special_consideration;
    }

    public void setSpecial_consideration(String special_consideration) {
        this.special_consideration = special_consideration;
    }

    public String getDetail_for_form_IV() {
        return detail_for_form_IV;
    }

    public void setDetail_for_form_IV(String detail_for_form_IV) {
        this.detail_for_form_IV = detail_for_form_IV;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getDob_in_words() {
        return dob_in_words;
    }

    public void setDob_in_words(String dob_in_words) {
        this.dob_in_words = dob_in_words;
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
// Getters and setters

    // You can generate getters and setters using your IDE or write them manually
}
