package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.Fragment.analysis.FilterFragment;
import com.ltrsoft.police_mannagement_system.Model.Stationmodel;
import com.ltrsoft.police_mannagement_system.Model.Villagemodel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.StationAdapter;
import com.ltrsoft.police_mannagement_system.adapters.VillageAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class Station_Analysis extends Fragment {


    public Station_Analysis() {
        // Required empty public constructor
    }
    public PieChart chart;
    private LineChart lineChart;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.station__analysis, container, false);

        chart = view.findViewById(R.id.piechart);
        lineChart = view.findViewById(R.id.linechart);
        recyclerView = view.findViewById(R.id.village_recycler);
        setPie(100,12,50);
        setLine(getEntries());
        setRecycler();

        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new FilterFragment()).addToBackStack(null).commit();

            }
        });

        lineChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-4 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new FilterFragment()).addToBackStack(null).commit();

            }
        });
        return view;
    }

    private void setRecycler() {
        ArrayList<Villagemodel> districts= new ArrayList<>();
        districts.add(new Villagemodel(" Bangluru","1","419213"));
        districts.add(new Villagemodel("Bidar","555","16700"));
        districts.add(new Villagemodel("Bhalaki","66","45100"));
        districts.add(new Villagemodel("Umaraga","44","5659100"));
        VillageAdapter adapter = new VillageAdapter(districts);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void setLine(List<Entry> entries) {
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        dataSet.setLineWidth(3f);
        dataSet.setCircleColor(Color.parseColor("#EF5350"));
        // Refresh the chart
        lineChart.invalidate();
        lineChart.animateX(2000, Easing.EaseInBounce); // A
    }


    private void setPie(int i, int i1, int i2) {
        chart.addPieSlice(
                new PieModel(
                        "Heinous", 100, Color.parseColor("#FFA726")));
//        chart.addPieSlice(
//                new PieModel(
//                        "Non Heinous", 12,
//                        Color.parseColor("#66BB6A")));
        chart.addPieSlice(
                new PieModel(
                        "Total complaints", 111,
                        Color.parseColor("#EF5350")));
        chart.startAnimation();
    }
    public  List<Entry> getEntries (){
        List<Entry>entries=new ArrayList<>();
        entries.add(new Entry(0f, 30f));
        entries.add(new Entry(1f, 20f));
        entries.add(new Entry(2f, 40f));
        entries.add(new Entry(3f, 50f));
        entries.add(new Entry(4f, 70f));
        entries.add(new Entry(5f, 90f));
        return entries;
    }

}