package com.ltrsoft.police_mannagement_system.AnalysisFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.FircardModel;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.GettingFirRecycler;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.adapters.PoliceFirAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ACPDash extends Fragment {
    public ACPDash() {}
    private PieChart chart;
    private TextView total;
    RecyclerView recyclerView;
    LinearLayout layout;
    private String KGID;
    private TextView io_name;
    private String GETFIR="https://rj.ltr-soft.com/dataset_api/fir_tbl/assigned_fir_by_police.php";
    private   String URL = "https://rj.ltr-soft.com/dataset_api/police/police_data.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle("ACP analysis");
        }
        recyclerView=view.findViewById(R.id.acp_fir);
       layout=view.findViewById(R.id.linearlayout);
//       total=view.findViewById(R.id.total);
        io_name = view.findViewById(R.id.io_name);
         Bundle bundle=getArguments();
          KGID=bundle.getString("KGID");
        String IONAME=bundle.getString("IONAME");
        io_name.setText("ACP NAME : "+IONAME);
//        Toast.makeText(getContext(), "KGID="+KGID, Toast.LENGTH_SHORT).show();
        //setrecycler();
        GettingFirRecycler gettingFirRecycler=new GettingFirRecycler(recyclerView,KGID);
        gettingFirRecycler.setrecyclerview();

        DAO dao = new DAO(getContext());
        HashMap<String,String>map = new HashMap<>();
        map.put("KGID",KGID);
        map.put("position","Dy.Sp");

        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<PolicePosition>police =new ArrayList<>();
              try {
                  ArrayList<PolicePosition>policePositions=new ArrayList<>();
                  JSONObject maibObj = new JSONObject(String.valueOf(object));
                    JSONArray districts = maibObj.getJSONArray("districts");
                  for (int i = 0; i < districts.length(); i++) {
                      JSONObject oneDistrict = districts.getJSONObject(i);
                        JSONObject disdetail = oneDistrict.getJSONObject("district_name");
                        String disname = disdetail.getString("District_Name");
                        JSONArray dysps = oneDistrict.getJSONArray("Dy.Sp");
                            for (int j = 0; j <dysps.length() ; j++) {
                                JSONObject oneDysp = dysps.getJSONObject(j);
                                police.add(new PolicePosition(oneDysp.getString("KGID"),
                                        oneDysp.getString("IOName"),
                                        "",
                                       disname,"",""));
//                                Log.d("iteration", String.valueOf(j));
                            }
                  }
                  Toast.makeText(getContext(), "dysp list "+policePositions.size(), Toast.LENGTH_SHORT).show();
                  setPieChart(police);
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
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DySpLis dySpLis = new DySpLis();
                Bundle bundle=new Bundle();
                bundle.putString("KGID",KGID);

                dySpLis.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fraglayot, dySpLis)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }


    private void setPieChart(ArrayList<PolicePosition> policePositions) {
        ArrayList<PiechartModelclass>modelclasses=new ArrayList<>();
        modelclasses.add(new PiechartModelclass("Male",(1+ policePositions.size()), "#FFF424"));
        Piechartgraph piechartgraph = new Piechartgraph(modelclasses,layout);
        piechartgraph.setpie(chart);
    }
    private void setrecycler() {
      DAO dao=new DAO(getContext());
        HashMap<String,String>map = new HashMap<>();
        map.put("KGID",KGID);
        dao.select(FircardModel.class, "KGID", KGID, new NewCallBack() {
            @Override
            public void onError(String error) {
                              Toast.makeText(getContext(), "error = "+error, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<FircardModel>list= (ArrayList<FircardModel>) object;
                PoliceFirAdapter policeFirAdapter=new PoliceFirAdapter(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(policeFirAdapter);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Its empty Dude", Toast.LENGTH_SHORT).show();

            }
        },GETFIR);

    }

}
