package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Bargraphchart;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.eazegraph.lib.charts.BarChart;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis4 extends Fragment {
    public Analysis4() {}
    private BarChart barChart;
    private Spinner spinner;
    private LinearLayout layout;
    private DAO dao;
    private TextView total_criminal,total_warrant,total_suspect,total_victim,total_witness,total_evidance;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.analysis4, container, false);
         dao=new DAO(getContext());
         barChart=view.findViewById(R.id.piechart);
         spinner=view.findViewById(R.id.spinner);
         layout=view.findViewById(R.id.layout);
         total_criminal=view.findViewById(R.id.total_criminal);
        total_warrant=view.findViewById(R.id.total_warrant);
        total_suspect=view.findViewById(R.id.total_suspect);
        total_victim=view.findViewById(R.id.total_victim);
        total_evidance=view.findViewById(R.id.total_evidance);
        total_witness=view.findViewById(R.id.total_witness);

        HashMap<String,String>map=new HashMap<>();
        map.put("station_id","1");
        setCriminals(map);
        return view;
    }

    private void setCriminals(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/count_criminals.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_criminal.setText(String.valueOf(object));
                setWarrant(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setWarrant(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/count_warrant.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_warrant.setText(String.valueOf(object));
                setWittness(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setWittness(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/witness_count.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_witness.setText(String.valueOf(object));
                setSuspect(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setSuspect(HashMap<String, String> map) {

        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/suspect_count.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_suspect.setText(String.valueOf(object));
                setVictim(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setVictim(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/victim_count.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_victim.setText(String.valueOf(object));
                setWitness(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setWitness(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/witness_count.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_witness.setText(String.valueOf(object));
                setEvidence(map);
            }
            @Override
            public void onEmpty() {

            }
        });
    }

    private void setEvidence(HashMap<String, String> map) {
        dao.getData(map, "https://rj.ltr-soft.com/public/police_api/station_count/evidance_count.php", new NewCallBack() {
            @Override
            public void onError(String error) {}
            @Override
            public void onSuccess(Object object) {
                total_evidance.setText(String.valueOf(object));
                setBarChart();
            }
            @Override
            public void onEmpty() {}
        });
    }

    private void setBarChart() {
        ArrayList<BargraphModelclass>bars=new ArrayList<>();
        bars.add(new BargraphModelclass("Criminal",Float.valueOf(total_criminal.getText().toString()),"#FFF424"));
        bars.add(new BargraphModelclass("Warrent",Float.valueOf(total_warrant.getText().toString()),"#00B2E2"));
        bars.add(new BargraphModelclass("Suspect",Float.valueOf(total_suspect.getText().toString()),"#9467bd"));
        bars.add(new BargraphModelclass("Victim",Float.valueOf(total_victim.getText().toString()),"#EA0075"));
        bars.add(new BargraphModelclass("Witness",Float.valueOf(total_witness.getText().toString()),"#ff7f0e"));
        bars.add(new BargraphModelclass("Evidence",Float.valueOf(total_evidance.getText().toString()),"#2ca02c"));
        Bargraphchart bargraphchart = new Bargraphchart(bars);
        bargraphchart.setbargraph(barChart);
    }

}