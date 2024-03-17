package com.ltrsoft.police_mannagement_system.Model;

public class PiechartModelclass {
    String label;
    Integer value;
    String Colorcode;

    public PiechartModelclass(String label, Integer value, String colorcode) {
        this.label = label;
        this.value = value;
        Colorcode = colorcode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getColorcode() {
        return Colorcode;
    }

    public void setColorcode(String colorcode) {
        Colorcode = colorcode;
    }
}
