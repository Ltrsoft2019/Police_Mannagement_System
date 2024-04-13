package com.ltrsoft.police_mannagement_system.fragments;
import static android.app.Activity.RESULT_OK;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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
import com.ltrsoft.police_mannagement_system.utils.Mic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AddComplaint extends Fragment {
    private static final int REQUEST_IMAGE_PICKER = 100;
    DAO dao ;
    public AddComplaint() {}
    private View view;
    private EditText fname,mname,lname;
    private RadioGroup gender;
    private ImageView m1,m2,m3;
    private Spinner country,states;
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
        states = view.findViewById(R.id.states);
        m1 = view.findViewById(R.id.mike_img1);
        m2 = view.findViewById(R.id.mike_img2);
        m3 = view.findViewById(R.id.mike_img3);
        dao = new DAO(getContext());

        Mic mic = new Mic(getContext());
        mic.startListening(fname,m1);
        mic.startListening(mname,m2);
        mic.startListening(lname,m3);




        dob.setOnClickListener(new View.OnClickListener() {
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
                                dob.setText(selectedDate);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();

            }
        });
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
                AddComplaint2 fragment = new AddComplaint2();
                Bundle bundle = new Bundle();
                bundle.putString("user_id","1");
                fragment.setArguments(bundle);
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fraglayot,fragment)
                        .commit();
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
                ArrayList<String>list1=new ArrayList<>();
                if (!response.isEmpty()) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("state_name");
                            list1.add(name);
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list1);
                        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        states.setAdapter(adapter);
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