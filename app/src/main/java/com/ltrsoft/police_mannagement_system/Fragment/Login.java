package com.ltrsoft.police_mannagement_system.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.navigation.Navigationfragment;
import com.ltrsoft.police_mannagement_system.utils.SessionManager;
import com.ltrsoft.police_mannagement_system.utils.UserDataAccess;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends Fragment {
    private EditText kgid;
    private EditText interanlid;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private Button loginButton;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initizilise();
         return view;
    }

    private void initizilise() {

        kgid = view.findViewById(R.id.email);
        interanlid = view.findViewById(R.id.password);
        forgotPasswordTextView =view. findViewById(R.id.forgot_password);
        signUpTextView = view.findViewById(R.id.registration);
        loginButton =view. findViewById(R.id.loginbtn);

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(kgid.getText().toString().trim()).isEmpty()){
                        if (!(interanlid.getText().toString().isEmpty())){
//                            loginUser(kgid.getText().toString(),interanlid.getText().toString());
                            SessionManager sessionManager = new SessionManager(getContext());
                            sessionManager.setLogin(true);
                            UserDataAccess access = new UserDataAccess();
                            access.setKgid("1827332",getActivity());
                            access.setPosition("ACP",getActivity());

                            getActivity().getSupportFragmentManager()
                                    .beginTransaction().
                                    add(R.id.main_container,new Navigationfragment())
                                    .commit();

                    }
                        else {

                            interanlid.setError("Enter Internal id");

                    }
                }
                else {

                    kgid.setError("this is compulsory field");

                }

            }
        });
    }

    private void loginUser(String kgid, String internal) {

        DAO  dao = new DAO(getContext());
        HashMap<String ,String>map = new HashMap<>();
        map.put("KGID",kgid);
        map.put("InternalIO",internal);

        dao.getData(map, "", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error is "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Response = "+object, Toast.LENGTH_SHORT).show();
//                SessionManager sessionManager = new SessionManager(getContext());
//                sessionManager.setLogin(true);
//                UserDataAccess access = new UserDataAccess();
//                access.setKgid("1827332",getActivity());
//                access.setPosition("ACP",getActivity());

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
