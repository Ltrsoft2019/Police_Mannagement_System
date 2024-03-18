package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.eazegraph.lib.models.BarModel;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.Model.YearModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.adapters.YearAdapter;

import java.util.ArrayList;

public class Filter_year_month extends Fragment {
    public Filter_year_month() {
    }
    BarChart barChart;
    ArrayList<BargraphModelclass>list;
    private RecyclerView recyclerView;
    BarDataSet barDataSet1, barDataSet2,barDataSet3,barDataSet4;

    // array list for storing entries.
    ArrayList barEntries;

    // creating a string array for displaying days.
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"};




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.year, container, false);
        barChart = view.findViewById(R.id.barchart);
        Toast.makeText(getContext(), "on year", Toast.LENGTH_SHORT).show();
        recyclerView=view.findViewById(R.id.year_recycler);
        setBar();
//        list=new ArrayList<>();
//        list.add(new BargraphModelclass("jan",7f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",10f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",11f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",11f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",11f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",6f,"#3366FF"));
//        list.add(new BargraphModelclass("jan",5f,"#3366FF"));
//        Bargraphchart bargraphchart=new Bargraphchart(list);
       // bargraphchart.setbargraph(barChart);

        setrecycler();
        return view;
    }

    private void setrecycler() {
//        ArrayList<YearModel>models = new ArrayList<>();
//        models.add(new YearModel("2016","12344"));
//        models.add(new YearModel("2017","1234654"));
//        models.add(new YearModel("2018","1265344"));
//        models.add(new YearModel("2019","12345544"));
//        models.add(new YearModel("2020","1234544"));
//        models.add(new YearModel("2021","1234794"));
//        models.add(new YearModel("2022","12344"));
//        models.add(new YearModel("2023","12344"));
//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        YearAdapter adapter = new YearAdapter(models);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
   }

    private void setBar() {




            // creating a new bar data set.
            barDataSet1 = new BarDataSet(getBarEntriesOne(), "First Set");
            barDataSet1.setColor(Color.parseColor("#FFF424"));
            barDataSet2 = new BarDataSet(getBarEntriesTwo(), "Second Set");
            barDataSet2.setColor(Color.parseColor("#00B2E2"));
        barDataSet3= new BarDataSet(getBarEntriesOne(), "First Set");
        barDataSet3.setColor(Color.parseColor("#B3DD31"));
        barDataSet4 = new BarDataSet(getBarEntriesTwo(), "Second Set");
        barDataSet4.setColor(Color.parseColor("#EA0075"));

             BarData data = new BarData(barDataSet1, barDataSet2,barDataSet3,barDataSet4);


            barChart.setData(data);


            barChart.getDescription().setEnabled(false);


            XAxis xAxis = barChart.getXAxis();


            xAxis.setValueFormatter(new IndexAxisValueFormatter(days));


            xAxis.setCenterAxisLabels(true);

            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


            xAxis.setGranularity(1);

            xAxis.setGranularityEnabled(true);


            barChart.setDragEnabled(true);


            barChart.setVisibleXRangeMaximum(3);


            float barSpace = 0f;

            float groupSpace = 0.4f;


            data.setBarWidth(0.15f);


            barChart.getXAxis().setAxisMinimum(0);


            barChart.animate();


            barChart.groupBars(0, groupSpace, barSpace);


            barChart.invalidate();
         }

        // array list for first set
        private ArrayList<BarEntry> getBarEntriesOne() {

            // creating a new array list
            barEntries = new ArrayList<>();

            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            barEntries.add(new BarEntry(1, 4));
            barEntries.add(new BarEntry(2f, 6));
            barEntries.add(new BarEntry(3f, 8));
            barEntries.add(new BarEntry(4f, 2));
            barEntries.add(new BarEntry(5f, 4));
            barEntries.add(new BarEntry(6f, 1));
            return barEntries;
        }

        // array list for second set.
        private ArrayList<BarEntry> getBarEntriesTwo() {

            // creating a new array list
            barEntries = new ArrayList<>();

            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            barEntries.add(new BarEntry(1f, 8));
            barEntries.add(new BarEntry(2f, 12));
            barEntries.add(new BarEntry(3f, 4));
            barEntries.add(new BarEntry(4f, 1));
            barEntries.add(new BarEntry(5f, 7));
            barEntries.add(new BarEntry(6f, 3));
            return barEntries;
        }


}
