package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import com.ltrsoft.police_mannagement_system.Model.Bargraphscrollable;
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
    public PieChart firstagespie;
    private LineChart lineChart;
    private LinearLayout layout,firstagelayout;
    private TextView totalyearwise,textView;
    private Spinner yearspinner;
    private BarChart monthwisebarchart;
    private HorizontalScrollView horizontalScrollView;
    org.eazegraph.lib.charts.BarChart barChartyear;
    private PieChart pieChart;
    String selectedyear;
    private String FIRSTAGESBYYEAR="https://rj.ltr-soft.com//dataset_api/fir_status/count_fir_by_year.php";
    private String GETDATAOFTHEYEAR="https://rj.ltr-soft.com/dataset_api/fir_tbl/all_fir_of_table.php";
     private String URL ="https://rj.ltr-soft.com/dataset_api/district/unique_district.php";
    private ArrayList<PiechartModelclass>list;
    private  String GETYEARCOUNTURL="https://rj.ltr-soft.com/dataset_api/fir_tbl/all_year_count.php";
    private String  URLS= "https://rj.ltr-soft.com/public/dataset_api/fir_tbl/fir_read_station.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.main_design,container,false);
         firstagespie = view.findViewById(R.id.firstagespie);
         lineChart = view.findViewById(R.id.linechart);
         firstagelayout=view.findViewById(R.id.firstagelayout);
         barChartyear=view.findViewById(R.id.barchartofyear);
         layout=view.findViewById(R.id.piechartitem);
         totalyearwise=view.findViewById(R.id.totalyearwiase);
         textView=view.findViewById(R.id.Total_cases);
         horizontalScrollView=view.findViewById(R.id.horizontalScrollView);
         monthwisebarchart=view.findViewById(R.id.barchartyear);
         yearspinner=view.findViewById(R.id.yearspinner);
         pieChart = view.findViewById(R.id.firstagespie);
