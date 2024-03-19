package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.FircardModel;
import com.ltrsoft.police_mannagement_system.adapters.PoliceFirAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class GettingFirRecycler {
    private RecyclerView recyclerView;
    private String KGID;
    private Context context;
    private String GETFIR="https://rj.ltr-soft.com/dataset_api/fir_tbl/assigned_fir_by_police.php";

    public GettingFirRecycler(RecyclerView recyclerView, String KGID) {
        this.recyclerView = recyclerView;
        this.KGID = KGID;
       context=recyclerView.getContext();
    }
     public void setrecyclerview(){
         DAO dao=new DAO( context);
         HashMap<String,String> map = new HashMap<>();
         map.put("KGID",KGID);
         dao.select(FircardModel.class, "KGID", KGID, new NewCallBack() {
             @Override
             public void onError(String error) {
                 Toast.makeText(context, "error = "+error, Toast.LENGTH_SHORT).show();

             }

             @Override
             public void onSuccess(Object object) {

                 ArrayList<FircardModel> list= (ArrayList<FircardModel>) object;
                 PoliceFirAdapter policeFirAdapter=new PoliceFirAdapter(list);
                 LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                 recyclerView.setLayoutManager(layoutManager);
                 recyclerView.setAdapter(policeFirAdapter);
             }

             @Override
             public void onEmpty() {
                 Toast.makeText( context, "Its empty Dude", Toast.LENGTH_SHORT).show();

             }
         },GETFIR);

     }


}
