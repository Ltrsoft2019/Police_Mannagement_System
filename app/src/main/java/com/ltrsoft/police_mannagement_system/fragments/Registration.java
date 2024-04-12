package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.PoliceInfo;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

public class Registration extends Fragment {
    public Registration() {}
    Button register;
    TextView login;
    EditText con_password,user_password,user_mobile,user_email,user_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.registration, container, false);
        register=view.findViewById(R.id.register);
        con_password=view.findViewById(R.id.con_password);
        user_password=view.findViewById(R.id.user_password);
        user_mobile=view.findViewById(R.id.user_mobile);
        user_email=view.findViewById(R.id.user_email);
        user_name=view.findViewById(R.id.user_name);
        login=view.findViewById(R.id.login_text);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name1 = user_name.getText().toString().trim();
                 String email1 = user_email.getText().toString().trim();
                 String password1 = user_password.getText().toString().trim();
                 String confirmPassword1=con_password.getText().toString().trim();
                 String phone1 = user_mobile.getText().toString().trim();

                Toast.makeText(getContext(), ""+phone1, Toast.LENGTH_SHORT).show();

                if (!name1.isEmpty()){
                    if (!email1.isEmpty()){
                        if (!phone1.isEmpty()){
                            if (!password1.isEmpty()){
                                if (!confirmPassword1.isEmpty()){
                                    if (password1.equals(confirmPassword1)) {
                                        DAO dao = new DAO(getContext());
                                        PoliceInfo policeInfo = new PoliceInfo("1","",
                                                name1,"","",email1,
                                                password1,"","",phone1,phone1,"","",
                                                "1","1","1","1","1","","22"
                                        ,"","");
                                        dao.insertOrUpdate(policeInfo, new NewCallBack() {
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

                                            }
                                        }, "https://rj.ltr-soft.com/public/police_api/police/police_insert.php");
                                    }
                                    else {
                                        con_password.setError("Password is not same");
                                    }

                                }else {
                                    con_password.setError("Please insert confirm password");
                                }

                            }else {
                                user_password.setError("Please insert password");
                            }

                        }else {
                            user_mobile.setError("Please insert Phone no");
                        }

                    }else {
                        user_email.setError("Please insert email");
                    }
                }else {
                    user_name.setError("Please insert name");
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new PoliceLogin())
                         .commit();
            }
        });

    return  view;
    }
}