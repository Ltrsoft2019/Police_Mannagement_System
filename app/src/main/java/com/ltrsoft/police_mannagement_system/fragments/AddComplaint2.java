package com.ltrsoft.police_mannagement_system.fragments;

import static android.app.Activity.RESULT_OK;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.LocationCallBack;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Complaint;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.utils.LocationProvider;
import com.ltrsoft.police_mannagement_system.utils.Mic;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AddComplaint2 extends Fragment {
    public AddComplaint2() {}
    private EditText subject,desc,aginst;
    private TextView date,location,camera,gallery;
    private Spinner cmp,sub;
    private ImageView disp;
    private Button submit;
    private  DAO dao;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICKER = 100;
    private ImageView m1,m2,m3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_complaint2, container, false);

        subject = view.findViewById(R.id.subject);
        desc = view.findViewById(R.id.desc);
        aginst = view.findViewById(R.id.against);
        date = view.findViewById(R.id.complaint_date);
        location = view.findViewById(R.id.location);
        camera = view.findViewById(R.id.camera_tv);
        gallery = view.findViewById(R.id.gallery_tv);
        cmp = view.findViewById(R.id.cmp_type);
        sub = view.findViewById(R.id.cmpSubt);
        disp = view.findViewById(R.id.camera_img);
        submit = view.findViewById(R.id.submit);
        m1 = view.findViewById(R.id.mike_img1);
        m2 = view.findViewById(R.id.mike_img2);
        m3 = view.findViewById(R.id.mike_img3);
        dao = new DAO(getContext());
        Mic mic = new Mic(getContext());
        mic.startListening(subject,m1);
        mic.startListening(desc,m2);
        mic.startListening(aginst,m3);


        setComplaintType();
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationProvider.getCurrentLocation(getContext(), new LocationCallBack() {
                    @Override
                    public void onLocationGet(Location latLng) {
                        location.setText(String.valueOf(latLng.getLatitude()));
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(getContext(), "Erorr "+error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!subject.getText().toString().isEmpty()){
                    if (!aginst.getText().toString().isEmpty()){
                        if (!desc.getText().toString().isEmpty()){
                            Complaint model = new Complaint("",subject.getText().toString(),desc.getText().toString(),
                                    aginst.getText().toString(),date.getText().toString(),"","23","","","","","");

                                    dao.insertOrUpdate(model, new NewCallBack() {
                                        @Override
                                        public void onError(String error) {

                                        }

                                        @Override
                                        public void onSuccess(Object object) {
                                            Toast.makeText(getContext(), "Resposne "+object, Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onEmpty() {

                                        }
                                    }, "https://rj.ltr-soft.com/public/police_api/complaint/complaint_insert.php");

                        }else {
                            Toast.makeText(getContext(), "Field is required", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(), "Field is required", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(), "Field is required", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    private void setComplaintType() {
        ArrayList<String>list=new ArrayList<>();
        dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/complaint_types/read_complaint_types.php",
                new NewCallBack() {
                    @Override
                    public void onError(String error) {

                    }

                    @Override
                    public void onSuccess(Object object) {
                        try {
                            JSONArray jsonArray = new JSONArray(String.valueOf(object));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                list.add(jsonArray.getJSONObject(i).getString("type_name"));
                            }
                            ArrayAdapter<String>adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
                            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                            cmp.setAdapter(adapter);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    @Override
                    public void onEmpty() {

                    }
                });
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            disp.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_IMAGE_PICKER && resultCode == RESULT_OK && data != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                disp.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_PICKER);
    }
}