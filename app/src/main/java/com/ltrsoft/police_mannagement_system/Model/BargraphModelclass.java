package com.ltrsoft.police_mannagement_system.Model;

public class BargraphModelclass {
    Integer ba1value,bar2value,bar3value,bar4value;

    public BargraphModelclass(Integer ba1value, Integer bar2value, Integer bar3value, Integer bar4value) {
        this.ba1value = ba1value;
        this.bar2value = bar2value;
        this.bar3value = bar3value;
        this.bar4value = bar4value;
    }

    public BargraphModelclass(String colorcode) {
        this.colorcode = colorcode;
    }

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

    public Integer getBa1value() {
        return ba1value;
    }

    public void setBa1value(Integer ba1value) {
        this.ba1value = ba1value;
    }

    public Integer getBar2value() {
        return bar2value;
    }

    public void setBar2value(Integer bar2value) {
        this.bar2value = bar2value;
    }

    public Integer getBar3value() {
        return bar3value;
    }

    public void setBar3value(Integer bar3value) {
        this.bar3value = bar3value;
    }

    public Integer getBar4value() {
        return bar4value;
    }

    public void setBar4value(Integer bar4value) {
        this.bar4value = bar4value;
    }
}
