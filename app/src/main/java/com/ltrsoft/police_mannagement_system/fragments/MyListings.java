package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.utils.ActionBarTitle;

public class MyListings extends Fragment {
    private View view;
    private RelativeLayout assignedComplaint, fir, warrant, duty, criminal, missing, leaves, cyber, preow, assignedTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mylist, container, false);
        assignedComplaint = view.findViewById(R.id.complaints);
        fir = view.findViewById(R.id.fir);
        warrant = view.findViewById(R.id.warrent);
        duty = view.findViewById(R.id.duty_allot);
        criminal = view.findViewById(R.id.Criminal);
        missing = view.findViewById(R.id.missing);
        leaves = view.findViewById(R.id.leavess);
        cyber = view.findViewById(R.id.cyber);
        preow = view.findViewById(R.id.self_proclaimed);
        assignedTask = view.findViewById(R.id.AssignedTask);
        ActionBarTitle.setTiltle("MyListings", (AppCompatActivity) getActivity());

        assignedComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AssignComplaint());
            }
        });

        fir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FirList());
            }
        });

        warrant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loadFragment(new WarrentList());
            }
        });

        duty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {loadFragment(new DutyList());
            }
        });

        criminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {loadFragment(new CriminalList());

            }
        });

        missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {loadFragment(new MissingList());            }
        });

        leaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {loadFragment(new LeavesList());          }
        });

        cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loadFragment(new CyberList());
            }
        });

        preow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SelfProclaimedList());
            }
        });

        assignedTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            loadFragment(new AssignedTaskList());
            }
        });
        Toast.makeText(getContext(), "This is MyListings", Toast.LENGTH_SHORT).show();
        return view;
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fraglayot,fragment)
                .addToBackStack(null)
                .commit();
    }
 }