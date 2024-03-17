package com.ltrsoft.police_mannagement_system.Model;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.List;

public class LineChartModel {
        private List<Entry>dataSets;
        private String label;
        private String color_code;

    public LineChartModel(List<Entry> dataSets, String label, String color_code) {
        this.dataSets = dataSets;
        this.label = label;
        this.color_code = color_code;
    }

    public List<Entry> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<Entry> dataSets) {
        this.dataSets = dataSets;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }
}
