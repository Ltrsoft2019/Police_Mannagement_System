package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
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

import com.ltrsoft.police_mannagement_system.Model.Monthmodel;
import com.ltrsoft.police_mannagement_system.Model.YearModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.MonthAdapter;
import com.ltrsoft.police_mannagement_system.adapters.YearAdapter;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.ArrayList;

public class Filter_month extends Fragment {
    public Filter_month() {}
    BarChart barChart;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month, container, false);
        Toast.makeText(getContext(), "on month", Toast.LENGTH_SHORT).show();
        barChart = view.findViewById(R.id.monthbar);
        recyclerView=view.findViewById(R.id.month_recycler);
        setBar();
        setrecycler();

        return view;
    }

    private void setrecycler() {
        ArrayList<Monthmodel> models = new ArrayList<>();
        models.add(new Monthmodel("jan","12344"));
        models.add(new Monthmodel("feb","1234654"));
        models.add(new Monthmodel("march","1265344"));
        models.add(new Monthmodel("April","12345544"));
        models.add(new Monthmodel("may","1234544"));
        models.add(new Monthmodel("june","1234794"));
        models.add(new Monthmodel("julai","12344"));
        models.add(new Monthmodel("Aug","12344"));
        models.add(new Monthmodel("sept","12344"));
        models.add(new Monthmodel("Acto","12344"));
        models.add(new Monthmodel("nov","12344"));
        models.add(new Monthmodel("dec","12344"));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        MonthAdapter adapter = new MonthAdapter(models);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void setBar() {
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
