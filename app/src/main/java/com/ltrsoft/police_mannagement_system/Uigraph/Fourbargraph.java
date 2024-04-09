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
import com.ltrsoft.police_mannagement_system.Model.Bargraphscrollable;

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
            float barSpace = 0.04f;
            float groupSpace = 0.3f;
            barData.setBarWidth(0.14f);
            barChart.getXAxis().setAxisMinimum(0);

            barChart.animate();
            barChart.groupBars(0, groupSpace, barSpace);
            barChart.invalidate();
    }
    public static void settwoBarChart(ArrayList<ArrayList<BarEntry>> entriesList, BarChart barChart, String[] xAxisLabels,
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
         barChart.getXAxis().setGranularity(1);
        barChart.getXAxis().setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(4);
        float barSpace = 0.05f;
        float groupSpace = 0.35f;
        barData.setBarWidth(0.27f);
        barChart.getXAxis().setAxisMinimum(0);

        barChart.animate();
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.invalidate();
    }
    public static void setoneBarChart(ArrayList<Bargraphscrollable>list, BarChart barChart,String[] xAxisLabels) {
        List<IBarDataSet> barDataSets = new ArrayList<>();

        for (int i = 0; i <list.size(); i++) {
            ArrayList<BarEntry >barEntries=new ArrayList<>();
            barEntries.add(new BarEntry(list.get(i).getXaxis(),Float.valueOf(list.get(i).getYxis())));
            BarDataSet barDataSet = new BarDataSet(barEntries, "");
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
     //   barChart.getXAxis().setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(4);
         barData.setBarWidth(0.5f);
        barChart.getXAxis().setAxisMinimum(0);
        // Shift bars off the right side y-axis

        barChart.animate();

         barChart.invalidate();
    }

}
