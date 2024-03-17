package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.ltrsoft.police_mannagement_system.Model.LineChartModel;


import java.util.List;

public class LineChartFactory {
    private Context context;
    LinearLayout layout;
    List<LineChartModel>models;

    public LineChartFactory(List<LineChartModel>dataSets,Context context, LinearLayout layout) {
       this.models=dataSets;
        this.context = context;
        this.layout = layout;
    }

    public void createLine(LineChart lineChart) {
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setValueFormatter(new ValueFormatter() {
            final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int index = (int) value;
                if (index >= 0 && index < months.length) {
                    return months[index];
                } else {
                    return "";
                }
            }
        });

        Toast.makeText(context, "size "+models.size(), Toast.LENGTH_SHORT).show();

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

