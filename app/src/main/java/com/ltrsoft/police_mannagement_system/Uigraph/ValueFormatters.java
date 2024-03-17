package com.ltrsoft.police_mannagement_system.Uigraph;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
public class ValueFormatters implements IAxisValueFormatter {
    private final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        int index = (int) value;
        if (index >= 0 && index < months.length) {
            return months[index];
        } else {
            return "";
        }
    }
}
