package com.ltrsoft.police_mannagement_system.Fragment.analys;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltrsoft.police_mannagement_system.Deo.DAO;
import com.ltrsoft.police_mannagement_system.Deo.URLS;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.PoliceAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
public class TotalACP extends Fragment {
    public TotalACP() {}
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.total_a_c_p, container, false);
        recyclerView=view.findViewById(R.id.acp_list);
        DAO dao = new DAO(getContext());
        HashMap<String,String> map = new HashMap<>();
        map.put("position","ACP");
        dao.getData(map, URLS.GET_ACP_LIST, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {

                    ArrayList<PolicePosition> policePositions=new ArrayList<>();
                    JSONArray jsonArray = new JSONArray(String.valueOf(object));

                    for (int i = 0; i <jsonArray.length() ; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Gson gson = new Gson();
                        PolicePosition policePosition = gson.fromJson(jsonObject.toString(), PolicePosition.class);
                        policePositions.add(policePosition);
                    }

                    PoliceAdapter adapter = new PoliceAdapter(policePositions);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);

                }
                catch (JSONException e){
                    System.out.println("error "+e.toString());
                }
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "on empty", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}