package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrsoft.police_mannagement_system.R;

public class Add_Evidance extends Fragment {

    public Add_Evidance() {

     }
   View rootView;
    private EditText evidanceNumberEditText, evidanceTypeEditText, itemDescEditText, serialNumberEditText;
    private TextView seizureDateTextView;
    private ImageView mikeImg1, mikeImg2, mikeImg3, mikeImg4, cameraImg;
    private TextView cameraTextView, galleryTextView;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         rootView= inflater.inflate(R.layout.add__evidance, container, false);


     return rootView;
    }
    private void setid(){
        evidanceNumberEditText = rootView.findViewById(R.id.evidance_number);
        evidanceTypeEditText = rootView.findViewById(R.id.evidance_type);
        itemDescEditText = rootView.findViewById(R.id.item_desc);
        serialNumberEditText = rootView.findViewById(R.id.serial_number);
        seizureDateTextView = rootView.findViewById(R.id.seizure_date);
        mikeImg1 = rootView.findViewById(R.id.mike_img1);
        mikeImg2 = rootView.findViewById(R.id.mike_img2);
        mikeImg3 = rootView.findViewById(R.id.mike_img3);
        mikeImg4 = rootView.findViewById(R.id.mike_img4);
        cameraImg = rootView.findViewById(R.id.camera_img);
        cameraTextView = rootView.findViewById(R.id.camera_tv);
        galleryTextView = rootView.findViewById(R.id.gallery_tv);
        nextButton = rootView.findViewById(R.id.next_btn);
    }
}