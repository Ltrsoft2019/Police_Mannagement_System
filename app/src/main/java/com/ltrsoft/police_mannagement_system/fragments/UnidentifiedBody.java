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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Unidentified_Bodies;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.Calendar;

public class UnidentifiedBody extends Fragment {
        private TextView date, location, camera, gallery;
        private ImageView dispImg;
        private EditText currentLocation, estimatedAge, estimatedHeight, estimatedWeight, estimatedBuild,
                ethnicity, hairColor, eyeColor, distinguishFeature, descriptionOfClothing, bodyCondition;
        private Button submit;
        private static final int REQUEST_IMAGE_CAPTURE = 1;
        private static final int REQUEST_IMAGE_PICKER = 2;
        private Calendar calendar;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.unidentified_body, container, false);

            // Initialize your views here
            date = view.findViewById(R.id.date); // replace R.id.date with your actual ID
            location = view.findViewById(R.id.current_location); // replace R.id.location with your actual ID
            camera = view.findViewById(R.id.camera); // replace R.id.camera with your actual ID
            gallery = view.findViewById(R.id.gallery); // replace R.id.gallery with your actual ID
            dispImg = view.findViewById(R.id.disp_img); // replace R.id.disp_img with your actual ID
            currentLocation = view.findViewById(R.id.body_location); // replace R.id.body_location with your actual ID
            estimatedAge = view.findViewById(R.id.estimated_age); // replace R.id.estimated_age with your actual ID
            estimatedHeight = view.findViewById(R.id.estimated_height); // replace R.id.estimated_height with your actual ID
            estimatedWeight = view.findViewById(R.id.estimated_weight); // replace R.id.estimated_weight with your actual ID
            estimatedBuild = view.findViewById(R.id.estimated_build); // replace R.id.estimated_build with your actual ID
            ethnicity = view.findViewById(R.id.ethnicity); // replace R.id.ethnicity with your actual ID
            hairColor = view.findViewById(R.id.haircolor); // replace R.id.haircolor with your actual ID
            eyeColor = view.findViewById(R.id.eye_color); // replace R.id.eye_color with your actual ID
            distinguishFeature = view.findViewById(R.id.distinguish_feature); // replace R.id.distinguish_feature with your actual ID
            descriptionOfClothing = view.findViewById(R.id.descriptionofclothing); // replace R.id.descriptionofclothing with your actual ID
            bodyCondition = view.findViewById(R.id.body_condition); // replace R.id.body_condition with your actual ID
            submit = view.findViewById(R.id.submit);
            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchTakePictureIntent();
                }
            });

            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calendar = Calendar.getInstance();
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


            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();
                }
            });
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!date.getText().toString().isEmpty()){
                        if (!currentLocation.getText().toString().isEmpty()){
                            if (!estimatedAge.getText().toString().isEmpty()){
                                if (!estimatedHeight.getText().toString().isEmpty()){
                                    if (!estimatedWeight.getText().toString().isEmpty()){
                                        if (!estimatedBuild.getText().toString().isEmpty()){
                                            if (!ethnicity.getText().toString().isEmpty()){
                                                Toast.makeText(getContext(), "Valid Values", Toast.LENGTH_SHORT).show();
                                                Unidentified_Bodies unidentifiedBodies = new Unidentified_Bodies("1","12/12/2003",currentLocation.getText().toString(),
                                                        "male",estimatedAge.getText().toString(),estimatedHeight.getText().toString(),
                                                        estimatedWeight.getText().toString(),estimatedBuild.getText().toString(),ethnicity.getText().toString(),
                                                        "","","","","","","","1","1");
                                                DAO dao = new DAO(getContext());
                                                dao.insertOrUpdate(unidentifiedBodies, new NewCallBack() {
                                                    @Override
                                                    public void onError(String error) {
                                                        Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
                                                    }
                                                    @Override
                                                    public void onSuccess(Object object) {
                                                        Toast.makeText(getContext(), "Response "+object, Toast.LENGTH_SHORT).show();
                                                    }

                                                    @Override
                                                    public void onEmpty() {
                                                        Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
                                                    }
                                                },"https://rj.ltr-soft.com/public/police_api/unidentified_bodies/create_unidentified_bodies.php");
                                            }else {
                                                Toast.makeText(getContext(), "Null values7", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                        else {
                                            Toast.makeText(getContext(), "Null values6", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        Toast.makeText(getContext(), "Null values5", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(getContext(), "Null values4", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(getContext(), "Null values3", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getContext(), "Null values2", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(), "Null values1", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return view;
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                dispImg.setImageBitmap(imageBitmap);
            } else if (requestCode == REQUEST_IMAGE_PICKER && data != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                    dispImg.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(requireContext(), "Action canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
