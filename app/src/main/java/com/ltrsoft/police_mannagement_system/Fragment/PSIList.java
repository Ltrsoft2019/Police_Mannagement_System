package com.ltrsoft.police_mannagement_system.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.PoliceAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PSIList extends Fragment {

    public PSIList() {
    }
    RecyclerView recyclerView;
    private   String URL = "https://rj.ltr-soft.com/dataset_api/police/police_of_my_unit.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dy_sp_list, container, false);
        Bundle bundle=getArguments();
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar!=null){
            actionBar.setTitle("PSI List");
        }
        String KGID=bundle.getString("KGID");
        Toast.makeText(getContext(), "KGID="+KGID, Toast.LENGTH_SHORT).show();
        recyclerView = view.findViewById(R.id.dysp_list);
        DAO dao = new DAO(getContext());
        HashMap<String,String> map = new HashMap<>();
        map.put("KGID",KGID);
        map.put("position","PSI");

        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<PolicePosition> police =new ArrayList<>();
                try {
                    ArrayList<PolicePosition>policePositions=new ArrayList<>();
                    JSONObject maibObj = new JSONObject(String.valueOf(object));
                    JSONArray districts = maibObj.getJSONArray("unit_Name");
                    for (int i = 0; i < districts.length(); i++) {
                        JSONObject oneDistrict = districts.getJSONObject(i);
                        JSONObject disdetail = oneDistrict.getJSONObject("unit_Name");

                        String unit_name = disdetail.getString("UnitName");
                        JSONArray dysps = oneDistrict.getJSONArray("PSI");
                        for (int j = 0; j <dysps.length() ; j++) {
                            JSONObject oneDysp = dysps.getJSONObject(j);
                            police.add(new PolicePosition(oneDysp.getString("KGID"),
                                    oneDysp.getString("IOName"),
                                    "",
                                    "","",unit_name));
//                            Log.d("iteration", String.valueOf(j));
                        }
                    }
                    Toast.makeText(getContext(), "dysp list "+policePositions.size(), Toast.LENGTH_SHORT).show();
                    setRecycle(police);
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

    private void setRecycle(ArrayList<PolicePosition> police) {
        PoliceAdapter adapter = new PoliceAdapter(police,new PSIDashboard());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}