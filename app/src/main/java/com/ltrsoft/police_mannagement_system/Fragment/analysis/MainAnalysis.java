package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.Model.District;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.Uigraph.Fourbargraph;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.adapters.DistrictAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainAnalysis extends Fragment {
    private View view;
    public PieChart chart;
    private LineChart lineChart;
    private LinearLayout layout;
    private TextView textView;
    private Spinner yearspinner;
    private BarChart monthwisebarchart;
    private HorizontalScrollView horizontalScrollView;
    String selectedyear;
    private String GETDATAOFTHEYEAR="https://rj.ltr-soft.com/dataset_api/fir_tbl/all_fir_of_table.php";
     private String URL ="https://rj.ltr-soft.com/dataset_api/district/unique_district.php";
    private ArrayList<PiechartModelclass>list;
    private String  URLS= "https://rj.ltr-soft.com/public/dataset_api/fir_tbl/fir_read_station.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.main_design,container,false);
         chart = view.findViewById(R.id.piechart);
         lineChart = view.findViewById(R.id.linechart);
         layout=view.findViewById(R.id.piechartitem);
         textView=view.findViewById(R.id.Total_cases);
         horizontalScrollView=view.findViewById(R.id.horizontalScrollView);
         monthwisebarchart=view.findViewById(R.id.barchartyear);
         yearspinner=view.findViewById(R.id.yearspinner);
         setspinner();
         yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 selectedyear=adapterView.getItemAtPosition(i).toString();
                 setbarchartbyyear(selectedyear);
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {
              selectedyear="2016";
             }
         });

//        recyclerView = view.findViewById(R.id.district_recycler);

//        HashMap hashMap=new HashMap<>();
//        hashMap.put("Unit_ID",)
//        dao.getData();
//        list=new ArrayList<>();
//        list.add(new PiechartModelclass("Hinious",100,"#FFA726"));
//        list.add(new PiechartModelclass("Hinious",100,"#EF5350"));
//        list.add(new PiechartModelclass("Hinious",100,"#66BB6A"));
//        list.add(new PiechartModelclass("Hinious",100,"#FFA726"));
//        list.add(new PiechartModelclass("Hinious",100,"#EF5350"));
//        list.add(new PiechartModelclass("Hinious",100,"#66BB6A"));
//        textView.append(" 600");
//        Piechartgraph piechartgraph=new Piechartgraph(list,layout);
//        piechartgraph.setpie(chart);
//
//        setLine(getEntries());
//        setRecycler();

//       chart.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new FilterFragment()).addToBackStack(null).commit();
//
//           }
//       });
//
//        lineChart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new FilterFragment()).addToBackStack(null).commit();
//
//            }
//        });
         return view;
    }

    private void setspinner() {

        ArrayList list1=new ArrayList();
        list1.add("2016");
        list1.add("2017");
        list1.add("2018");
        list1.add("2019");
        list1.add("2020");
        list1.add("2021");
        list1.add("2022");
        list1.add("2023");
        list1.add("2024");
        ArrayAdapter<String> adapter=new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line,list1);
        yearspinner.setAdapter(adapter);

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
    public void setbarchartbyyear(String year){
      DAO dao=new DAO(getContext());
      HashMap<String,String>map=new HashMap<>();
      map.put("year",year);
      dao.getData(map, GETDATAOFTHEYEAR, new NewCallBack() {
          @Override
          public void onError(String error) {
              Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onSuccess(Object object) {
              ArrayList<String> list1 = new ArrayList<>();
              if (!list1.isEmpty()){
                  list1.clear();
              }
              String totalcount="";
              try {
                  JSONObject jsonObject =new JSONObject(String.valueOf(object));
                    totalcount = jsonObject.getString("count");
                   StringBuilder months = new StringBuilder("month");
                  for (int i = 1; i < 13; i++) {
                      list1.add(jsonObject.getString(months+String.valueOf(i)));

                  }
                  setbargraphofmonthwiseyear(totalcount,list1);

                 // Toast.makeText(getContext(), "size "+list1.size(), Toast.LENGTH_SHORT).show();
              }catch (JSONException e){
                  Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
              }

          }

          @Override
          public void onEmpty() {

          }
      });
    }

    private void setbargraphofmonthwiseyear(String totalcount, ArrayList<String> list1)
    {
//        if (monthwisebarchart.isShowValues()){
//            monthwisebarchart.clearChart();
//        }
//        ArrayList<BargraphModelclass>list=new ArrayList<>();
//
//        list.clear();
        ArrayList<ArrayList<BarEntry>> entriesList = new ArrayList<>();
        entriesList.add(getBarEntriesOne(list1));
         ArrayList<BargraphModelclass>list=new ArrayList<>();
        list.add(new BargraphModelclass("#FFF424"));


        String[] xAxisLabels = new String[]{"jan", "feb", "march", "april", "may", "june", "julai","aug",
                "sep","oct","nov","dec"};

        Fourbargraph.setoneBarChart(entriesList, monthwisebarchart, xAxisLabels,list);


    }
    private ArrayList<BarEntry> getBarEntriesOne(ArrayList<String>list1) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 4));
        entries.add(new BarEntry(2f, 6));
        entries.add(new BarEntry(3f, 8));
        entries.add(new BarEntry(4f, 2));
        entries.add(new BarEntry(5f, 4));

        entries.add(new BarEntry(6f, 1));
        entries.add(new BarEntry(6f, 1));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(11f, 1));
        entries.add(new BarEntry(12f, 1));
        entries.add(new BarEntry(14f, 1));
        entries.add(new BarEntry(15f, 1));
        return entries;
    }
}

