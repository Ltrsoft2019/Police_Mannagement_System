package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.ltrsoft.police_mannagement_system.R;

public class PoliceAdd extends Fragment implements View.OnClickListener {
    private RelativeLayout addcmp, unidobj, unibody, cybercrime, criminal, missing, self, investigation, leave;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.police_add, container, false);
        intiView();
        return view;
    }

    private void intiView() {
        addcmp = view.findViewById(R.id.addcomplaints);
        unidobj = view.findViewById(R.id.unidentified_objs);
        unibody = view.findViewById(R.id.unidentifiedbody);
        cybercrime = view.findViewById(R.id.Add_Cuberc);
        criminal = view.findViewById(R.id.Criminal_list);
        missing = view.findViewById(R.id.missing);
        self = view.findViewById(R.id.self_proclaimed);
        investigation = view.findViewById(R.id.investigations);
        leave = view.findViewById(R.id.apply_leave);

        addcmp.setOnClickListener(this);
        unidobj.setOnClickListener(this);
        unibody.setOnClickListener(this);
        cybercrime.setOnClickListener(this);
        criminal.setOnClickListener(this);
        missing.setOnClickListener(this);
        self.setOnClickListener(this);
        investigation.setOnClickListener(this);
        leave.setOnClickListener(this);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fraglayot,fragment)
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addcomplaints) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.unidentified_objs) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.unidentifiedbody) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.Add_Cuberc) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.Criminal_list) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.missing) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.self_proclaimed) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.investigations) {loadFragment(new AddComplaint());}
        else if (v.getId() == R.id.apply_leave) {loadFragment(new AddComplaint());}
    }
}
