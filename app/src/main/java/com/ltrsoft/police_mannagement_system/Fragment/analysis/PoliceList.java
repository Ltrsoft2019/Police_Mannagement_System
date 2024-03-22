package com.ltrsoft.police_mannagement_system.Fragment.analysis;

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

public class PoliceList extends Fragment {
    private String URL = "https://rj.ltr-soft.com/dataset_api/police/all_police_by_unit_id.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fir_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fir_list_recycler);
        DAO dao = new DAO(getContext());
        Bundle bundle = getArguments();
        String unit_id = bundle.getString("Unit_Id");
        HashMap<String,String>map=new HashMap<>();
//        map.put("Unit_ID",unit_id);
        map.put("Unit_ID","1245");
        dao.getData(map, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
//                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                try {
                    ArrayList<PolicePosition>positions=new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    JSONArray data = jsonObject.getJSONArray("data");
                    for (int i = 0; i <data.length() ; i++) {
                        JSONObject jsonObject1 = data.getJSONObject(i);
                        String KGID = jsonObject1.getString("KGID");
                        String IOName = jsonObject1.getString("IOName");
                        String Internal_IO = jsonObject1.getString("Internal_IO");
                        PolicePosition policePosition = new PolicePosition(KGID,IOName,Internal_IO,"","","");
                        positions.add(policePosition);
                    }
                    PoliceAdapter adapter = new PoliceAdapter(positions,new PoliceAnalysis());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }catch (JSONException e){
                    Toast.makeText(getContext(), "Error "+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
