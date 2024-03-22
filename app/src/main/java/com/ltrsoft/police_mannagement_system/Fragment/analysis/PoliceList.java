package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.HashMap;

public class PoliceList extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fir_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fir_list_recycler);
        DAO dao = new DAO(getContext());
        Bundle bundle = getArguments();
        String unit_id = bundle.getString("Unit_Id");
        HashMap<String,String>map=new HashMap<>();
//        map.put("")
//        dao.getData();
        return view;
    }
}
