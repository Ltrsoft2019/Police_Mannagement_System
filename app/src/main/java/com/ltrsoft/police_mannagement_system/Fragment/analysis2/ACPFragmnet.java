package com.ltrsoft.police_mannagement_system.Fragment.analysis2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;

public class ACPFragmnet extends Fragment {
    public ACPFragmnet() {}
    private PieChart chart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);


        return view;
    }
}
