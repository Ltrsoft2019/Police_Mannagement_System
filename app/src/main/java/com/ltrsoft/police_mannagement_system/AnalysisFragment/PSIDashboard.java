package com.ltrsoft.police_mannagement_system.AnalysisFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.GettingFirRecycler;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PSIDashboard extends Fragment {
    private PieChart chart;
    private TextView total;
    LinearLayout layout;
    TextView io_name ;
    private RecyclerView recyclerView;
    private   String URL = "https://rj.ltr-soft.com/dataset_api/police/police_of_my_unit.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
        layout=view.findViewById(R.id.linearlayout);
        recyclerView=view.findViewById(R.id.acp_fir);
//        total=view.findViewById(R.id.total);
        io_name=view.findViewById(R.id.io_name);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar!=null){
            actionBar.setTitle("PSI dashboard");
        }

        Bundle bundle=getArguments();
        String KGID=bundle.getString("KGID");
        String IONAME=bundle.getString("IONAME");
        io_name.setText("PSI name :"+IONAME);
        Toast.makeText(getContext(), "KGID="+KGID, Toast.LENGTH_SHORT).show();
        DAO dao = new DAO(getContext());
        HashMap<String,String> map = new HashMap<>();
        map.put("KGID",KGID);
//        map.put("position","HC");
        GettingFirRecycler gettingFirRecycler=new GettingFirRecycler(recyclerView,KGID);
        gettingFirRecycler.setrecyclerview();
        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                int femaleCnt=0;
                ArrayList<PolicePosition> police =new ArrayList<>();
                try {
                    JSONObject maibObj = new JSONObject(String.valueOf(object));
                    JSONArray districts = maibObj.getJSONArray("unit_Name");
                    for (int i = 0; i < districts.length(); i++) {
                        JSONObject oneDistrict = districts.getJSONObject(i);
                        JSONObject disdetail = oneDistrict.getJSONObject("unit_Name");

                        String unit_name = disdetail.getString("UnitName");
                        JSONObject total = disdetail.getJSONObject("total");
                        femaleCnt+=Integer.parseInt(total.getString("female"));

                        JSONArray dysps = oneDistrict.getJSONArray("HC");
                        for (int j = 0; j <dysps.length() ; j++) {
                            JSONObject oneDysp = dysps.getJSONObject(j);
                            police.add(new PolicePosition(oneDysp.getString("KGID"),
                                    oneDysp.getString("IOName"),
                                    "",
                                    "","",unit_name));
//                            Log.d("iteration", String.valueOf(j));
                        }
                    }
                    Toast.makeText(getContext(), "dysp list "+police.size(), Toast.LENGTH_SHORT).show();
                    setPieChart(police,femaleCnt);
                }
                catch (JSONException e){
                    System.out.println("JSON Error "+e.toString());
                    Toast.makeText(getContext(), "JSON ERROR "+e.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("JSONERROR",e.toString());
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

                ConstableList dySpLis = new ConstableList();
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
    private void setPieChart(ArrayList<PolicePosition> policePositions, int femaleCnt) {
        ArrayList<PiechartModelclass>modelclasses=new ArrayList<>();
        modelclasses.add(new PiechartModelclass("Male",(1+ policePositions.size()), "#00B2E2"));
        modelclasses.add(new PiechartModelclass("FeMale",femaleCnt, "#FCAE1E"));
        Piechartgraph piechartgraph = new Piechartgraph(modelclasses,layout);
        piechartgraph.setpie(chart);
    }
}
