package com.ltrsoft.police_mannagement_system.Model;

public class PiechartModelclass {
    String label;Integer value;
    String colorcode;

    public PiechartModelclass(String label, Integer value, String colorcode) {
        this.label = label;
        this.value = value;
        this.colorcode = colorcode;
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
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }
}
