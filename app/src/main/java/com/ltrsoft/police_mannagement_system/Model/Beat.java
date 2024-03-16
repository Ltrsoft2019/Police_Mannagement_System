package com.ltrsoft.police_mannagement_system.Model;

public class Beat {
    private String beat_id,beat_name;

    public Beat(String beat_id, String beat_name) {
        this.beat_id = beat_id;
        this.beat_name = beat_name;
    }

    public String getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(String beat_id) {
        this.beat_id = beat_id;
    }

    public String getBeat_name() {
        return beat_name;
    }

    public void setBeat_name(String beat_name) {
        this.beat_name = beat_name;
    }
}
