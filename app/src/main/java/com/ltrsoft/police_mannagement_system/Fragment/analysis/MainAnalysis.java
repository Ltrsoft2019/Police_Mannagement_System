package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.Model.District;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.adapters.DistrictAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class MainAnalysis extends Fragment {
    View view;
    public PieChart chart;
    private LineChart lineChart;
    private LinearLayout layout;
    private RecyclerView recyclerView;
    ArrayList<PiechartModelclass>list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.main_design,container,false);
         chart = view.findViewById(R.id.piechart);
         lineChart = view.findViewById(R.id.linechart);
         layout=view.findViewById(R.id.piechartitem);
        recyclerView = view.findViewById(R.id.district_recycler);
       // setPie(100,12,50);
        list=new ArrayList<>();
        list.add(new PiechartModelclass("Hinious",100,"#FFA726"));
        list.add(new PiechartModelclass("Hinious",100,"#EF5350"));
        list.add(new PiechartModelclass("Hinious",100,"#66BB6A"));
        list.add(new PiechartModelclass("Hinious",100,"#FFA726"));
        list.add(new PiechartModelclass("Hinious",100,"#EF5350"));
        list.add(new PiechartModelclass("Hinious",100,"#66BB6A"));
        Piechartgraph piechartgraph=new Piechartgraph(list,layout);
        piechartgraph.setpie(chart);
      // piechartgraph.setcardlist(list);
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
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new FilterFragment()).addToBackStack(null).commit();

            }
        });
         return view;
    }

    private void setRecycler() {
        ArrayList<District>districts= new ArrayList<>();
        districts.add(new District("1","Latur","100","419213"));
        districts.add(new District("1","Bengluru","16700","19213"));
        districts.add(new District("1","Mumbai","45100","919213"));
        districts.add(new District("1","Pune","9100","43199213"));
        DistrictAdapter adapter = new DistrictAdapter(districts);
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
        chart.addPieSlice(
                new PieModel(
                        "Non Heinous", 12,
                        Color.parseColor("#66BB6A")));
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

