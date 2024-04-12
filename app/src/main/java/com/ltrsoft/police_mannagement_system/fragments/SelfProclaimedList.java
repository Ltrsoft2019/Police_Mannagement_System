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
import com.ltrsoft.police_mannagement_system.Model.SelfProblem;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class SelfProclaimedList extends Fragment {
    private RecyclerView self;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        self = view.findViewById(R.id.assigncmp);
        setSelf();
        return view;
    }
    private void setSelf() {
        DAO dao = new DAO(getContext());
        dao.select(SelfProblem.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>> maps = new ArrayList<>();
                ArrayList<SelfProblem>models= (ArrayList<SelfProblem>) object;
                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                for(SelfProblem model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "EOW Id :"+model.getSelfProblemId());
                    map.put("map2","Additional Information :"+ model.getAdditionalInformation());
                    map.put("map3", "Offender Officer :"+model.getDateOfDeclarationAsProclaimedOffender());
                    map.put("map4", "Address :"+model.getAddress());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                self.setLayoutManager(layoutManager);
                self.setAdapter(adapter);
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "You dont have any Levaes in History", Toast.LENGTH_SHORT).show();
            }
        },"https://rj.ltr-soft.com/public/police_api/self_proclaimed_offenders/readall_self_proclaimed_offenders.php");
    }
}
