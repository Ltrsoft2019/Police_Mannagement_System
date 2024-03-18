package com.ltrsoft.police_mannagement_system.Fragment.analysis2;

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
import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DyspFragment extends Fragment {
    public DyspFragment() {
    }
    private PieChart chart;
    private TextView male,female;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);
        chart = view.findViewById(R.id.acp_piechart);
        male = view.findViewById(R.id.male_txt);
        female = view.findViewById(R.id.female_txt);


        com.ltrsoft.police_mannagement_system.Deo.DAO dao = new com.ltrsoft.police_mannagement_system.Deo.DAO(getContext());
        HashMap<String,String> map = new HashMap<>();
        map.put("position","ACP");
        dao.getData(map, com.ltrsoft.police_mannagement_system.Deo.URLS.GET_FIR_URL, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                try {
                    JSONObject jsonObject = new JSONObject(String.valueOf(object));
                }
                catch (JSONException e){

                }
            }

            @Override
            public void onEmpty() {

            }
        });

        return view;
    }
}
