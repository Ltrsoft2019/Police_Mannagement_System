package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.GridAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.utils.ActionBarTitle;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class AllotedTask extends Fragment {
    private RecyclerView alloted_task;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alloted_tasks, container, false);
        ArrayList<String>list=new ArrayList<>();
        alloted_task=view.findViewById(R.id.alloted_task);
        ActionBarTitle.setTiltle("Alloted Task", (AppCompatActivity) getActivity());
        DAO dao = new DAO(getContext());
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("police_id","1");
        dao.getData(hashMap, "https://rj.ltr-soft.com/public/police_api/assigned_tasks/police_id_tasks.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                if (!String.valueOf(object).isEmpty()) {
                    try {
                        JSONArray jsonArray = new JSONArray(String.valueOf(object));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            list.add(jsonArray.getJSONObject(0).getString("task_name"));
                        }
                        GridAdapter adapter = new GridAdapter(list);
                        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
                        alloted_task.setLayoutManager(layoutManager);
                        alloted_task.setAdapter(adapter);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onEmpty() {

            }
        });
        return view;
    }
}