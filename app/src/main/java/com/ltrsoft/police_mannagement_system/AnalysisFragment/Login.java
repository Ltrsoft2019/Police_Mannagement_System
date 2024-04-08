package com.ltrsoft.police_mannagement_system.AnalysisFragment;

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


import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;
import com.ltrsoft.police_mannagement_system.utils.SessionManager;
import com.ltrsoft.police_mannagement_system.utils.UserDataAccess;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends Fragment {
    private EditText kgid;
    private EditText interanlid;
    Fragment fragment;
    private TextView forgotPasswordTextView;
    private TextView signUpTextView;
    private Button loginButton;
    private View view;
    private String URLS ="https://rj.ltr-soft.com/dataset_api/position/login.php";
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
                            loginUser(kgid.getText().toString(),interanlid.getText().toString());
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
        map.put("Internal_IO",internal);
        dao.getData(map, URLS, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error is "+error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
               try {
                   JSONObject response = new JSONObject(String.valueOf(object));
                   String Message = response.getString("Message");
                   if (Message.equals("100")){
                       String position = response.getString("position");
                       JSONObject data = response.getJSONObject("data");

                       String KGID = data.getString("KGID");
                       String IOName = data.getString("IOName");

                       SessionManager sessionManager = new SessionManager(getContext());
                       sessionManager.setLogin(true);
                       UserDataAccess access = new UserDataAccess();
                       access.setKgid(kgid,getActivity());
                       access.setPosition(position,getActivity());
                       access.setPosition(position,getActivity());
                       access.setIOName(IOName,getActivity());
                       Bundle bundle = new Bundle();
                       bundle.putString("KGID",kgid);
                       bundle.putString("IONAME",kgid);
                       if (position.equals("ACP")){
                           Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                           fragment = new ACPDash();
                           fragment.setArguments(bundle);
                            loadFragment(fragment);
                       } else if (position.equals("PI")) {
                           Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                           fragment = new PIDash();
                           fragment.setArguments(bundle);
                            loadFragment(fragment);
                       }else if (position.equals("PSI")) {
                           Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                           fragment = new PSIDashboard();
                           fragment.setArguments(bundle);
                           loadFragment(fragment);
                       }else if (position.equals("Dy.Sp")) {
                           Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
                           fragment = new DySpDash();
                           fragment.setArguments(bundle);
                           loadFragment(fragment);
                       }
                   }
                   else {
                       Toast.makeText(getContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                   }
               }catch (JSONException e){
               }
            }
            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        Fragment prevous = fragmentManager.findFragmentById(R.id.fraglayot);
        fragmentManager
                .beginTransaction()
                .replace(R.id.fraglayot,fragment)
                .commit();
    }


}
