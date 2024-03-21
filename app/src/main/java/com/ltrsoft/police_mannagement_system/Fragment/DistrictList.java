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
import com.ltrsoft.police_mannagement_system.Model.District;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.DistrictAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DistrictList extends Fragment {
    private String URL = "https://rj.ltr-soft.com/dataset_api/district/unique_district.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fir_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fir_list_recycler);
        DAO dao = new DAO(getContext());
        dao.getData(null, URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<String>list=new ArrayList<>();
                try {
                    JSONArray districts = new JSONArray(String.valueOf(object));
                    for (int i = 0; i < districts.length(); i++) {
                        JSONObject jsonObject1 = districts.getJSONObject(i);
                        list.add(jsonObject1.getString("District_Name"));
                    }
                    DistrictAdapter adapter = new DistrictAdapter(list);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }catch (JSONException e){

                }

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty ", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
