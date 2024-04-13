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
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Victims;
import com.ltrsoft.police_mannagement_system.Model.Witnesses;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

public class Add_Victim extends Fragment {


    public Add_Victim() {

     }
     private String Cretae_victim="https://rj.ltr-soft.com/public/police_api/complaint_victim/create_complaint_victim.php";
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.add_victim, container, false);

     setid();
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sfname=fname.getText().toString();
                String saddress = address.getText().toString();
                String snumber = number.getText().toString();
                String semail = email.getText().toString();
                String spassport = passport.getText().toString();
                String sdriving_license = driving_liscense.getText().toString();
                String ssecurity_number = security_number.getText().toString();
                String sestimated_height = estimated_height.getText().toString();
                String sestimated_weight = estimated_weight.getText().toString();
                String sestimated_build = estimated_build.getText().toString();
                String shaircolor = haircolor.getText().toString();
                String seye_color = eye_color.getText().toString();
                String sdistinguish_feature = distinguish_feature.getText().toString();
                String soccupation = occupation.getText().toString();
                String seducational_level = educational_level.getText().toString();
                String smartial_status = martial_status.getText().toString();
                String sfamily_members = family_members.getText().toString();
                String sdescription = discription.getText().toString();
                Victims victims=new Victims("",sfname,dob_date.toString(),gendergroup.toString(),saddress,snumber,
                        semail,spassport,sdriving_license,ssecurity_number,sestimated_height,sestimated_weight,
                        sestimated_build,shaircolor,seye_color,sdistinguish_feature,
                        soccupation,seducational_level,smartial_status,sfamily_members,"","1",
                        sdescription,"",country.toString(),states.toString(),district.toString(),city.toString());
                addcriminal(victims);

            }
        });
         return view;
    }
    public void addcriminal(Victims victims){
        DAO dao=new DAO(getContext());
        dao.insertOrUpdate(victims, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "success"+object, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "is empty", Toast.LENGTH_SHORT).show();

            }
        },Cretae_victim);
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