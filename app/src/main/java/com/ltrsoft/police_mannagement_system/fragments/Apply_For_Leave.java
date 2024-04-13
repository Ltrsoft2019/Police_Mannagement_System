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
import com.ltrsoft.police_mannagement_system.Model.Leave;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

public class Apply_For_Leave extends Fragment {
    public Apply_For_Leave() {}
    private static final int REQUEST_IMAGE_PICKER = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private TextView dateOfLeave;
    private EditText duration, reason, remark;
    private ImageView cameraImg;
    private TextView cameraTv, galleryTv;
    private Spinner station;
    private Button nextBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.apply__for__leave, container, false);
        dateOfLeave = view.findViewById(R.id.dob_date);
        duration = view.findViewById(R.id.duration);
        reason = view.findViewById(R.id.reason);
        remark = view.findViewById(R.id.remark);
        cameraImg = view.findViewById(R.id.camera_img);
        cameraTv = view.findViewById(R.id.camera_tv);
        galleryTv = view.findViewById(R.id.gallery_tv);
        station = view.findViewById(R.id.station);
        nextBtn = view.findViewById(R.id.next_btn);

        dateOfLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                

            }
        });

        cameraTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dispatchTakePictureIntent();
            }
        });
        galleryTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        // Set onClickListener for next button
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //duration, reason, remark;
                    if (!duration.getText().toString().isEmpty()){
                        if (!reason.getText().toString().isEmpty()){
                            if (!remark.getText().toString().isEmpty()){
                                Leave leave = new Leave("1",dateOfLeave.getText().toString(),
                                        "231",duration.getText().toString(),reason.getText().toString(),remark.getText().toString()
                                ,"","1","1");
                                DAO dao = new DAO(getContext());
                                dao.insertOrUpdate(leave, new NewCallBack() {
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
                                },"https://rj.ltr-soft.com/public/police_api/leaves/create_leaves.php");
                            }else {
                                Toast.makeText(getContext(), "This field is required", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getContext(), "This field is required", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getContext(), "This field is required", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    return view;
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
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            cameraImg.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_IMAGE_PICKER && resultCode == RESULT_OK && data != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                cameraImg.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}