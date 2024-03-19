package com.ltrsoft.police_mannagement_system.Fragment.analys;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.HashMap;


public class DySpList extends Fragment {

    public DySpList() {}
    public static final String URLS = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dy_sp_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.dysp_list);
        DAO dao =  new DAO(getContext());
        HashMap<String,String>map=new HashMap<>();
        map.put("KGID",getArguments().getString("KGID"));
        dao.getData(map, URLS, new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), "error ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "response "+object.getClass(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(), "empty ", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}