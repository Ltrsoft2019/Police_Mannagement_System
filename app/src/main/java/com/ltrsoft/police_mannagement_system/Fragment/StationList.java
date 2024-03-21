package com.ltrsoft.police_mannagement_system.Fragment;

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
import com.ltrsoft.police_mannagement_system.Model.Stationmodel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.DistrictAdapter;
import com.ltrsoft.police_mannagement_system.adapters.StationAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class StationList extends Fragment {
    public StationList() {
    }

    private String URL ="https://rj.ltr-soft.com/dataset_api/station/readby_district.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fir_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fir_list_recycler);
        DAO dao = new DAO(getContext());
        HashMap<String,String>map=new HashMap<>();
        map.put("District_Name","Bagalkot");
        dao.select(Stationmodel.class,"District_Name","Bagalkot",new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {

                ArrayList<Stationmodel> list= (ArrayList<Stationmodel>) object;
                StationAdapter adapter = new StationAdapter(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty ", Toast.LENGTH_SHORT).show();

            }
        },URL);
    return view;
    }
}
