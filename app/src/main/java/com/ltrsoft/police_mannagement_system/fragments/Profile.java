package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PoliceOfficer;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;

public class Profile extends Fragment {
    public Profile() {}
    private TextView police_id,batch_number,station_id,police_fname,police_mname,police_lname
            ,police_email,police_gender,police_dob,police_mobile1,police_mobile2,police_address,
            position_name,city_name,district_name,state_name,police_adhar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_page, container, false);
        police_id = view.findViewById(R.id.poiceid);
        batch_number = view.findViewById(R.id.batchno);
        station_id = view.findViewById(R.id.stationid);
        police_fname = view.findViewById(R.id.fname);
        police_mname = view.findViewById(R.id.mname);
        police_lname = view.findViewById(R.id.lname);
        police_email = view.findViewById(R.id.pemail);
        police_mobile1 = view.findViewById(R.id.mno);
        police_gender = view.findViewById(R.id.pgender);
        police_dob = view.findViewById(R.id.pdob);
        police_mobile2 = view.findViewById(R.id.alno);
        police_address = view.findViewById(R.id.adress);
        position_name = view.findViewById(R.id.positionid);
        city_name = view.findViewById(R.id.cityid);
        district_name = view.findViewById(R.id.districtid);
        state_name = view.findViewById(R.id.stateid);
        police_adhar = view . findViewById(R.id.policeadhar);

        DAO dao = new DAO(getContext());
        dao.select(PoliceOfficer.class, "police_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                ArrayList<PoliceOfficer>officers= (ArrayList<PoliceOfficer>) object;
                PoliceOfficer police = officers.get(0);
                batch_number.setText(police.getBatchNo());
                station_id.setText(police.getStationAddress());
                police_fname.setText(police.getPoliceFname());
                police_mname.setText(police.getPoliceMname());
                police_fname.setText(police.getPoliceLname());
                police_email.setText(police.getEmailAddress());
                police_gender.setText(police.getGender());
                police_dob.setText(police.getDOB());
                police_mobile1.setText(police.getPoliceMobile1());
                police_mobile2.setText(police.getPoliceMobile2());
                police_address.setText(police.getPoliceAddress());
                city_name.setText(police.getCityId());
                district_name.setText(police.getDistrictId());
                state_name.setText(police.getStateId());
                position_name.setText(police.getPositionName());
                police_adhar.setText(police.getPoliceAdhar());
            }

            @Override
            public void onEmpty() {

            }
        },"https://rj.ltr-soft.com/public/police_api/police/police_read.php");
        //
        return view;
    }
}