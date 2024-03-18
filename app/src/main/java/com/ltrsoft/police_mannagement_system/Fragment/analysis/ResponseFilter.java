package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.FirAdapter;

import java.util.ArrayList;
import java.util.List;

public class ResponseFilter extends Fragment {
    private RecyclerView fir;
    private LineChart chart;
    private Spinner years;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.response_filter, container, false);
        fir = view.findViewById(R.id.fir_recycler);
        chart = view.findViewById(R.id.linechart);
        years = view.findViewById(R.id.response_spinner);
        setLine(getEntries());
    

        ArrayList<FirModel> list = new ArrayList<>();
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));
        list.add(new FirModel("1", "wer", "rwer", "rwer"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        FirAdapter firAdapter = new FirAdapter(list);
        fir.setAdapter(firAdapter);
        fir.setLayoutManager(layoutManager);


        return view;
    }

    public List<Entry> getEntries() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 30f));
        entries.add(new Entry(1f, 20f));
        entries.add(new Entry(2f, 40f));
        entries.add(new Entry(3f, 50f));
        entries.add(new Entry(4f, 70f));
        entries.add(new Entry(5f, 90f));
        return entries;
    }

    private void setLine(List<Entry> entries) {
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        dataSet.setLineWidth(3f);
        dataSet.setCircleColor(Color.parseColor("#EF5350"));
        // Refresh the chart
        chart.invalidate();
        chart.animateX(2000, Easing.EaseInBounce); // A
    }
}
