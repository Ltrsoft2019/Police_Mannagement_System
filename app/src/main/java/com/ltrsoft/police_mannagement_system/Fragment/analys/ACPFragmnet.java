package com.ltrsoft.police_mannagement_system.Fragment.analys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.Deo.DAO;
import com.ltrsoft.police_mannagement_system.Deo.URLS;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class ACPFragmnet extends Fragment {
    public ACPFragmnet() {}
    private PieChart chart;
    private TextView male,female;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
        male = view.findViewById(R.id.male_txt);
        female = view.findViewById(R.id.female_txt);
        Bundle bundle=getArguments();
        String KGID=bundle.getString("KGID");
        Toast.makeText(getContext(), "KGID="+KGID, Toast.LENGTH_SHORT).show();
        DAO dao = new DAO(getContext());
        HashMap<String,String>map = new HashMap<>();
        map.put("kgid","1827332");
        dao.getData(map, URLS.GET_POLICE, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {
                    ArrayList<PolicePosition>policePositions=new ArrayList<>();
                    JSONArray jsonArray = new JSONArray(String.valueOf(object));



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
