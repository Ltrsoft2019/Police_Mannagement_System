package com.ltrsoft.police_mannagement_system.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Fragment.analysis.Station_Analysis;
import com.ltrsoft.police_mannagement_system.Model.Stationmodel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.Viewholder>{
  public ArrayList<Stationmodel>list;

    public StationAdapter(ArrayList<Stationmodel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stationcard,parent,false);
    return new Viewholder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Stationmodel district = list.get(position);
    holder.t1.setText("Station Name :  "+district.getUnitName());

    holder.stationcard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Context context= view.getContext();

            AppCompatActivity activity= (AppCompatActivity) context;
            Station_Analysis stationAnalysis=new Station_Analysis();
            Bundle bundle=new Bundle();
            bundle.putString("Unit_ID", district.getUnit_ID());
            stationAnalysis.setArguments(bundle);

           activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,stationAnalysis).addToBackStack(null).commit();
        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
     private TextView t1;
     private CardView stationcard;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.stationname);
            stationcard=itemView.findViewById(R.id.stationcard);
        }
    }
}