//         new SetupDataTask().execute();
//             setspinner();
//             setyeatbarchart();
//             setfirstagespie();
        new Handler().postDelayed(() -> {
            setspinner();
        }, 5000);

        new Handler().postDelayed(() -> {
            setyeatbarchart();
        }, 10000);

        new Handler().postDelayed(() -> {
            setfirstagespie();
        }, 20000);

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


         return view;
    }

    private void setyeatbarchart() {
        ArrayList<BargraphModelclass>list1=new ArrayList<>();
        DAO dao=new DAO(getContext());
        dao.getData(null, GETYEARCOUNTURL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<String>list2=new ArrayList<>();
                try {
                    JSONObject jsonObject=new JSONObject(String.valueOf(object));
//                    StringBuilder stringBuilder = new StringBuilder("year20");
                    for (int q = 16; q <25 ; q++) {
                        list2.add(jsonObject.getString("year20"+String.valueOf(q)));
                    }
                }catch (JSONException e){
                    Toast.makeText(getContext(), "JSON EXCEPTION"+e.toString(), Toast.LENGTH_SHORT).show();
                }
                setbargraphofyear(list2);
             }

            @Override
            public void onEmpty() {

            }
        },8000);

     }
     private void setbargraphofyear(ArrayList<String> list){
        ArrayList<BargraphModelclass>modelclasses=new ArrayList<>();
        modelclasses.add(new BargraphModelclass("2016",Float.valueOf(list.get(0)),"#FFA726"));
        modelclasses.add(new BargraphModelclass("2017",Float.valueOf(list.get(1)),"#EA0075"));
        modelclasses.add(new BargraphModelclass("2018",Float.valueOf(list.get(2)),"#B3DD31"));
        modelclasses.add(new BargraphModelclass("2019",Float.valueOf(list.get(3)),"#FFF424"));
        modelclasses.add(new BargraphModelclass("2020",Float.valueOf(list.get(4)),"#00B2E2"));
        modelclasses.add(new BargraphModelclass("2021",Float.valueOf(list.get(5)),"#EF5350"));
        modelclasses.add(new BargraphModelclass("2022",Float.valueOf(list.get(6)),"#66BB6A"));
        modelclasses.add(new BargraphModelclass("2023",Float.valueOf(list.get(7)),"#EF5350"));
        modelclasses.add(new BargraphModelclass("2024",Float.valueOf(list.get(8)),"#EA0075"));
        Bargraphchart bargraphchart=new Bargraphchart(modelclasses);
        bargraphchart.setbargraph(barChartyear);

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
              Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
          }
      });
    }

    private void setbargraphofmonthwiseyear(String totalcount, ArrayList<String> list1)
    {
//
        totalyearwise.setText("Total Cases : "+totalcount);
      ArrayList<Bargraphscrollable>bargraphscrollables=new ArrayList<>();
      bargraphscrollables.add(new Bargraphscrollable(1f,list1.get(0),"#FFF424"));
      bargraphscrollables.add(new Bargraphscrollable(2f,list1.get(1),"#00B2E2"));
      bargraphscrollables.add(new Bargraphscrollable(3f,list1.get(2),"#B3DD31"));
      bargraphscrollables.add(new Bargraphscrollable(4f,list1.get(3),"#EA0075"));
      bargraphscrollables.add(new Bargraphscrollable(5f,list1.get(4),"#FFF424"));
      bargraphscrollables.add(new Bargraphscrollable(6f,list1.get(5),"#00B2E2"));
      bargraphscrollables.add(new Bargraphscrollable(7f,list1.get(6),"#B3DD31"));
      bargraphscrollables.add(new Bargraphscrollable(8f,list1.get(7),"#EA0075"));
      bargraphscrollables.add(new Bargraphscrollable(9f,list1.get(8),"#FFF424"));
      bargraphscrollables.add(new Bargraphscrollable(10f,list1.get(9),"#00B2E2"));
      bargraphscrollables.add(new Bargraphscrollable(11f,list1.get(10),"#B3DD31"));
      bargraphscrollables.add(new Bargraphscrollable(12f,list1.get(11),"#EA0075"));

        String[] xAxisLabels = new String[]{"jan", "feb", "march", "april", "may", "june", "julai","aug",
                "sep","oct","nov","dec"};

        Fourbargraph.setoneBarChart( bargraphscrollables, monthwisebarchart, xAxisLabels);

 
    }
    private void setfirstagespie(){
        DAO dao=new DAO(getContext());
        HashMap<String,String>map=new HashMap<>();
        map.put("year","2016");
        dao.getData(map, FIRSTAGESBYYEAR, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<PiechartModelclass>list1=new ArrayList<>();
                String disAcq = "",convicte="",pendingTrial="",boundOver="",otherDisposal="",traced=""
                        ,falseCase="",undetected="",abated="",compounded="",unTraced="",underInvestigation="";
                try {
                    JSONObject jsonObject=new JSONObject(String.valueOf(object));

                      disAcq = jsonObject.getString("Dis/Acq");
                      convicte = jsonObject.getString("Convicted");
                      pendingTrial = jsonObject.getString("Pending Trial");
                      boundOver = jsonObject.getString("BoundOver");
                      otherDisposal = jsonObject.getString("Other Disposal");
                      traced = jsonObject.getString("Traced");
                      falseCase = jsonObject.getString("False Case");
                      undetected = jsonObject.getString("Undetected");
                      abated = jsonObject.getString("Abated");
                      compounded = jsonObject.getString("Compounded");
                      unTraced = jsonObject.getString("Un Traced");
                      underInvestigation = jsonObject.getString("Under Investigation");

                }catch (JSONException e){
                    Toast.makeText(getContext(), "Jconvictedson Exception"+e, Toast.LENGTH_SHORT).show();
                }

                ArrayList<PiechartModelclass>list2=new ArrayList<>();
                list2.add(new PiechartModelclass("disAcq",Integer.valueOf(disAcq),"#FFF424"));
                list2.add(new PiechartModelclass("convicted",Integer.valueOf(convicte),"#EA0075"));
                list2.add(new PiechartModelclass("pendingTrial",Integer.valueOf(pendingTrial),"#B3DD31"));
                list2.add(new PiechartModelclass("boundOver",Integer.valueOf(boundOver),"#EA0075"));
                list2.add(new PiechartModelclass("otherDisposal",Integer.valueOf(otherDisposal),"#B3DD31"));
                list2.add(new PiechartModelclass("traced",Integer.valueOf(traced),"#FF8C00"));
                list2.add(new PiechartModelclass("falseCase",Integer.valueOf(falseCase),"#8A2BE2"));
                list2.add(new PiechartModelclass("underInvestigation",Integer.valueOf(undetected),"#32CD32"));
                list2.add(new PiechartModelclass("unTraced",Integer.valueOf(abated),"#FF1493"));
                list2.add(new PiechartModelclass("compounded",Integer.valueOf(falseCase),"#32CD32"));
                list2.add(new PiechartModelclass("abated",Integer.valueOf(compounded),"#8A2BE2"));
                list2.add(new PiechartModelclass("undetected",Integer.valueOf(unTraced),"#FF8C00"));
                list2.add(new PiechartModelclass("undetected",Integer.valueOf(underInvestigation),"#FF9C00"));
                Piechartgraph piechartgraph=new Piechartgraph(list2,firstagelayout);
                piechartgraph.setpie(firstagespie);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        },15000);
     }

}

