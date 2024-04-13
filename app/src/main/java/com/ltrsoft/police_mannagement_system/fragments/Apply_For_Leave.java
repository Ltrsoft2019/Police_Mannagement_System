package com.ltrsoft.police_mannagement_system.fragments;

import static android.app.Activity.RESULT_OK;

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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Leave;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.utils.Mic;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
    private ImageView mike_img2,mike_img3,mike_img1;
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
        mike_img1 = view.findViewById(R.id.mike_img1);
        mike_img2 = view.findViewById(R.id.mike_img2);
        mike_img3 = view.findViewById(R.id.mike_img3);
        Mic mic = new Mic(getContext());
        mic.startListening(duration,mike_img1);
        mic.startListening(reason,mike_img2);
        mic.startListening(remark,mike_img3);
        setStations();

        dateOfLeave.setOnClickListener(new View.OnClickListener() {
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
                                dateOfLeave.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
                

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

    private void setStations() {
        DAO dao = new DAO(getContext());
        dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php", new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<String> list=new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(String.valueOf(object));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        list.add(jsonArray.getJSONObject(i).getString("police_station_name"));
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
                    adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                    station.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onEmpty() {

            }
        });
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