package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Complaint;
import com.ltrsoft.police_mannagement_system.Model.Criminal;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class CriminalList extends Fragment {
    private RecyclerView criminals;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        criminals = view.findViewById(R.id.assigncmp);
        setCriminals();
        return view;
    }
    private void setCriminals() {
        DAO dao = new DAO(getContext());
        dao.select(Criminal.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>> maps = new ArrayList<>();
                ArrayList<Criminal>models= (ArrayList<Criminal>) object;
                for(Criminal model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "Criminal Id :"+model.getId());
                    map.put("map2","Ciminal Full Name :"+ model.getFullName());
                    map.put("map3", "Criminal Address :"+model.getHomeAddress());
                    map.put("map4", "Gender :"+model.getGender());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                criminals.setLayoutManager(layoutManager);
                criminals.setAdapter(adapter);
            }
            @Override
            public void onEmpty() {

            }
        },"https://rj.ltr-soft.com/public/police_api/criminals/all_criminal.php");
    }
}
