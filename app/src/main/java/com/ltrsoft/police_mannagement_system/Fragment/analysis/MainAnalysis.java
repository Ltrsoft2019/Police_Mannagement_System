package com.ltrsoft.police_mannagement_system.Fragment.analysis;

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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.ltrsoft.police_mannagement_system.Fragment.DistrictList;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.Model.Bargraphscrollable;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.Uigraph.Fourbargraph;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAnalysis extends Fragment {
    private View view;
    public PieChart firstagespie;
    private LineChart lineChart;
    private LinearLayout layout,firstagelayout,firtypelayout,complaintmodelayout;
    private TextView totalyearwise,textView;
    private Spinner yearspinner,fir_typespinner,cmp_mode_spinner,stage_spinner;
    private BarChart monthwisebarchart;
    private HorizontalScrollView horizontalScrollView;
    org.eazegraph.lib.charts.BarChart barChartyear;
    private PieChart pieChart,firtypepiechart,Complaint_Modepiechart;
    String selectedyear;
    private boolean flag=false;
    private boolean flag2=false;

    private TextView district_analyse;
    private  String OverallComplaintmode="https://rj.ltr-soft.com/dataset_api/cmplaint_mode/read_all_count.php";
    private String OverllFirType="https://rj.ltr-soft.com/dataset_api/fir_type/read_all_count.php";
    private String FIRTYPE="https://rj.ltr-soft.com//dataset_api/fir_type/read_year_and_unit.php";
    private String FIRSTAGESBYYEAR="https://rj.ltr-soft.com//dataset_api/fir_status/count_fir_by_year.php";
    private String GETDATAOFTHEYEAR="https://rj.ltr-soft.com/dataset_api/fir_tbl/all_fir_of_table.php";
     private String URL ="https://rj.ltr-soft.com/dataset_api/district/unique_district.php";
    private ArrayList<PiechartModelclass>list;
    private  String GETYEARCOUNTURL="https://rj.ltr-soft.com/dataset_api/fir_tbl/all_year_count.php";
    private String  URLS= "https://rj.ltr-soft.com/public/dataset_api/fir_tbl/fir_read_station.php";
    private String FIRTYPEYEARWISE="https://rj.ltr-soft.com//dataset_api/fir_type/read_by_year.php";
    private String COM_MODE="https://rj.ltr-soft.com/dataset_api/cmplaint_mode/read_all_by_year.php";
    DAO dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.main_design,container,false);
         firstagespie = view.findViewById(R.id.firstagespie);
         firtypelayout=view.findViewById(R.id.firtypelayout);
         firtypepiechart=view.findViewById(R.id.firtypepiechart);
         lineChart = view.findViewById(R.id.linechart);
         firstagelayout=view.findViewById(R.id.firstagelayout);
         barChartyear=view.findViewById(R.id.barchartofyear);
         layout=view.findViewById(R.id.piechartitem);
         totalyearwise=view.findViewById(R.id.totalyearwiase);
         textView=view.findViewById(R.id.Total_cases);
         horizontalScrollView=view.findViewById(R.id.horizontalScrollView);
         monthwisebarchart=view.findViewById(R.id.barchartyear);
         yearspinner=view.findViewById(R.id.yearspinner);
         stage_spinner=view.findViewById(R.id.stage_spinner);
         pieChart = view.findViewById(R.id.firstagespie);
        district_analyse = view.findViewById(R.id.district_analyse);
        Complaint_Modepiechart = view.findViewById(R.id.Complaint_Modepiechart);
        complaintmodelayout = view.findViewById(R.id.complaintmodelayout);
        fir_typespinner = view.findViewById(R.id.fir_typespinner);
        cmp_mode_spinner = view.findViewById(R.id.cmp_mode_spinner);
         dao = new DAO(getContext());
         district_analyse.setText("Get Data OF Districts");
        district_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                .beginTransaction()
                        .replace(R.id.fraglayot,new DistrictList())
                        .addToBackStack(null)
                        .commit();
            }
        });
            // Overallfirtypepie();
             setspinner(yearspinner);
             setspinner(fir_typespinner);
             setspinner(cmp_mode_spinner);
             setspinner(stage_spinner);
             setOnItemSelected();
             setyeatbarchart();
           return view;
    }

    private void setOnItemSelected() {
        stage_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedyear=adapterView.getItemAtPosition(i).toString();
              setfirstagespie(selectedyear);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

        fir_typespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (flag) {
                    setfirtypepiechart(parent.getItemAtPosition(position).toString());
                }else {
                   Overallfirtypepie();
                   flag=true;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      cmp_mode_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if (flag2) {
                  setComplaintPie(adapterView.getItemAtPosition(i).toString());
              }else {
                   setOverallComplaintmode();
                  flag2=true;
              }

          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });
    }

    private void setComplaintPie(String year) {
        HashMap <String,String>map=new HashMap<>();
        map.put("year",year);
        dao.getData(map, COM_MODE, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                //Toast.makeText(getContext(), "resposne "+object, Toast.LENGTH_SHORT).show();
                try {
                    ArrayList <PiechartModelclass>modelclasses=new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    String written = jsonObject.getString("Written");
                    String sueMotoByPolice = jsonObject.getString("Sue-moto by Police");
                    String judicialMagistrateReference = jsonObject.getString("Judicial/Magistrate reference");
                    String nullValue = jsonObject.getString("NULL");
                    String others = jsonObject.getString("Others");
                    String oral = jsonObject.getString("Oral");
                    String online = jsonObject.getString("Online");
                    String writtenAndOrganised = jsonObject.getString("Written & Organised");
                    String oralAndOrganised = jsonObject.getString("Oral & Organised");
                    String judicialMagistrateReferenceAndOrganised = jsonObject.getString("Judicial/Magistrate Reference & Organised");
                    String distressCallOverPhone = jsonObject.getString("Distress call over phone");

                     modelclasses.add(new PiechartModelclass("Written", Integer.valueOf(written), "#1f77b4"));
                    modelclasses.add(new PiechartModelclass("Sue-moto by Police", Integer.valueOf(sueMotoByPolice), "#ff7f0e"));
                    modelclasses.add(new PiechartModelclass("Judicial/Magistrate reference", Integer.valueOf(judicialMagistrateReference), "#2ca02c"));
                    modelclasses.add(new PiechartModelclass("NULL", Integer.valueOf(nullValue), "#d62728"));
                    modelclasses.add(new PiechartModelclass("Others", Integer.valueOf(others), "#9467bd"));
                    modelclasses.add( new PiechartModelclass("Oral", Integer.valueOf(oral), "#8c564b"));
                    modelclasses.add( new PiechartModelclass("Online", Integer.valueOf(online), "#e377c2"));
                    modelclasses.add( new PiechartModelclass("Written & Organised", Integer.valueOf(writtenAndOrganised), "#7f7f7f"));
                    modelclasses.add( new PiechartModelclass("Oral & Organised", Integer.valueOf(oralAndOrganised), "#bcbd22"));
                    modelclasses.add(new PiechartModelclass("Judicial/Magistrate Reference & Organised", Integer.valueOf(judicialMagistrateReferenceAndOrganised), "#17becf"));
                    modelclasses.add( new PiechartModelclass("Distress call over phone", Integer.valueOf(distressCallOverPhone), "#aec7e8"));
                    Piechartgraph piechartgraph = new Piechartgraph(modelclasses,complaintmodelayout);
                    piechartgraph.setpie(Complaint_Modepiechart);
                }catch (JSONException e){
                    Toast.makeText(getContext(), "Exception "+e, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setyeatbarchart() {
        ArrayList<BargraphModelclass>list1=new ArrayList<>();
        dao.getData(null, GETYEARCOUNTURL, new NewCallBack() {
            @Override
            public void onError(String error) {
               // Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
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
    private void setspinner(Spinner spinner) {
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
        spinner.setAdapter(adapter);
    }
    public void setbarchartbyyear(String year){
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

    private void setbargraphofmonthwiseyear(String totalcount, ArrayList<String> list1) {
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
      private void setfirstagespie(String year){
        HashMap<String,String>map=new HashMap<>();
        map.put("year",year);
        dao.getData(map, FIRSTAGESBYYEAR, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
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

                    ArrayList<PiechartModelclass>list2=new ArrayList<>();
                    list2.add(new PiechartModelclass("disAcq", Integer.valueOf(disAcq), "#1f77b4")); // blue
                    list2.add(new PiechartModelclass("convicted", Integer.valueOf(convicte), "#ff7f0e")); // orange
                    list2.add(new PiechartModelclass("pendingTrial", Integer.valueOf(pendingTrial), "#2ca02c")); // green
                    list2.add(new PiechartModelclass("boundOver", Integer.valueOf(boundOver), "#d62728")); // red
                    list2.add(new PiechartModelclass("otherDisposal", Integer.valueOf(otherDisposal), "#9467bd")); // purple
                    list2.add(new PiechartModelclass("traced", Integer.valueOf(traced), "#8c564b")); // brown
                    list2.add(new PiechartModelclass("falseCase", Integer.valueOf(falseCase), "#e377c2")); // pink
                    list2.add(new PiechartModelclass("underInvestigation", Integer.valueOf(underInvestigation), "#7f7f7f")); // gray
                    list2.add(new PiechartModelclass("abated", Integer.valueOf(abated), "#bcbd22")); // yellow-green
                    list2.add(new PiechartModelclass("undetected", Integer.valueOf(undetected), "#17becf")); // light blue
                    list2.add(new PiechartModelclass("compounded", Integer.valueOf(compounded), "#aec7e8")); // light purple
                    list2.add(new PiechartModelclass("unTraced", Integer.valueOf(unTraced), "#ffbb78")); // light orange
                    // list2.add(new PiechartModelclass("underInvestigation", Integer.valueOf( ), "#ff4500")); // orange-red

                    Piechartgraph piechartgraph=new Piechartgraph(list2,firstagelayout);
                    piechartgraph.setpie(firstagespie);
                }catch (JSONException e){
                    Toast.makeText(getContext(), "Jconvictedson Exception"+e, Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        },30000);
     }
     public void setfirtypepiechart(String string){
         if (firstagespie.getData().size()>1){
             firstagespie.clearChart();
         }
        HashMap<String,String>map=new HashMap<>();
        map.put("year",string);
        dao.getData(map, FIRTYPEYEARWISE, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
                String Heinous="",Non_Heinous="";
               try {
                   JSONObject jsonObject=new JSONObject(String.valueOf(object));
                   Non_Heinous= jsonObject.getString("Non Heinous");
                   Heinous=jsonObject.getString("Heinous");
                   ArrayList<PiechartModelclass>list2=new ArrayList<>();
                   list2.add(new PiechartModelclass("Heinous",Integer.valueOf(Non_Heinous),"#EF5350"));
                   list2.add(new PiechartModelclass("Non Heinous",Integer.valueOf(Heinous),"#66BB6A"));

                   Piechartgraph piechartgraph=new Piechartgraph(list2,firtypelayout);
                   piechartgraph.setpie(firtypepiechart);
               }catch (JSONException e){
                   Toast.makeText(getContext(), "Json Exception"+e, Toast.LENGTH_SHORT).show();
              }
            }
            @Override
            public void onEmpty() {

            }
        });
    }
    public void Overallfirtypepie(){
        dao.getData(null, OverllFirType, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                String Non_Heinous="";
                String Heinous="";
                try {
                    JSONObject jsonObject=new JSONObject(String.valueOf(object));
                       Non_Heinous= jsonObject.getString("Non Heinous");
                       Heinous= jsonObject.getString("Heinous");
                }catch (JSONException e)
                {
                    Toast.makeText(getContext(), "error"+e, Toast.LENGTH_SHORT).show();
                }
                ArrayList<PiechartModelclass>list2=new ArrayList<>();
                list2.add(new PiechartModelclass("Heinous",Integer.valueOf(Non_Heinous),"#ff7f0e"));
                list2.add(new PiechartModelclass("Non Heinous",Integer.valueOf(Heinous),"#1f77b4"));

                Piechartgraph piechartgraph=new Piechartgraph(list2,firtypelayout);
                piechartgraph.setpie(firtypepiechart);

            }

            @Override
            public void onEmpty() {

            }
        });
    }
    public void setOverallComplaintmode(){
        dao.getData(null, OverallComplaintmode, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {
                    ArrayList<PiechartModelclass> modelclasses = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    String written = jsonObject.getString("Written");
                    String sueMotoByPolice = jsonObject.getString("Sue-moto by Police");
                    String judicialMagistrateReference = jsonObject.getString("Judicial/Magistrate reference");
                    String nullValue = jsonObject.getString("NULL");
                    String others = jsonObject.getString("Others");
                    String oral = jsonObject.getString("Oral");
                    String online = jsonObject.getString("Online");
                    String writtenAndOrganised = jsonObject.getString("Written & Organised");
                    String oralAndOrganised = jsonObject.getString("Oral & Organised");
                    String judicialMagistrateReferenceAndOrganised = jsonObject.getString("Judicial/Magistrate Reference & Organised");
                    String distressCallOverPhone = jsonObject.getString("Distress call over phone");

                    modelclasses.add(new PiechartModelclass("Written", Integer.valueOf(written), "#1f77b4"));
                    modelclasses.add(new PiechartModelclass("Sue-moto by Police", Integer.valueOf(sueMotoByPolice), "#ff7f0e"));
                    modelclasses.add(new PiechartModelclass("Judicial/Magistrate reference", Integer.valueOf(judicialMagistrateReference), "#2ca02c"));
                    modelclasses.add(new PiechartModelclass("NULL", Integer.valueOf(nullValue), "#d62728"));
                    modelclasses.add(new PiechartModelclass("Others", Integer.valueOf(others), "#9467bd"));
                    modelclasses.add(new PiechartModelclass("Oral", Integer.valueOf(oral), "#8c564b"));
                    modelclasses.add(new PiechartModelclass("Online", Integer.valueOf(online), "#e377c2"));
                    modelclasses.add(new PiechartModelclass("Written & Organised", Integer.valueOf(writtenAndOrganised), "#7f7f7f"));
                    modelclasses.add(new PiechartModelclass("Oral & Organised", Integer.valueOf(oralAndOrganised), "#bcbd22"));
                    modelclasses.add(new PiechartModelclass("Judicial/Magistrate Reference & Organised", Integer.valueOf(judicialMagistrateReferenceAndOrganised), "#17becf"));
                    modelclasses.add(new PiechartModelclass("Distress call over phone", Integer.valueOf(distressCallOverPhone), "#aec7e8"));
                    Piechartgraph piechartgraph = new Piechartgraph(modelclasses, complaintmodelayout);
                    piechartgraph.setpie(Complaint_Modepiechart);

                } catch (JSONException e) {
                    Toast.makeText(getContext(), "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onEmpty() {

            }
        });
    }
}

