package com.ltrsoft.police_mannagement_system.Uigraph;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;

import java.util.ArrayList;
import java.util.List;

public class Fourbargraph {
    public static void setBarChart(ArrayList<ArrayList<BarEntry>> entriesList, BarChart barChart, String[] xAxisLabels,
                                    ArrayList<BargraphModelclass>list) {

            List<IBarDataSet> barDataSets = new ArrayList<>();

            for (int i = 0; i < entriesList.size(); i++) {
                BarDataSet barDataSet = new BarDataSet(entriesList.get(i), "Set " + (i + 1));
                barDataSet.setColor(Color.parseColor(list.get(i).getColorcode()));
                barDataSets.add(barDataSet);
            }

            BarData barData = new BarData(barDataSets); // No need to cast barDataSets
            barChart.setData(barData);
            barChart.getDescription().setEnabled(false);

            barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
            barChart.getXAxis().setCenterAxisLabels(true);
            barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
           // barChart.getXAxis().setGranularity(1);
            barChart.getXAxis().setGranularityEnabled(true);

            barChart.setDragEnabled(true);
            barChart.setVisibleXRangeMaximum(4);
            float barSpace = 0.05f;
            float groupSpace = 0.4f;
            barData.setBarWidth(0.15f);
            barChart.getXAxis().setAxisMinimum(0);

            barChart.animate();
            barChart.groupBars(0, groupSpace, barSpace);
            barChart.invalidate();
        }

}
