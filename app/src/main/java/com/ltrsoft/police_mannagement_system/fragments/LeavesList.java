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
import com.ltrsoft.police_mannagement_system.Model.Leave;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class LeavesList extends Fragment {
    private RecyclerView leaves;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
//        Toast.makeText(getContext(), "on leaves", Toast.LENGTH_SHORT).show();
        leaves = view.findViewById(R.id.assigncmp);
        setLeaves();
        return view;
    }
    private void setLeaves() {
        DAO dao = new DAO(getContext());
        dao.select(Leave.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>>maps = new ArrayList<>();
                ArrayList<Leave>models= (ArrayList<Leave>) object;
                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                for(Leave model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "Leave Id :"+model.getLeaveId());
                    map.put("map2","Reason :"+ model.getReason());
                    map.put("map3", "Duration :"+model.getDuration());
                    map.put("map4", "Leave Type :"+model.getTypeOfLeave());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                leaves.setLayoutManager(layoutManager);
                leaves.setAdapter(adapter);
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "You dont have any Levaes in History", Toast.LENGTH_SHORT).show();
            }
        },"https://rj.ltr-soft.com/public/police_api/leaves/police_leaves.php");
    }
}
