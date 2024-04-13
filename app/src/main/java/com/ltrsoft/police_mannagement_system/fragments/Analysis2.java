package com.ltrsoft.police_mannagement_system.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.Uigraph.Fourbargraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis2 extends Fragment {
    public Analysis2() {}
    private BarChart barChart;
    private TextView resposneTime,case_clearance;
    DAO dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.analysis2, container, false);
       barChart=view.findViewById(R.id.barchart);
       resposneTime = view.findViewById(R.id.resposne);
       case_clearance = view.findViewById(R.id.clearance);
       dao = new DAO(getContext());
       setResponseTime();
       setBarchart();
        return view;
    }

    private void setBarchart() {
        ArrayList<BarEntry> barEntries1 = new ArrayList<>();
        // Create an ArrayList to hold BarEntry objects for the second bar
        ArrayList<BarEntry> barEntries2 = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            barEntries1.add(new BarEntry(i, (float) (Math.random() * 100)));
            barEntries2.add(new BarEntry(i, (float) (Math.random() * 100)));
        }

        BarDataSet barDataSet1 = new BarDataSet(barEntries1, "Response Time");
        BarDataSet barDataSet2 = new BarDataSet(barEntries2, "Case Clearance Time");

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

        BarData barData = new BarData(dataSets);
        barDataSet1.setColor(Color.parseColor("#FFF424"));
        barDataSet2.setColor(Color.parseColor("#FBB03B"));
        barChart.setData(barData);
        barChart.invalidate();
    }

    private void setResponseTime() {
        dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/station_count/case_clearance_time.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                try {
                    JSONArray jsonArray = new JSONArray(String.valueOf(object));
                    int clearance_time=0;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        clearance_time+=Integer.parseInt(jsonObject.getString("time_difference"));
                    }
                    case_clearance.setText(String.valueOf(clearance_time/jsonArray.length()));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onEmpty() {

            }
        });
    }
}