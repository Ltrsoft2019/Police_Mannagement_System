package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.R;

public class FirAnalysis extends Fragment {


    public FirAnalysis() {
        // Required empty public constructor
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fir_analysis_fragment, container, false);
        Toast.makeText(getContext(), "on fir analysis", Toast.LENGTH_SHORT).show();
        return view;
    }
}