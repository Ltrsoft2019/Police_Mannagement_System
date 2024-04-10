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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Users;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AddComplaint extends Fragment {
    private static final int REQUEST_IMAGE_PICKER = 100;
    DAO dao ;
    public AddComplaint() {}
    private View view;
    private EditText fname,mname,lname;
    private RadioGroup gender;
    private Spinner country;
    private TextView dob,camera,galery;
    private Button next;
    private ImageView dispimg;
    private ArrayList<String>list=new ArrayList<>();
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.form_designing, container, false);
        fname= view.findViewById(R.id.userfname);
        mname= view.findViewById(R.id.unsermname);
        lname= view.findViewById(R.id.userlname);
        gender=view.findViewById(R.id.gendergroup);
        country=view.findViewById(R.id.country);
        dob=view.findViewById(R.id.dob_date);
        camera=view.findViewById(R.id.camera_tv);
        galery=view.findViewById(R.id.gallery_tv);
        next = view.findViewById(R.id.next_btn);
        dispimg = view.findViewById(R.id.camera_img);
        dao = new DAO(getContext());

        loaCountry();
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loaState(String.valueOf(position+1));}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});
        camera.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {
                dispatchTakePictureIntent();}});

        galery.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {openGallery(); }});

        next.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) {
                if (!fname.getText().toString().trim().isEmpty()) {
                    if (!mname.getText().toString().trim().isEmpty()) {
                        if (!lname.getText().toString().trim().isEmpty()) {
                            submit(fname.getText().toString(), mname.getText().toString(), lname.getText().toString());
                        }else {
                            lname.setError("this field is required");
                        }
                    }else {
                        mname.setError("this field is required");
                    }
                }else {
                    fname.setError("This field is required");
                }
            }
        });
        return view;
    }

    private void submit(String f, String m, String l) {
        Users users = new Users("1",f,m,l,"latur","","1","1","1","1","email","pass","male"
        ,"17/07/2003","23424","2314","","25235","","","","","","","1");

        dao.insertOrUpdate(users, new NewCallBack() {
            @Override
            public void onError(String error) {

            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "result "+object, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEmpty() {

            }
        },"https://rj.ltr-soft.com/public/police_api/user/user_insert.php");
    }

    private void loaState(String s) {
        System.out.println("position "+s);
        HashMap hashMap = new HashMap();
        hashMap.put("country_id",s);
        dao.getData(hashMap, "https://rj.ltr-soft.com/public/police_api/state/select_state.php", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                String response = (String) object;
                if (!response.isEmpty()) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("state_name");
                            list.add(name);
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        country.setAdapter(adapter);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loaCountry() {
        dao.getData(new HashMap<>(), "https://rj.ltr-soft.com/public/police_api/country/select_country.php", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "Error "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object)  {
                String response = (String) object;
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("country_name");
                        list.add(name);
                    }
                    ArrayAdapter<String>adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list);
                    adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                    country.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "Empty ", Toast.LENGTH_SHORT).show();
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
            dispimg.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_IMAGE_PICKER && resultCode == RESULT_OK && data != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                dispimg.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}