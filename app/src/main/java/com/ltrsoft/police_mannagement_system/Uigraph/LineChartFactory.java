package com.ltrsoft.police_mannagement_system.Uigraph;
import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.ltrsoft.police_mannagement_system.Model.LineChartModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class LineChartFactory {
    List<LineChartModel> models;

    public LineChartFactory(List<LineChartModel> dataSets) {
        this.models = dataSets;
    }

    public void createLine(LineChart lineChart) {
        lineChart.getDescription().setEnabled(true);
        lineChart.getDescription().setText("This is a sample chart");

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                int monthIndex = (int) value;
                if (lineChart.getScaleX() > 30) {
                    return "";
                } else {
                    return months[monthIndex];
                }
            }
            private String getDaysForMonth(int monthIndex) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH, monthIndex); // Set the month
                int numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                StringBuilder daysStringBuilder = new StringBuilder();
                for (int i = 1; i <= numDaysInMonth; i++) {
                    daysStringBuilder.append(i).append(", "); // Append day to the string
                }
                return daysStringBuilder.substring(0, daysStringBuilder.length() - 2);
            }
        });

        for (LineChartModel model : models) {
            List<Entry> entries = model.getDataSets();
            LineDataSet dataSet = new LineDataSet(entries, model.getLabel());
            dataSet.setLineWidth(3f);
            dataSet.setCircleColor(Color.parseColor(model.getColor_code()));
            LineData data = new LineData(dataSet);
            lineChart.setData(data);
            lineChart.invalidate();
            lineChart.animateX(2000, Easing.EaseInBounce);
        }
    }
}