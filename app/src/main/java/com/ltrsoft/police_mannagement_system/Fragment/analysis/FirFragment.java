package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.FirAdapter;

import java.util.ArrayList;

public class FirFragment extends Fragment {
    public FirFragment() {
    }

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fir_list, container, false);
        recyclerView = view.findViewById(R.id.fir_list_recycler);
        setRecycler();
        return view;
    }

    private void setRecycler() {
        ArrayList<FirModel>models=new ArrayList<>();
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));
        models.add(new FirModel("123123","Murder","hinees","latur"));

        FirAdapter adapter = new FirAdapter(models);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
