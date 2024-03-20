package com.ltrsoft.police_mannagement_system.Model;

public class BargraphModelclass {

    public BargraphModelclass(String colorcode) {
        this.colorcode = colorcode;
    }

    String label;
    float value;
    String colorcode;

    public BargraphModelclass(String label, float value, String colorcode) {
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
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
