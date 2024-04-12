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
import com.ltrsoft.police_mannagement_system.Model.Warrant;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class WarrentList extends Fragment {
    private RecyclerView assigncmp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        assigncmp = view.findViewById(R.id.assigncmp);
        setComplaints();
        return view;
    }

    private void setComplaints() {
        DAO dao = new DAO(getContext());
        dao.select(Warrant.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
//                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                ArrayList<HashMap<String, String>> maps = new ArrayList<>();
                ArrayList<Warrant> models = (ArrayList<Warrant>) object;
                for (Warrant model : models) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("map1", model.getWarrantId());
                    map.put("map2", model.getWarrantNumber());
                    map.put("map3", model.getTypeOfWarrant());
                    map.put("map4", model.getPreviousWarrantsHistory());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps, R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                assigncmp.setLayoutManager(layoutManager);
                assigncmp.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {

            }
        },"https://rj.ltr-soft.com/public/police_api/assigned_warrants/by_police_id.php");
    }
}
