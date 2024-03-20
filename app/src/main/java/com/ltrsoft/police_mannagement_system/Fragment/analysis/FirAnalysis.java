package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class FirAnalysis extends Fragment {
    public FirAnalysis() {}
    View view;
    private  BarChart barChart;
    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fir_detail, container, false);
        barChart = view.findViewById(R.id.detail_fir_barchart);
        pieChart = view.findViewById(R.id.acp_piechart);


        setBarChart();
        setPie(12,23,34);
        Toast.makeText(getContext(), "on fir analysis", Toast.LENGTH_SHORT).show();
        return view;
    }

    private void setPie(int i, int i1, int i2) {
        pieChart.addPieSlice(
                new PieModel(
                        "Heinous", i, Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Non Heinous", i1,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Total complaints", i2,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "esf complaints", i,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "esf complaints", i2,
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "sef complaints", i1,
                        Color.parseColor("#EF5350")));
        pieChart.startAnimation();
    }
    public List<Entry> getEntries (){
        List<Entry>entries=new ArrayList<>();
        entries.add(new Entry(0f, 30f));
        entries.add(new Entry(1f, 20f));
        entries.add(new Entry(2f, 40f));
        entries.add(new Entry(3f, 50f));
        entries.add(new Entry(4f, 70f));
        entries.add(new Entry(5f, 90f));
        return entries;
    }

    private void setBarChart() {
        BarModel barModel1 = new BarModel("Jan", 10f, Color.parseColor("#3366FF"));
        BarModel barModel2 = new BarModel("Feb", 20f, Color.parseColor("#3366FF"));
        BarModel barModel3 = new BarModel("March", 30f, Color.parseColor("#00C853"));
        BarModel barModel4 = new BarModel("April", 25f, Color.parseColor("#00C853"));
        BarModel barModel5 = new BarModel("May", 23f, Color.parseColor("#AA66CC"));
        BarModel barModel6 = new BarModel("June", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel7 = new BarModel("Julai", 100f, Color.parseColor("#AA66CC"));
        BarModel barModel8 = new BarModel("Aug", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel9 = new BarModel("Sept", 105f, Color.parseColor("#AA66CC"));
        BarModel barModel10 = new BarModel("Oct",  15f, Color.parseColor("#AA66CC"));
        BarModel barModel11 = new BarModel("Nov", 55f, Color.parseColor("#AA66CC"));
        BarModel barModel12 = new BarModel("Dec", 35f, Color.parseColor("#AA66CC"));

        barChart.addBar(barModel1);

        barChart.addBar(barModel2);
        barChart.addBar(barModel3);
        barChart.addBar(barModel4);
        barChart.addBar(barModel5);
        barChart.addBar(barModel6);
        barChart.addBar(barModel7);
        barChart.addBar(barModel8);
        barChart.addBar(barModel9);
        barChart.addBar(barModel10);
        barChart.addBar(barModel11);
        barChart.addBar(barModel12);
        barChart.setBarWidth(0.00000001f);
        barChart.setElevation(.2f);
        barChart.startAnimation();
    }
}