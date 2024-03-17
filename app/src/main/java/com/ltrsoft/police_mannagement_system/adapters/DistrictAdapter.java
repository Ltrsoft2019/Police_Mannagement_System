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

import com.ltrsoft.police_mannagement_system.Fragment.analysis.DistrictAnalysis;
import com.ltrsoft.police_mannagement_system.Model.District;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.ViewHolder> {
    public ArrayList<District>list;

    public DistrictAdapter(ArrayList<District> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.district_card,parent,false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        District district = list.get(position);
        holder.t1.append("  "+district.getDistrict_name());
        holder.t2.append("\n"+district.getTotalcase());
        holder.t3.append("\n"+district.getTotalpolice());
        holder.districtcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                AppCompatActivity activity= (AppCompatActivity) context;
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new DistrictAnalysis()).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        CardView districtcard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            districtcard=itemView.findViewById(R.id.districtcard);
            t1=itemView.findViewById(R.id.districtname);
            t2=itemView.findViewById(R.id.total_case);
            t3=itemView.findViewById(R.id.total_police);
        }
    }
}
