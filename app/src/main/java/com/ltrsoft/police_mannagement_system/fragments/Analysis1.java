package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.PieChart;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis1 extends Fragment {
    public Analysis1() {}
    private PieChart piecharts;
    private TextView totalAllotedComplaintsTextView;
    private TextView totalSolvedComplaintsTextView;
    private TextView totalFirTextView;
    private TextView totalInvestigationTextView;
    private TextView totalSolvedNumberTextView;
    private TextView totalFirNumberTextView;
    private TextView totalInvestigationNumberTextView;
    private DAO dao ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.main_analysis, container, false);
        dao = new DAO(getContext());
        totalAllotedComplaintsTextView = view.findViewById(R.id.total_number);
        totalSolvedComplaintsTextView = view.findViewById(R.id.total_solved_complaints);
        totalFirTextView = view.findViewById(R.id.total_Fir);
        totalInvestigationTextView = view.findViewById(R.id.total_investigsation);
        totalSolvedNumberTextView = view.findViewById(R.id.total_solved_number);
        totalFirNumberTextView = view.findViewById(R.id.total_fir);
        totalInvestigationNumberTextView = view.findViewById(R.id.total_investigation_number);
        piecharts=view.findViewById(R.id.piecharts);
        HashMap<String,String>map = new HashMap<>();
        map.put("police_id","1");
        setTotal(map);
        setSolved(map);
        return view;
    }

    private void setPie(PieChart piecharts) {
        ArrayList<PiechartModelclass>arrayList=new ArrayList<>();
        arrayList.add(new PiechartModelclass("Solved",Integer.parseInt(totalSolvedNumberTextView.getText().toString()),"#FBB03B"));
        arrayList.add(new PiechartModelclass("Converted To Fir",Integer.parseInt(totalFirNumberTextView.getText().toString()),"#FBB03B"));
        arrayList.add(new PiechartModelclass("Ongoing",Integer.parseInt(totalInvestigationNumberTextView.getText().toString()),"#FBB03B"));
        Piechartgraph piechartgraph = new Piechartgraph(arrayList,getContext());
        piechartgraph.setpiewithoutcard(piecharts);
    }

    private void setOngoing(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/count/ongoing_complaints.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                totalInvestigationNumberTextView.setText((CharSequence) object);
                setPie(piecharts);
            }
            @Override
            public void onEmpty() {

            }
        });

    }

    private void setFir(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/count/converted_to_fir_by_police_id.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                totalFirNumberTextView.setText((CharSequence) object);
                setOngoing(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setSolved(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/count/solved_complaints_count_by_police_id.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                totalSolvedNumberTextView.setText((CharSequence) object);
                setFir(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setTotal(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/count/total_complaints_by_police_id.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                totalAllotedComplaintsTextView.setText((CharSequence) object);
            }
            @Override
            public void onEmpty() {

            }
        });
    }
}