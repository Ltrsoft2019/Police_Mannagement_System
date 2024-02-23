package com.ltrsoft.police_mannagement_system.Model;

public class Care_employee_more_detail {
    private  String id	,care_employee_id	,employee_id,	job_title_id	,department_id	,shift_timings,
    skills_and_qualificationsShiftTimings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCare_employee_id() {
        return care_employee_id;
    }

    public void setCare_employee_id(String care_employee_id) {
        this.care_employee_id = care_employee_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getJob_title_id() {
        return job_title_id;
    }

    public void setJob_title_id(String job_title_id) {
        this.job_title_id = job_title_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getShift_timings() {
        return shift_timings;
    }

    public void setShift_timings(String shift_timings) {
        this.shift_timings = shift_timings;
    }

    public String getSkills_and_qualificationsShiftTimings() {
        return skills_and_qualificationsShiftTimings;
    }

    public void setSkills_and_qualificationsShiftTimings(String skills_and_qualificationsShiftTimings) {
        this.skills_and_qualificationsShiftTimings = skills_and_qualificationsShiftTimings;
    }
}
