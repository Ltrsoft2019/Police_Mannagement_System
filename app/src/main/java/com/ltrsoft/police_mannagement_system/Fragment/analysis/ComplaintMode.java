package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.FirAdapter;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.ArrayList;

public class ComplaintMode extends Fragment {
    private BarChart barChart;
    private Spinner complaint_mode;
    private RecyclerView firs;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.complaintmode, container, false);
        barChart = view.findViewById(R.id.barchart_comp);
        complaint_mode = view.findViewById(R.id.complaint_mode_spinner);
        firs = view.findViewById(R.id.fir_list);

        ArrayList<String>list = new ArrayList<>();
        list.add("online ");
        list.add("oral ");
        list.add("online ");
        list.add("online ");
        list.add("online ");
        list.add("online ");
        list.add("online ");
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        complaint_mode.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        firs.setLayoutManager(layoutManager);
        ArrayList<FirModel>models=new ArrayList<>();
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        models.add(new FirModel("12","sdaf","sdf","asdf"));
        FirAdapter adapter1 = new FirAdapter(models);
        firs.setAdapter(adapter1);
        setBarChart();

        return view;
    }
    private void setBarChart() {
        BarModel barModel1 = new BarModel("Jan", 10f, Color.parseColor("#3366FF"));
        BarModel barModel2 = new BarModel("Feb", 20f, Color.parseColor("#3366FF"));
        BarModel barModel3 = new BarModel("March", 30f, Color.parseColor("#00C853"));
        BarModel barModel4 = new BarModel("April", 25f, Color.parseColor("#00C853"));
        BarModel barModel5 = new BarModel("May", 23f, Color.parseColor("#AA66CC"));
        BarModel barModel6 = new BarModel("June", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel7 = new BarModel("Julai", 100f, Color.parseColor("#AA66CC"));
        BarModel barModel8 = new BarModel("Aug", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel9 = new BarModel("Sept", 105f, Color.parseColor("#AA66CC"));
        BarModel barModel10 = new BarModel("Oct",  15f, Color.parseColor("#AA66CC"));
        BarModel barModel11 = new BarModel("Nov", 55f, Color.parseColor("#AA66CC"));
        BarModel barModel12 = new BarModel("Dec", 35f, Color.parseColor("#AA66CC"));

        barChart.addBar(barModel1);

        barChart.addBar(barModel2);
        barChart.addBar(barModel3);
        barChart.addBar(barModel4);
        barChart.addBar(barModel5);
        barChart.addBar(barModel6);
        barChart.addBar(barModel7);
        barChart.addBar(barModel8);
        barChart.addBar(barModel9);
        barChart.addBar(barModel10);
        barChart.addBar(barModel11);
        barChart.addBar(barModel12);
        barChart.setBarWidth(0.00000001f);
        barChart.setElevation(.2f);
        barChart.startAnimation();
    }
}
