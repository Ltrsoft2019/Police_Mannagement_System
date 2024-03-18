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
//        barChart.getDescription().setEnabled(false);
//
//        // below line is to get x axis
//        // of our bar chart.
//        XAxis xAxis = barChart.getXAxis();
//
//        // below line is to set value formatter to our x-axis and
//        // we are adding our days to our x axis.
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
//
//        // below line is to set center axis
//        // labels to our bar chart.
//        xAxis.setCenterAxisLabels(true);
//
//        // below line is to set position
//        // to our x-axis to bottom.
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//
//        // below line is to set granularity
//        // to our x axis labels.
//        xAxis.setGranularity(1);
//
//        // below line is to enable
//        // granularity to our x axis.
//        xAxis.setGranularityEnabled(true);
//
//        // below line is to make our
//        // bar chart as draggable.
//        barChart.setDragEnabled(true);
//
//        // below line is to make visible
//        // range for our bar chart.
//        barChart.setVisibleXRangeMaximum(3);
//
//        // below line is to add bar
//        // space to our chart.
//        float barSpace = 0.1f;
//
//        // below line is use to add group
//        // spacing to our bar chart.
//        float groupSpace = 0.5f;
//
//        // we are setting width of
//        // bar in below line.
//        data.setBarWidth(0.15f);
//
//        // below line is to set minimum
//        // axis to our chart.
//        barChart.getXAxis().setAxisMinimum(0);
//
//        // below line is to
//        // animate our chart.
//        barChart.animate();
//
//        // below line is to group bars
//        // and add spacing to it.
//        barChart.groupBars(0, groupSpace, barSpace);
//
//        // below line is to invalidate
//        // our bar chart.
//        barChart.invalidate();
    }

}
