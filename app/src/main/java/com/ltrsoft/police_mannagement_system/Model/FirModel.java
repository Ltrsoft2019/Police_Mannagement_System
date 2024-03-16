package com.ltrsoft.police_mannagement_system.Model;

public class FirModel {
    private String id, District_Name, UnitName, FIRNo, RI, Year, Month, Offence_From_Date, Offence_To_Date,
            FIR_Reg_DateTime, FIR_Date, FIR_Type, FIR_Stage, Complaint_Mode, CrimeGroup_Name,
            CrimeHead_Name, Latitude, Longitude, ActSection, IOName, KGID, IOAssigned_Date,
            Internal_IO, Place_of_Offence, Distance_from_PS, Beat_Name, Village_Area_Name, Male,
            Female, Boy, Girl, Age_0, VICTIM_COUNT, Accused_Count, Arrested_Male, Arrested_Female,
            Arrested_Count, Accused_ChargeSheeted_Count, Conviction_Count, FIR_ID, Unit_ID, Crime_No;

    public FirModel(String id, String district_Name, String unitName, String FIRNo) {
        this.id = id;
        District_Name = district_Name;
        UnitName = unitName;
        this.FIRNo = FIRNo;
    }

    public FirModel(String id, String district_Name, String unitName, String FIRNo, String RI, String year, String month, String offence_From_Date, String offence_To_Date, String FIR_Reg_DateTime, String FIR_Date, String FIR_Type, String FIR_Stage, String complaint_Mode, String crimeGroup_Name, String crimeHead_Name, String latitude, String longitude, String actSection, String IOName, String KGID, String IOAssigned_Date, String internal_IO, String place_of_Offence, String distance_from_PS, String beat_Name, String village_Area_Name, String male, String female, String boy, String girl, String age_0, String VICTIM_COUNT, String accused_Count, String arrested_Male, String arrested_Female, String arrested_Count, String accused_ChargeSheeted_Count, String conviction_Count, String FIR_ID, String unit_ID, String crime_No) {
        this.id = id;
        District_Name = district_Name;
        UnitName = unitName;
        this.FIRNo = FIRNo;
        this.RI = RI;
        Year = year;
        Month = month;
        Offence_From_Date = offence_From_Date;
        Offence_To_Date = offence_To_Date;
        this.FIR_Reg_DateTime = FIR_Reg_DateTime;
        this.FIR_Date = FIR_Date;
        this.FIR_Type = FIR_Type;
        this.FIR_Stage = FIR_Stage;
        Complaint_Mode = complaint_Mode;
        CrimeGroup_Name = crimeGroup_Name;
        CrimeHead_Name = crimeHead_Name;
        Latitude = latitude;
        Longitude = longitude;
        ActSection = actSection;
        this.IOName = IOName;
        this.KGID = KGID;
        this.IOAssigned_Date = IOAssigned_Date;
        Internal_IO = internal_IO;
        Place_of_Offence = place_of_Offence;
        Distance_from_PS = distance_from_PS;
        Beat_Name = beat_Name;
        Village_Area_Name = village_Area_Name;
        Male = male;
        Female = female;
        Boy = boy;
        Girl = girl;
        Age_0 = age_0;
        this.VICTIM_COUNT = VICTIM_COUNT;
        Accused_Count = accused_Count;
        Arrested_Male = arrested_Male;
        Arrested_Female = arrested_Female;
        Arrested_Count = arrested_Count;
        Accused_ChargeSheeted_Count = accused_ChargeSheeted_Count;
        Conviction_Count = conviction_Count;
        this.FIR_ID = FIR_ID;
        Unit_ID = unit_ID;
        Crime_No = crime_No;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict_Name() {
        return District_Name;
    }

    public void setDistrict_Name(String district_Name) {
        District_Name = district_Name;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getFIRNo() {
        return FIRNo;
    }

    public void setFIRNo(String FIRNo) {
        this.FIRNo = FIRNo;
    }

    public String getRI() {
        return RI;
    }

    public void setRI(String RI) {
        this.RI = RI;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getOffence_From_Date() {
        return Offence_From_Date;
    }

    public void setOffence_From_Date(String offence_From_Date) {
        Offence_From_Date = offence_From_Date;
    }

    public String getOffence_To_Date() {
        return Offence_To_Date;
    }

    public void setOffence_To_Date(String offence_To_Date) {
        Offence_To_Date = offence_To_Date;
    }

    public String getFIR_Reg_DateTime() {
        return FIR_Reg_DateTime;
    }

    public void setFIR_Reg_DateTime(String FIR_Reg_DateTime) {
        this.FIR_Reg_DateTime = FIR_Reg_DateTime;
    }

    public String getFIR_Date() {
        return FIR_Date;
    }

    public void setFIR_Date(String FIR_Date) {
        this.FIR_Date = FIR_Date;
    }

    public String getFIR_Type() {
        return FIR_Type;
    }

    public void setFIR_Type(String FIR_Type) {
        this.FIR_Type = FIR_Type;
    }

    public String getFIR_Stage() {
        return FIR_Stage;
    }

    public void setFIR_Stage(String FIR_Stage) {
        this.FIR_Stage = FIR_Stage;
    }

    public String getComplaint_Mode() {
        return Complaint_Mode;
    }

    public void setComplaint_Mode(String complaint_Mode) {
        Complaint_Mode = complaint_Mode;
    }

    public String getCrimeGroup_Name() {
        return CrimeGroup_Name;
    }

    public void setCrimeGroup_Name(String crimeGroup_Name) {
        CrimeGroup_Name = crimeGroup_Name;
    }

    public String getCrimeHead_Name() {
        return CrimeHead_Name;
    }

    public void setCrimeHead_Name(String crimeHead_Name) {
        CrimeHead_Name = crimeHead_Name;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getActSection() {
        return ActSection;
    }

    public void setActSection(String actSection) {
        ActSection = actSection;
    }

    public String getIOName() {
        return IOName;
    }

    public void setIOName(String IOName) {
        this.IOName = IOName;
    }

    public String getKGID() {
        return KGID;
    }

    public void setKGID(String KGID) {
        this.KGID = KGID;
    }

    public String getIOAssigned_Date() {
        return IOAssigned_Date;
    }

    public void setIOAssigned_Date(String IOAssigned_Date) {
        this.IOAssigned_Date = IOAssigned_Date;
    }

    public String getInternal_IO() {
        return Internal_IO;
    }

    public void setInternal_IO(String internal_IO) {
        Internal_IO = internal_IO;
    }

    public String getPlace_of_Offence() {
        return Place_of_Offence;
    }

    public void setPlace_of_Offence(String place_of_Offence) {
        Place_of_Offence = place_of_Offence;
    }

    public String getDistance_from_PS() {
        return Distance_from_PS;
    }

    public void setDistance_from_PS(String distance_from_PS) {
        Distance_from_PS = distance_from_PS;
    }

    public String getBeat_Name() {
        return Beat_Name;
    }

    public void setBeat_Name(String beat_Name) {
        Beat_Name = beat_Name;
    }

    public String getVillage_Area_Name() {
        return Village_Area_Name;
    }

    public void setVillage_Area_Name(String village_Area_Name) {
        Village_Area_Name = village_Area_Name;
    }

    public String getMale() {
        return Male;
    }

    public void setMale(String male) {
        Male = male;
    }

    public String getFemale() {
        return Female;
    }

    public void setFemale(String female) {
        Female = female;
    }

    public String getBoy() {
        return Boy;
    }

    public void setBoy(String boy) {
        Boy = boy;
    }

    public String getGirl() {
        return Girl;
    }

    public void setGirl(String girl) {
        Girl = girl;
    }

    public String getAge_0() {
        return Age_0;
    }

    public void setAge_0(String age_0) {
        Age_0 = age_0;
    }

    public String getVICTIM_COUNT() {
        return VICTIM_COUNT;
    }

    public void setVICTIM_COUNT(String VICTIM_COUNT) {
        this.VICTIM_COUNT = VICTIM_COUNT;
    }

    public String getAccused_Count() {
        return Accused_Count;
    }

    public void setAccused_Count(String accused_Count) {
        Accused_Count = accused_Count;
    }

    public String getArrested_Male() {
        return Arrested_Male;
    }

    public void setArrested_Male(String arrested_Male) {
        Arrested_Male = arrested_Male;
    }

    public String getArrested_Female() {
        return Arrested_Female;
    }

    public void setArrested_Female(String arrested_Female) {
        Arrested_Female = arrested_Female;
    }

    public String getArrested_Count() {
        return Arrested_Count;
    }

    public void setArrested_Count(String arrested_Count) {
        Arrested_Count = arrested_Count;
    }

    public String getAccused_ChargeSheeted_Count() {
        return Accused_ChargeSheeted_Count;
    }

    public void setAccused_ChargeSheeted_Count(String accused_ChargeSheeted_Count) {
        Accused_ChargeSheeted_Count = accused_ChargeSheeted_Count;
    }

    public String getConviction_Count() {
        return Conviction_Count;
    }

    public void setConviction_Count(String conviction_Count) {
        Conviction_Count = conviction_Count;
    }

    public String getFIR_ID() {
        return FIR_ID;
    }

    public void setFIR_ID(String FIR_ID) {
        this.FIR_ID = FIR_ID;
    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }

    public String getCrime_No() {
        return Crime_No;
    }

    public void setCrime_No(String crime_No) {
        Crime_No = crime_No;
    }
}
