package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.ltrsoft.police_mannagement_system.R;

public class Add_Witness extends Fragment {

    private EditText fname, address, number, email, passport, driving_liscense, security_number, estimated_height, estimated_weight, estimated_build, haircolor, eye_color;
    private TextView dob_date;
    private RadioGroup gendergroup;
    private RadioButton male, female, other;
    private ImageView mike_img1, mike_img2, mike_img3, mike_img4, mike_img5, mike_img6, mike_img7;
    View view;
    private EditText distinguish_feature, occupation, educational_level, martial_status, family_members, discription;
    private Spinner country, states, district, city;
    private ImageView camera_img;
    private TextView camera_tv, gallery_tv;
    private Button next_btn;


    public Add_Witness() {

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.add_witness, container, false);

    setid();

    return view;
    }
    private void setid(){
        fname = view.findViewById(R.id.fname);
        address = view.findViewById(R.id.address);
        number = view.findViewById(R.id.number);
        email = view.findViewById(R.id.email);
        passport = view.findViewById(R.id.passport);
        driving_liscense = view.findViewById(R.id.driving_liscense);
        security_number = view.findViewById(R.id.security_number);
        estimated_height = view.findViewById(R.id.estimated_height);
        estimated_weight = view.findViewById(R.id.estimated_weight);
        estimated_build = view.findViewById(R.id.estimated_build);
        haircolor = view.findViewById(R.id.haircolor);
        eye_color = view.findViewById(R.id.eye_color);
        dob_date = view.findViewById(R.id.dob_date);
        gendergroup = view.findViewById(R.id.gendergroup);
        male = view.findViewById(R.id.male);
        female = view.findViewById(R.id.female);
        other = view.findViewById(R.id.other);

        mike_img1 = view.findViewById(R.id.mike_img1);
        mike_img2 = view.findViewById(R.id.mike_img2);
        mike_img3 = view.findViewById(R.id.mike_img3);
        mike_img4 = view.findViewById(R.id.mike_img4);
        mike_img5 = view.findViewById(R.id.mike_img5);
        mike_img6 = view.findViewById(R.id.mike_img6);
        mike_img7 = view.findViewById(R.id.mike_img7);
        distinguish_feature = view.findViewById(R.id.distinguish_feature);
        occupation = view.findViewById(R.id.occupation);
        educational_level = view.findViewById(R.id.educational_level);
        martial_status = view.findViewById(R.id.martial_status);
        family_members = view.findViewById(R.id.family_members);
        discription = view.findViewById(R.id.discription);
        country = view.findViewById(R.id.country);
        states = view.findViewById(R.id.states);
        district = view.findViewById(R.id.district);
        city = view.findViewById(R.id.city);
        camera_img = view.findViewById(R.id.camera_img);
        camera_tv = view.findViewById(R.id.camera_tv);
        gallery_tv = view.findViewById(R.id.gallery_tv);
        next_btn = view.findViewById(R.id.next_btn);
    }
}