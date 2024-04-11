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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Criminal;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AddCriminal extends Fragment {
    public AddCriminal() {}

    // Declare view variables
    private EditText criminal_name, race, social, height, weight, eyecolor,
            hair_color, identified_features, home_address, phone_number,
            email_address, occupation, educational_level;
    private Button submit;
    private TextView date;
    private RadioGroup gender;
    private Spinner station;
    private  DAO dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_criminal, container, false);
        dao= new DAO(getContext());
        // Initialize view variables
        criminal_name = view.findViewById(R.id.criminalfullname);
        race = view.findViewById(R.id.raceandethnicity);
        social = view.findViewById(R.id.usersecuritynumber);
        height = view.findViewById(R.id.criminal_height);
        weight = view.findViewById(R.id.criminal_weight);
        eyecolor = view.findViewById(R.id.eye_color);
        hair_color = view.findViewById(R.id.hair_color);
        identified_features = view.findViewById(R.id.identified_feature);
        home_address = view.findViewById(R.id.home_address);
        phone_number = view.findViewById(R.id.phone_number);
        email_address = view.findViewById(R.id.email_address);
        occupation = view.findViewById(R.id.occupation);
        educational_level = view.findViewById(R.id.educational_level);
        submit = view.findViewById(R.id.next_btn);
        date = view.findViewById(R.id.dob_date);
        gender = view.findViewById(R.id.gendergroup);
        station = view.findViewById(R.id.country);

        date.setOnClickListener(new View.OnClickListener() {
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
                                date.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
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
                    station.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            @Override
            public void onEmpty() {}
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String criminalName = criminal_name.getText().toString().trim();
                String raceEthnicity = race.getText().toString().trim();
                String socialSecurityNumber = social.getText().toString().trim();
                String criminalHeight = height.getText().toString().trim();
                String criminalWeight = weight.getText().toString().trim();
                String eyeColor = eyecolor.getText().toString().trim();
                String hairColor = hair_color.getText().toString().trim();
                String identifiedFeatures = identified_features.getText().toString().trim();
                String homeAddress = home_address.getText().toString().trim();
                String phoneNumber = phone_number.getText().toString().trim();
                String emailAddress = email_address.getText().toString().trim();
                String occupationText = occupation.getText().toString().trim();
                String educationalLevel = educational_level.getText().toString().trim();
                String dateOfBirth = date.getText().toString().trim();

                // Check if any field is empty
                if (criminalName.isEmpty() || raceEthnicity.isEmpty() || socialSecurityNumber.isEmpty() ||
                        criminalHeight.isEmpty() || criminalWeight.isEmpty() || eyeColor.isEmpty() ||
                        hairColor.isEmpty() || identifiedFeatures.isEmpty() || homeAddress.isEmpty() ||
                        phoneNumber.isEmpty() || emailAddress.isEmpty() || occupationText.isEmpty() ||
                        educationalLevel.isEmpty() || dateOfBirth.isEmpty()) {
                    // Show toast message if any field is empty
                    Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Criminal criminal = new Criminal();
                    criminal.setFullName(criminalName);
                    criminal.setRaceEthnicity(raceEthnicity);
                    criminal.setSocialSecurityNumber(socialSecurityNumber);
                    criminal.setHeight(criminalHeight);
                    criminal.setWeight(criminalWeight);
                    criminal.setEyeColor(eyeColor);
                    criminal.setHairColor(hairColor);
                    criminal.setIdentifyingFeatures(identifiedFeatures);
                    criminal.setHomeAddress(homeAddress);
                    criminal.setPhoneNumbers(phoneNumber);
                    criminal.setEmailAddress(emailAddress);
                    criminal.setOccupation(occupationText);
                    criminal.setEducationLevel(educationalLevel);
                    criminal.setDateOfBirth(dateOfBirth);
                    dao.insertOrUpdate(criminal, new NewCallBack() {
                        @Override
                        public void onError(String error) {

                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onEmpty() {

                        }
                    },"https://rj.ltr-soft.com/public/police_api/criminals/create_criminal.php");
                }
            }
        });
        return view;
    }
}
