package com.ltrsoft.police_mannagement_system.fragments;

import static android.app.Activity.RESULT_OK;


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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Complaint;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

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
        dao = new DAO(getContext());

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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