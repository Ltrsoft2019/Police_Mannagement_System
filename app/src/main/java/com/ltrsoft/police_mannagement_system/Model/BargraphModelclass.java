package com.ltrsoft.police_mannagement_system.Model;

public class BargraphModelclass {
    String label;
    Float value;
    String colorcode;

    public BargraphModelclass(String label, Float value, String colorcode) {
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }
}
