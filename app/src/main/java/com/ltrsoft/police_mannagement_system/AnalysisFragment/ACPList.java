package com.ltrsoft.police_mannagement_system.AnalysisFragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.PoliceAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
public class ACPList extends Fragment {
    public ACPList() {}
    private RecyclerView recyclerView;
    private TextView io_name;
    public  String GET_ACP_LIST = "https://rj.ltr-soft.com/dataset_api/police/police_by_position.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.total_a_c_p, container, false);

        recyclerView=view.findViewById(R.id.acp_list);
        DAO dao = new DAO(getContext());
        HashMap<String,String> map = new HashMap<>();
        map.put("position","ACP");
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar!=null){
            actionBar.setTitle("Total ACP");
        }

        dao.getData(map,GET_ACP_LIST , new NewCallBack() {
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

                    PoliceAdapter adapter = new PoliceAdapter(policePositions,new ACPDash());
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