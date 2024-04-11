package com.ltrsoft.police_mannagement_system.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Self_proclaimed;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Self_Proclaimed extends Fragment {

    public Self_Proclaimed() {

     }
    private EditText criminalfullname, address, contact_info, identification_detail,
            criminal_weight, court_name, economic_offense,
            status_of_legal_proceedings, description_and_allegations, height,
            weight, build, hair_color, eye_color, distinguishing_features,
            previous_convictions, previous_offenses_details;
    private RadioGroup gendergroup;
    private RadioButton male, female, other;
    private Spinner country;
    private Button next_btn;
    private TextView decl_date;
    private DAO dao;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.self__proclaimed, container, false);
         dao = new DAO(getContext());
         criminalfullname = view.findViewById(R.id.criminalfullname);
         address = view.findViewById(R.id.address);
         contact_info = view.findViewById(R.id.contact_info);
         identification_detail = view.findViewById(R.id.identification_detail);
         criminal_weight = view.findViewById(R.id.criminal_weight);
         decl_date = view.findViewById(R.id.decl_date);
         court_name = view.findViewById(R.id.court_name);
         economic_offense = view.findViewById(R.id.economic_offense);
         status_of_legal_proceedings = view.findViewById(R.id.status_of_legal_proceedings);
         description_and_allegations = view.findViewById(R.id.description_and_allegations);
         height = view.findViewById(R.id.height);
         weight = view.findViewById(R.id.weight);
         build = view.findViewById(R.id.build);
         hair_color = view.findViewById(R.id.hair_color);
         eye_color = view.findViewById(R.id.eye_color);
         distinguishing_features = view.findViewById(R.id.distinguishing_features);
         previous_convictions = view.findViewById(R.id.previous_convictions);
         previous_offenses_details = view.findViewById(R.id.previous_offenses_details);
         gendergroup = view.findViewById(R.id.gendergroup);
         male = view.findViewById(R.id.male);
         female = view.findViewById(R.id.female);
         other = view.findViewById(R.id.other);
         country = view.findViewById(R.id.country);
         next_btn = view.findViewById(R.id.next_btn);
            decl_date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                    decl_date.setText(selectedDate);
                                }
                            }, year, month, dayOfMonth);
                    datePickerDialog.show();
                }
            });

         next_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 //address, contact_info, identification_detail,
                 //            criminal_weight, court_name, economic_offense,
                 //            status_of_legal_proceedings, description_and_allegations, height,
                 if (!criminalfullname.getText().toString().isEmpty()){
                     if (!address.getText().toString().isEmpty()){
                         if (!contact_info.getText().toString().isEmpty()){
                             if (!identification_detail.getText().toString().isEmpty()){
                                 if (!criminal_weight.getText().toString().isEmpty()){
                                     if (!court_name.getText().toString().isEmpty()){
                                         if (!economic_offense.getText().toString().isEmpty()){
                                             Self_proclaimed model = new Self_proclaimed("1",criminalfullname.getText().toString(),decl_date.getText().toString(),
                                                     "male",address.getText().toString(),contact_info.getText().toString(),identification_detail.getText().toString(),"234234",decl_date.getText().toString(),court_name.getText().toString()
                                             ,economic_offense.getText().toString(),status_of_legal_proceedings.getText().toString(),description_and_allegations.getText().toString(),
                                                     height.getText().toString(),weight.getText().toString(),build.getText().toString(),hair_color.getText().toString(),
                                                     eye_color.getText().toString(),distinguishing_features.getText().toString(),previous_convictions.getText().toString(),
                                                     previous_offenses_details.getText().toString(),"1");

                                             dao.insertOrUpdate(model, new NewCallBack() {
                                                 @Override
                                                 public void onError(String error) {
                                                     Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
                                                 }

                                                 @Override
                                                 public void onSuccess(Object object) {
                                                     Toast.makeText(getContext(), "Resposne "+object, Toast.LENGTH_SHORT).show();
                                                 }

                                                 @Override
                                                 public void onEmpty() {
                                                     Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
                                                 }
                                             },"https://rj.ltr-soft.com/public/police_api/self_proclaimed_offenders/create_self_proclaimed_offenders.php");
                                         }else {
                                             Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();
                                         }
                                     }else {
                                         Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();

                                     }
                                 }else {
                                     Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();

                                 }
                             }else {
                                 Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();

                             }
                         }else {
                             Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();

                         }
                     }
                 }else {
                     Toast.makeText(getContext(), "This firld is required", Toast.LENGTH_SHORT).show();

                 }
             }
         });
         ArrayList<String>list=new ArrayList<>();
         dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php", new NewCallBack() {
             @Override
             public void onError(String error) {
                 Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
             }
             @Override
             public void onSuccess(Object object) {
                 try {
                     JSONArray jsonArray  = new JSONArray(String.valueOf(object));
                     for (int i = 0; i < jsonArray.length(); i++) {
                         JSONObject object1 = jsonArray.getJSONObject(i);
                         list.add(object1.getString("police_station_name"));
                     }
                     ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
                     adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                     country.setAdapter(adapter);
                 } catch (JSONException e) {
                     throw new RuntimeException(e);
                 }
             }
             @Override
             public void onEmpty() {}
         });
    return view;
    }
    private boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }
}