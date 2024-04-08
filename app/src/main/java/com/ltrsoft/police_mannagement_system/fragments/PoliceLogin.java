package com.ltrsoft.police_mannagement_system.fragments;

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
import androidx.fragment.app.FragmentManager;

import com.ltrsoft.police_mannagement_system.AnalysisFragment.ACPDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.DySpDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.PIDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.PSIDashboard;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.navigation.Navigationfragment;
import com.ltrsoft.police_mannagement_system.utils.SessionManager;
import com.ltrsoft.police_mannagement_system.utils.UserDataAccess;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PoliceLogin extends Fragment {
    private EditText email;
    private EditText password;
    Fragment fragment;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private Button loginButton;
    private View view;
    private String URLS ="https://rj.ltr-soft.com/public/police_api/login/user_login.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.police_login, container, false);
        initizilise();
        return view;
    }

    private void initizilise() {
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
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
                if (!(email.getText().toString().trim()).isEmpty()){
                    if (!(password.getText().toString().isEmpty())){
                        loginUser(email.getText().toString(), password.getText().toString());
                    }
                    else {
                        password.setError("Enter Internal id");
                    }
                }
                else {
                    email.setError("this is compulsory field");
                }
            }
        });
    }

    private void loginUser(String kgid, String internal) {
        DAO dao = new DAO(getContext());
        HashMap<String ,String> map = new HashMap<>();
        map.put("email",kgid);
        map.put("password",internal);
        Toast.makeText(getContext(), kgid, Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(), internal, Toast.LENGTH_SHORT).show();
        dao.getData(map, URLS, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error is "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "result "+object, Toast.LENGTH_SHORT).show();
                loadFragment(new Navigationfragment());
                SessionManager sessionManager = new SessionManager(getContext());
                sessionManager.setLogin(true);
//                try {
//                    JSONObject response = new JSONObject(String.valueOf(object));
//                    String Message = response.getString("Message");
//                    if (Message.equals("100")) {
//                        String position = response.getString("position");
//                        JSONObject data = response.getJSONObject("data");
//                        Toast.makeText(getContext(), "Position "+position, Toast.LENGTH_SHORT).show();
//                        loadFragment(new Navigationfragment());
//                    }
//                }catch (JSONException e){
//                }
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.main_container,fragment)
                .commit();
    }

}
