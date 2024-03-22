package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.FircardModel;
import com.ltrsoft.police_mannagement_system.adapters.PoliceFirAdapter;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
            dao.getData(map, GETFIR, new NewCallBack() {
                @Override
                public void onError(String error) {
                    Toast.makeText(context, "error "+error, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(Object object) {
//                    Toast.makeText(context, "Resposne"+object, Toast.LENGTH_SHORT).show();
                    ArrayList<FircardModel>list=new ArrayList<>();
                    try {
                        JSONObject jsonObject =new JSONObject(String.valueOf(object));
                        String count = jsonObject.getString("count");
                        JSONArray firs = jsonObject.getJSONArray("data");
                        for (int i = 0; i < firs.length(); i++) {
                            JSONObject fir = firs.getJSONObject(i);
                            Gson gson = new Gson();
                            FircardModel model = gson.fromJson(fir.toString(), FircardModel.class);
                            list.add(model);
                        }
                        PoliceFirAdapter policeFirAdapter=new PoliceFirAdapter(list);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(policeFirAdapter);
                    }catch (JSONException e){
                        Toast.makeText(context, "error while loading", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onEmpty() {
                    Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show();
                }
            });
     }


}
