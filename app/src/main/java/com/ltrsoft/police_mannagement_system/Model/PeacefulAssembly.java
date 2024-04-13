package com.ltrsoft.police_mannagement_system.Model;

public class PeacefulAssembly {

    private String peaceful_assembly_id, name_of_organization, designation,
            is_organization_registered,
            procession_reason, date, type_of_procession, number_of_participants, from,
            to, loaction, country, state, district, village,city, time_from, time_to, station_id,
            single_or_multiple_police_station, status_id;

    public PeacefulAssembly(String peaceful_assembly_id, String name_of_organization,
                            String designation, String is_organization_registered,
                            String procession_reason, String date, String type_of_procession,
                            String number_of_participants, String from, String to, String loaction,
                            String country, String state, String district, String village,
                            String city, String time_from, String time_to, String station_id,
                            String single_or_multiple_police_station, String status_id) {
        this.peaceful_assembly_id = peaceful_assembly_id;
        this.name_of_organization = name_of_organization;
        this.designation = designation;
        this.is_organization_registered = is_organization_registered;
        this.procession_reason = procession_reason;
        this.date = date;
        this.type_of_procession = type_of_procession;
        this.number_of_participants = number_of_participants;
        this.from = from;
        this.to = to;
        this.loaction = loaction;
        this.country = country;
        this.state = state;
        this.district = district;
        this.village = village;
        this.city = city;
        this.time_from = time_from;
        this.time_to = time_to;
        this.station_id = station_id;
        this.single_or_multiple_police_station = single_or_multiple_police_station;
        this.status_id = status_id;
    }

    public String getPeaceful_assembly_id() {
        return peaceful_assembly_id;
    }

    public void setPeaceful_assembly_id(String peaceful_assembly_id) {
        this.peaceful_assembly_id = peaceful_assembly_id;
    }

    public String getName_of_organization() {
        return name_of_organization;
    }

    public void setName_of_organization(String name_of_organization) {
        this.name_of_organization = name_of_organization;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIs_organization_registered() {
        return is_organization_registered;
    }

    public void setIs_organization_registered(String is_organization_registered) {
        this.is_organization_registered = is_organization_registered;
    }

    public String getProcession_reason() {
        return procession_reason;
    }

    public void setProcession_reason(String procession_reason) {
        this.procession_reason = procession_reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType_of_procession() {
        return type_of_procession;
    }

    public void setType_of_procession(String type_of_procession) {
        this.type_of_procession = type_of_procession;
    }

    public String getNumber_of_participants() {
        return number_of_participants;
    }

    public void setNumber_of_participants(String number_of_participants) {
        this.number_of_participants = number_of_participants;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime_from() {
        return time_from;
    }

    public void setTime_from(String time_from) {
        this.time_from = time_from;
    }

    public String getTime_to() {
        return time_to;
    }

    public void setTime_to(String time_to) {
        this.time_to = time_to;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getSingle_or_multiple_police_station() {
        return single_or_multiple_police_station;
    }

    public void setSingle_or_multiple_police_station(String single_or_multiple_police_station) {
        this.single_or_multiple_police_station = single_or_multiple_police_station;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
}
