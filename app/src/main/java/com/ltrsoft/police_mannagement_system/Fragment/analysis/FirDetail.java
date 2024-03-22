package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FirDetail extends Fragment {
    public FirDetail() {}
    private PieChart pieChart;
    private TextView FIRNo, Internal_IO, unit_name, Offence_From_Date, Offence_To_Date, FIR_Type, FIR_Stage, Complaint_Mode, CrimeGroup_Name, CrimeHead, ActSection, IOName, Place_of_Offence, Beat_Name, Village_Area_Name, Unit_ID;

    private View view;
    String FIR_ID;
    String Unit_IDs;
     private BarChart barChart;
     private LinearLayout layout;
    private String URL="https://rj.ltr-soft.com/dataset_api/fir_tbl/fir_by_id_and_station.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fir_detail, container, false);
        pieChart = view.findViewById(R.id.acp_piechart);
        layout=view.findViewById(R.id.linearlayout);
        barChart = view.findViewById(R.id.detail_fir_barchart);
         FIRNo = view.findViewById(R.id.FIRNo);
        Internal_IO = view.findViewById(R.id.Internal_IO);
        unit_name = view.findViewById(R.id.unit_name);
        Offence_From_Date = view.findViewById(R.id.Offence_From_Date);
        Offence_To_Date = view.findViewById(R.id.Offence_To_Date);
        FIR_Type = view.findViewById(R.id.FIR_Type);
        FIR_Stage = view.findViewById(R.id.FIR_Stage);
        Complaint_Mode = view.findViewById(R.id.Complaint_Mode);
        CrimeGroup_Name = view.findViewById(R.id.CrimeGroup_Name);
        CrimeHead = view.findViewById(R.id.CrimeHead);
        ActSection = view.findViewById(R.id.ActSection);
        IOName = view.findViewById(R.id.IOName);
        Place_of_Offence = view.findViewById(R.id.Place_of_Offence);
        Beat_Name = view.findViewById(R.id.Beat_Name);
        Village_Area_Name = view.findViewById(R.id.Village_Area_Name);
        Unit_ID = view.findViewById(R.id.Unit_ID);

        Bundle bundle=getArguments();
        FIR_ID= bundle.getString("FIR_ID");
        Unit_IDs = bundle.getString("Unit_ID");
         getdata();
         return view;
    }
    public void getdata (){
        DAO dao=new DAO(getContext());
        HashMap<String,String>map=new HashMap<>();
        map.put("Unit_ID",Unit_IDs);
        map.put("FIR_ID",FIR_ID);
        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {
                    JSONArray jsonArray = new JSONArray(String.valueOf(object));
                    System.out.println(jsonArray);
                    //Toast.makeText(getContext(), ""+jsonArray, Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        FirModel model = new FirModel();
                        model.setId(jsonObject.optString("id"));
                        model.setDistrict_Name(jsonObject.optString("District_Name"));
                        model.setUnitName(jsonObject.optString("UnitName"));
                        model.setFIRNo(jsonObject.optString("FIRNo"));
                        model.setRI(jsonObject.optString("RI"));
                        model.setYear(jsonObject.optString("Year"));
                        model.setMonth(jsonObject.optString("Month"));
                        model.setOffence_From_Date(jsonObject.optString("Offence_From_Date"));
                        model.setOffence_To_Date(jsonObject.optString("Offence_To_Date"));
                        model.setFIR_Reg_DateTime(jsonObject.optString("FIR_Reg_DateTime"));
                        model.setFIR_Date(jsonObject.optString("FIR_Date"));
                        model.setFIR_Type(jsonObject.optString("FIR_Type"));
                        model.setFIR_Stage(jsonObject.optString("FIR_Stage"));
                        model.setComplaint_Mode(jsonObject.optString("Complaint_Mode"));
                        model.setCrimeGroup_Name(jsonObject.optString("CrimeGroup_Name"));
                        model.setCrimeHead_Name(jsonObject.optString("CrimeHead_Name"));
                        model.setLatitude(jsonObject.optString("Latitude"));
                        model.setLongitude(jsonObject.optString("Longitude"));
                        model.setActSection(jsonObject.optString("ActSection"));
                        model.setIOName(jsonObject.optString("IOName"));
                        model.setKGID(jsonObject.optString("KGID"));
                        model.setIOAssigned_Date(jsonObject.optString("IOAssigned_Date"));
                        model.setInternal_IO(jsonObject.optString("Internal_IO"));
                        model.setPlace_of_Offence(jsonObject.optString("Place_of_Offence"));
                        model.setDistance_from_PS(jsonObject.optString("Distance_from_PS"));
                        model.setBeat_Name(jsonObject.optString("Beat_Name"));
                        model.setVillage_Area_Name(jsonObject.optString("Village_Area_Name"));
                        model.setMale(jsonObject.optString("Male"));
                        model.setFemale(jsonObject.optString("Female"));
                        model.setBoy(jsonObject.optString("Boy"));
                        model.setGirl(jsonObject.optString("Girl"));
                        model.setAge_0(jsonObject.optString("Age_0"));
                        model.setVICTIM_COUNT(jsonObject.optString("VICTIM_COUNT"));
                        model.setAccused_Count(jsonObject.optString("Accused_Count"));
                        model.setArrested_Male(jsonObject.optString("Arrested_Male"));
                        model.setArrested_Female(jsonObject.optString("Arrested_Female"));
                        model.setArrested_Count(jsonObject.optString("Arrested_Count"));
                        model.setAccused_ChargeSheeted_Count(jsonObject.optString("Accused_ChargeSheeted_Count"));
                        model.setConviction_Count(jsonObject.optString("Conviction_Count"));
                        model.setFIR_ID(jsonObject.optString("FIR_ID"));
                        model.setUnit_ID(jsonObject.optString("Unit_ID"));
                        model.setCrime_No(jsonObject.optString("Crime_No"));

                        FIRNo.setText("FIR No : "+(model.getFIRNo()));
                        Internal_IO.setText("Internal IO: " + model.getInternal_IO());
                        unit_name.setText("Unit Name: " + model.getUnitName());
                        Offence_From_Date.setText("Offence From Date: " + model.getOffence_From_Date());
                        Offence_To_Date.setText("Offence To Date: " + model.getOffence_To_Date());
                        FIR_Type.setText("FIR Type: " + model.getFIR_Type());
                        FIR_Stage.setText("FIR Stage: " + model.getFIR_Stage());
                        Complaint_Mode.setText("Complaint Mode: " + model.getComplaint_Mode());
                        CrimeGroup_Name.setText("CrimeGroup Name: " + model.getCrimeGroup_Name());
                        CrimeHead.setText("Crime Head: " + model.getCrimeHead_Name());
                        ActSection.setText("ActSection: " + model.getActSection());
                        IOName.setText("IOName: " + model.getIOName());
                        Place_of_Offence.setText("Place of Offence: " + model.getPlace_of_Offence());
                        Beat_Name.setText("Beat Name: " + model.getBeat_Name());
                        Village_Area_Name.setText("Village Area Name: " + model.getVillage_Area_Name());
                        Unit_ID.setText("Unit ID: " + model.getUnit_ID());
                        setBarChart(model);
                        setPieChart(model);
                     }
                }
                catch (JSONException e){
                    System.out.println("error "+e);
                }
            }

            @Override
            public void onEmpty() {

            }
        });

    }
    public void  setBarChart(FirModel model){
        ArrayList<BargraphModelclass>list=new ArrayList<>();
        Float VICTIM_COUNT,Accused_Count,Arrested_Count,Conviction_Count,Accused_ChargeSheeted_Count;

          Accused_Count = (float)Integer.valueOf(model.getAccused_Count());
        Conviction_Count= Float.valueOf(model.getConviction_Count());
        Arrested_Count= Float.valueOf(model.getArrested_Count());
        VICTIM_COUNT= Float.valueOf(model.getVICTIM_COUNT());

      list.add(new BargraphModelclass("VICTIM", VICTIM_COUNT,"#66BB6A"));
    list.add(new BargraphModelclass("Accused", Accused_Count,"#EF5350"));
      list.add(new BargraphModelclass("Arrested", Arrested_Count,"#FFA726"));
      list.add(new BargraphModelclass("Convicted", Conviction_Count,"#00B2E2 "));
        Bargraphchart bargraphchart=new Bargraphchart(list);
      // bargraphchart.setbargraph(barChart);

    }
    public void setPieChart(FirModel model){
        Integer Male= Integer.valueOf(model.getMale());
        Integer Female= Integer.valueOf(model.getFemale());
        Integer BOY= Integer.valueOf(model.getBoy());
        Integer Girl= Integer.valueOf(model.getGirl());
      ArrayList<PiechartModelclass> list=new ArrayList<>();
      list.add(new PiechartModelclass("Male",Male,"#FFA726"));
      list.add(new PiechartModelclass("Female",Female,"#EF5350"));
      list.add(new PiechartModelclass("BOY",BOY,"#66BB6A"));
      list.add(new PiechartModelclass("Girl",Girl,"#00B2E2"));
        Piechartgraph piechartgraph=new Piechartgraph(list,layout);
        piechartgraph.setpie(pieChart);

    }

}