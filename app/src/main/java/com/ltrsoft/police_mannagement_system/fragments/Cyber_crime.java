package com.ltrsoft.police_mannagement_system.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.CyberCrimemodel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Cyber_crime extends Fragment {
    public Cyber_crime() {}
    private EditText where_does_occure,desc;
    private TextView camera , gallery,indident_date;
    private ImageView disp;
    private CheckBox lost_money,isdelay;
    private Button submit;
    private Spinner states;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICKER = 2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.cyber_crime, container, false);

        states = view.findViewById(R.id.states);
        where_does_occure = view.findViewById(R.id.occur);
        desc = view.findViewById(R.id.desc);
        camera = view.findViewById(R.id.camera_tv);
        gallery = view.findViewById(R.id.gallery_tv);
        indident_date = view.findViewById(R.id.dob_date);
        disp = view.findViewById(R.id.camera_img);
        lost_money = view.findViewById(R.id.lost_money);
        isdelay = view.findViewById(R.id.isdelay);
        submit = view.findViewById(R.id.next_btn);
            setStation();
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!where_does_occure.getText().toString().isEmpty()&&
                    !desc.getText().toString().isEmpty()){
                    DAO dao = new DAO(getContext());
                    CyberCrimemodel crimemodel = new CyberCrimemodel("1","1", lost_money.isChecked()?"true":"false",indident_date.getText().toString(),
                            isdelay.isChecked()?"true":"false",where_does_occure.getText().toString(),"","","1","1","1");
                    dao.insertOrUpdate(crimemodel, new NewCallBack() {
                        @Override
                        public void onError(String error) {}
                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "Resposne"+object, Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onEmpty() {}
                    },"https://rj.ltr-soft.com/public/police_api/cyber_crimes/create_cyber_crime.php");
                }
            }
        });
        indident_date.setOnClickListener(new View.OnClickListener() {
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
                                indident_date.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
       return view;
    }

    private void setStation() {
        DAO dao = new DAO(getContext());
        dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<String>list=new ArrayList<>();
                    try {
                        JSONArray jsonArray = new JSONArray(String.valueOf(object));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            list.add(jsonArray.getJSONObject(i).getString("police_station_name"));
                        }
                        ArrayAdapter <String>adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        states.setAdapter(adapter);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
            }

            @Override
            public void onEmpty() {}
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                disp.setImageBitmap(imageBitmap);
            } else if (requestCode == REQUEST_IMAGE_PICKER && data != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                    disp.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(requireContext(), "Action canceled", Toast.LENGTH_SHORT).show();
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_PICKER);
    }

}