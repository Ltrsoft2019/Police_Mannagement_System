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

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DyspFragment extends Fragment {
    private PieChart chart;
    private TextView male,female;
    public  String GET_PI="https://rj.ltr-soft.com/dataset_api/police/police_data.php";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
        Bundle bundle=getArguments();
        DAO dao = new DAO(getContext());

        HashMap<String,String> map = new HashMap<>();
        map.put("kgid","1827332");
        map.put("position","PI");
        dao.getData(map,GET_PI , new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {
                    ArrayList<PolicePosition> policePositions = new ArrayList<>();
                    JSONObject responseJson = new JSONObject(String.valueOf(object));
                    JSONArray districtsArray = responseJson.getJSONArray("districts");

                    for (int i = 0; i < districtsArray.length(); i++) {
                        JSONObject districtObject = districtsArray.getJSONObject(i);
                        String districtName = districtObject.getString("district_name");

                        JSONArray dySpArray = districtObject.getJSONArray("dy_sp");
                        Toast.makeText(getContext(), ""+dySpArray, Toast.LENGTH_SHORT).show();
                       System.out.println("Response "+dySpArray);

                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
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
