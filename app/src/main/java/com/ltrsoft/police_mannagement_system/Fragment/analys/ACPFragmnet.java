package com.ltrsoft.police_mannagement_system.Fragment.analys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ACPFragmnet extends Fragment {
    public ACPFragmnet() {}
    private PieChart chart;
    private TextView total;
    LinearLayout layout;
    private static final String URL = "https://rj.ltr-soft.com/dataset_api/police/dysp_list.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
       layout=view.findViewById(R.id.linearlayout);
       total=view.findViewById(R.id.total);


        Bundle bundle=getArguments();
        String KGID=bundle.getString("KGID");
        Toast.makeText(getContext(), "KGID="+KGID, Toast.LENGTH_SHORT).show();
        DAO dao = new DAO(getContext());
        HashMap<String,String>map = new HashMap<>();
        map.put("KGIDx",KGID);
        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
              try {
                  ArrayList<PolicePosition>policePositions=new ArrayList<>();
                  JSONObject jsonObject = new JSONObject(String.valueOf(object));
                  JSONArray jsonArray = jsonObject.getJSONArray("districts");
                  for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                      JSONArray jsonArray1 = jsonObject1.getJSONArray("dy_sp");
                      for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
                        policePositions.add(new PolicePosition(jsonObject2.getString("IOName"),
                                jsonObject2.getString("KGID"),"",
                                jsonObject1.getString("district_name")
                                ,jsonObject1.getString("Unit_ID")
                                ,jsonObject1.getString("UnitName")));
                           total.setText("Total Dysp = "+policePositions.size());
                      }
                  }
//                  Toast.makeText(getContext(), "size "+policePositions.size(), Toast.LENGTH_SHORT).show();
                  setPieChart(policePositions);
              }
              catch (JSONException e){
                  System.out.println("JSON Error "+e.toString());
                  Toast.makeText(getContext(), "JSON ERROR "+e.toString(), Toast.LENGTH_SHORT).show();
              }

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "on empty", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setPieChart(ArrayList<PolicePosition> policePositions) {
        ArrayList<PiechartModelclass>modelclasses=new ArrayList<>();
        modelclasses.add(new PiechartModelclass("Male",(1+ policePositions.size()), "#00B2E2"));
        Piechartgraph piechartgraph = new Piechartgraph(modelclasses,layout);
        piechartgraph.setpie(chart);
    }
}
