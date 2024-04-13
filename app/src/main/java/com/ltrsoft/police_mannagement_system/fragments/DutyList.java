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
import com.ltrsoft.police_mannagement_system.Model.Duty;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class DutyList extends Fragment {
    private RecyclerView duties;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        duties = view.findViewById(R.id.assigncmp);
        setDuty();
        return view;
    }
    private void setDuty() {
        DAO dao = new DAO(getContext());
        dao.select(Duty.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {

            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String, String>> maps = new ArrayList<>();
                ArrayList<Duty> models = (ArrayList<Duty>) object;
                for (Duty model : models) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("map1","Duty id :"+ model.getDutyId());
                    map.put("map2", "Area Name :"+model.getAreaName());
                    map.put("map3", "Date :"+model.getStartDate());
                    map.put("map4","Start Date :"+ model.getStartTime());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps, R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                duties.setLayoutManager(layoutManager);
                duties.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {      }
        }, "https://rj.ltr-soft.com/public/police_api/duty_assign/police_duty_assign.php");
    }
}
