package com.ltrsoft.police_mannagement_system.Model;

public class FirReport {
    private String 	id	,District_Name	,UnitName	,FIRNo	,RI,	Year,	Month,	FIR_Date	,Report_Date	,Final_Report_Date,	Report_Type,	FIR_ID	,Unit_ID	,Crime_No,	FR_ID;

    public FirReport(String id, String district_Name, String unitName, String FIRNo, String RI, String year, String month, String FIR_Date, String report_Date, String final_Report_Date, String report_Type, String FIR_ID, String unit_ID, String crime_No, String FR_ID) {
        this.id = id;
        District_Name = district_Name;
        UnitName = unitName;
        this.FIRNo = FIRNo;
        this.RI = RI;
        Year = year;
        Month = month;
        this.FIR_Date = FIR_Date;
        Report_Date = report_Date;
        Final_Report_Date = final_Report_Date;
        Report_Type = report_Type;
        this.FIR_ID = FIR_ID;
        Unit_ID = unit_ID;
        Crime_No = crime_No;
        this.FR_ID = FR_ID;
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

    public String getFIR_Date() {
        return FIR_Date;
    }

    public void setFIR_Date(String FIR_Date) {
        this.FIR_Date = FIR_Date;
    }

    public String getReport_Date() {
        return Report_Date;
    }

    public void setReport_Date(String report_Date) {
        Report_Date = report_Date;
    }

    public String getFinal_Report_Date() {
        return Final_Report_Date;
    }

    public void setFinal_Report_Date(String final_Report_Date) {
        Final_Report_Date = final_Report_Date;
    }

    public String getReport_Type() {
        return Report_Type;
    }

    public void setReport_Type(String report_Type) {
        Report_Type = report_Type;
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

    public String getFR_ID() {
        return FR_ID;
    }

    public void setFR_ID(String FR_ID) {
        this.FR_ID = FR_ID;
    }
}
