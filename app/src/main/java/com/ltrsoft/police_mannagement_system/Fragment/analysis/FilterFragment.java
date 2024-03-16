package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.R;

public class FilterFragment extends Fragment {
    private View view;
    private RelativeLayout yearMonthCard;
    private RelativeLayout firStageCard;
    private RelativeLayout responseCard;
    private RelativeLayout firTypeCard;
    private RelativeLayout complaintModeCard;
    private RelativeLayout compTypeCard;
    private RelativeLayout actSectionCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.filtercards,container,false);
        setId();
        yearMonthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new Filter_year_month() ).addToBackStack(null).commit();

            }
        });


        firStageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();
            }
        });

        responseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();

            }
        });

        firTypeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();

            }
        });

        complaintModeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();
            }
        });

        compTypeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();

            }
        });

        actSectionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FilterFragment()).addToBackStack(null).commit();

            }
        });
        return view;
    }

    private void setId() {
        yearMonthCard = view.findViewById(R.id.year_month);
        firStageCard = view.findViewById(R.id.fir_stage);
        responseCard = view.findViewById(R.id.response);
        firTypeCard = view.findViewById(R.id.firtype);
        complaintModeCard = view.findViewById(R.id.complaint_mode);
        compTypeCard = view.findViewById(R.id.comp_type);
        actSectionCard = view.findViewById(R.id.act_section);
    }
}
