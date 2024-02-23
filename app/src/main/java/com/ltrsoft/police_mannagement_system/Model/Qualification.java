package com.ltrsoft.police_mannagement_system.Model;

public class Qualification {
    private String id,	police_id,	qualification_level_id	,qualification_school_college
            ,qualification_passing_year	,qualification_percentage_cgpa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getQualification_level_id() {
        return qualification_level_id;
    }

    public void setQualification_level_id(String qualification_level_id) {
        this.qualification_level_id = qualification_level_id;
    }

    public String getQualification_school_college() {
        return qualification_school_college;
    }

    public void setQualification_school_college(String qualification_school_college) {
        this.qualification_school_college = qualification_school_college;
    }

    public String getQualification_passing_year() {
        return qualification_passing_year;
    }

    public void setQualification_passing_year(String qualification_passing_year) {
        this.qualification_passing_year = qualification_passing_year;
    }

    public String getQualification_percentage_cgpa() {
        return qualification_percentage_cgpa;
    }

    public void setQualification_percentage_cgpa(String qualification_percentage_cgpa) {
        this.qualification_percentage_cgpa = qualification_percentage_cgpa;
    }
}
