package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.CyberCrimemodel;
import com.ltrsoft.police_mannagement_system.Model.Leave;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class CyberList extends Fragment {
    private RecyclerView cybers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        cybers = view.findViewById(R.id.assigncmp);
        setCyber();
        return view;
    }
    private void setCyber() {
        DAO dao = new DAO(getContext());
        dao.select(CyberCrimemodel.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();}
            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>> maps = new ArrayList<>();
                ArrayList<CyberCrimemodel>models= (ArrayList<CyberCrimemodel>) object;
                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                for(CyberCrimemodel model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "Cyber Crime Id :"+model.getCyber_crime_id());
                    map.put("map2","Description :"+ model.getDescription());
                    map.put("map3", "Where Does it occure :"+model.getWhere_accure());
                    map.put("map4", "Status :"+model.getStatus_id());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                cybers.setLayoutManager(layoutManager);
                cybers.setAdapter(adapter);
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "There is No Cyber Crime", Toast.LENGTH_SHORT).show();
            }
        },"https://rj.ltr-soft.com/public/police_api/assign_cyber_crime/cyber_crime_by_police.php");
    }
}
