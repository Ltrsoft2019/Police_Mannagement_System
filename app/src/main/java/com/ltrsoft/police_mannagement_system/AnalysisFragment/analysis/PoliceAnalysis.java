package com.ltrsoft.police_mannagement_system.AnalysisFragment.analysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.FircardModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.PoliceFirAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PoliceAnalysis extends Fragment {
    public PoliceAnalysis() {}
    private RecyclerView recyclerView ;
    private String URL = "https://rj.ltr-soft.com/dataset_api/fir_tbl/assigned_fir_by_police.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.police_analysis, container, false);
        recyclerView = view.findViewById(R.id.police_firs);

        Bundle bundle =getArguments();
        HashMap <String,String>hashMap = new HashMap<>();
        hashMap.put("KGID",bundle.getString("KGID"));
        DAO dao = new DAO(getContext());
        dao.getData(hashMap, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(Object object) {
//                Toast.makeText(getContext(), "Resposne "+object, Toast.LENGTH_SHORT).show();
                ArrayList<FircardModel>models = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject fir = jsonArray.getJSONObject(i);
                        Gson gson = new Gson();
                        models.add(gson.fromJson(fir.toString(), FircardModel.class));
                    }
                    PoliceFirAdapter adapter = new PoliceFirAdapter(models);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}