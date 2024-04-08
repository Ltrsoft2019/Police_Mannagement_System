package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.AnalysisPageAdapter;

public class Analysis extends Fragment {
    public Analysis() {
    }
    private ViewPager2 analysis;
    private TabLayout layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.analysis, container, false);
        Toast.makeText(getContext(), "this is DahsBoard Analaysis", Toast.LENGTH_SHORT).show();
        analysis = view.findViewById(R.id.analysis_viewpager);
        layout = view.findViewById(R.id.tablayout);

        AnalysisPageAdapter adapter = new AnalysisPageAdapter(getParentFragmentManager(),getLifecycle());
        analysis.setAdapter(adapter);

        new TabLayoutMediator(layout, analysis, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                if (i==0) {
                    tab.setText("On Self");
                }else   if (i==1) {
                    tab.setText("On Behalf");
                }else {
                    tab.setText("");
                }
            }
        });
        return view;
    }
}