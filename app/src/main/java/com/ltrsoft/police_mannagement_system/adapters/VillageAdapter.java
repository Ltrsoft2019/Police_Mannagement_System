package com.ltrsoft.police_mannagement_system.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Fragment.analysis.FirDetail;
import com.ltrsoft.police_mannagement_system.Model.Villagemodel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class VillageAdapter extends RecyclerView.Adapter<VillageAdapter.viewholder>{
ArrayList<Villagemodel>list;

    public VillageAdapter(ArrayList<Villagemodel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.villagecard,parent,false);

      return new viewholder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
      Villagemodel villagemodel=list.get(position);
      holder.villagename.append(" "+villagemodel.getVillagename());
      holder.bitname.append(" "+villagemodel.getBitname());
      holder.totalcases.append(" "+villagemodel.getTotalcases());
      holder.villagecard.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Context context= view.getContext();
              AppCompatActivity activity= (AppCompatActivity) context;
              activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FirDetail()).addToBackStack(null).commit();
          }
      });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
     private TextView villagename,bitname,totalcases;
     private CardView villagecard;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            villagecard=itemView.findViewById(R.id.villagecard);
            villagename=itemView.findViewById(R.id.villagename);
            bitname=itemView.findViewById(R.id. bitno);
            totalcases=itemView.findViewById(R.id.total_case);
        }
    }
}
