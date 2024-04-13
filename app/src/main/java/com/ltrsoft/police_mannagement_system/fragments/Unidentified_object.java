package com.ltrsoft.police_mannagement_system.fragments;

import android.app.Activity;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.LocationCallBack;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.UnidentifiedObject;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.utils.LocationProvider;
import com.ltrsoft.police_mannagement_system.utils.Mic;

public class Unidentified_object extends Fragment {
    public Unidentified_object() {}
    private TextView location,gallery,camera;
    private EditText object_founded, mark, condition;
    private ImageView displaying;
    private Button submit;
    private ImageView m1,m2,m3;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICKER = 2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unidentified_object, container, false);
            m1=view.findViewById(R.id.mike_img1);
            m2=view.findViewById(R.id.mike_img2);
            m3=view.findViewById(R.id.mike_img3);

        location = view.findViewById(R.id.location);
        object_founded = view.findViewById(R.id.location_founded);
        mark = view.findViewById(R.id.unidentified_mark);
        condition = view.findViewById(R.id.condition_object);
        displaying = view.findViewById(R.id.camera_img);
        submit = view.findViewById(R.id.next_btn);
        gallery=view.findViewById(R.id.gallery_tv);
        camera=view.findViewById(R.id.camera_tv);

        Mic mic= new Mic(getContext());
        mic.startListening(object_founded,m1);
        mic.startListening(condition,m2);
        mic.startListening(mark,m3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!object_founded.getText().toString().isEmpty()&&
                    !condition.getText().toString().isEmpty()&&
                    !mark.getText().toString().isEmpty()){
                    UnidentifiedObject object = new UnidentifiedObject("1","12/20/2003",location.getText().toString(),condition.getText().toString(),
                            mark.getText().toString(),"","","","","1","1");
                    DAO dao = new DAO(getContext());
                    dao.insertOrUpdate(object, new NewCallBack() {
                        @Override
                        public void onError(String error) {

                        }

                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(getContext(), "Repsone "+object, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onEmpty() {

                        }
                    },"https://rj.ltr-soft.com/public/police_api/unidentified_objects/create_unidentified_objects.php");
                }
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

                  }
              });
          }
      });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                displaying.setImageBitmap(imageBitmap);
            } else if (requestCode == REQUEST_IMAGE_PICKER && data != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), data.getData());
                    displaying.setImageBitmap(bitmap);
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
