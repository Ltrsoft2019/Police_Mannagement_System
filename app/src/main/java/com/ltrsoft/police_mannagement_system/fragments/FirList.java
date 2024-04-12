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
import com.ltrsoft.police_mannagement_system.Model.Complaint;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class FirList extends Fragment {
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        recyclerView = view.findViewById(R.id.assigncmp);
        setComplaints();
        return view;
    }
    private void setComplaints() {
            DAO dao = new DAO(getContext());
            dao.select(Complaint.class, "police_id", "1", new NewCallBack() {
                @Override
                public void onError(String error) {

                }

                @Override
                public void onSuccess(Object object) {
                    ArrayList<HashMap<String, String>> maps = new ArrayList<>();
                    ArrayList<Complaint> models = (ArrayList<Complaint>) object;
                    for (Complaint model : models) {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("map1", "Complaint Id :"+model.getComplaint_id());
                        map.put("map2","Complaint Subject :"+ model.getComplaint_subject());
                        map.put("map3", "Complaint Description :"+model.getComplaint_description());
                        map.put("map4", "Incident Date :"+model.getIncident_date());
                        maps.add(map);
                    }
                    CommonAdapter adapter = new CommonAdapter(maps, R.drawable.complaint);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onEmpty() {

                }
            }, "https://rj.ltr-soft.com/public/police_api/assign_complaints/police_id_complaints.php");
    }
}
