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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Model.PolicePosition;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.MyHolder> {
    private ArrayList<PolicePosition>policePositions;
    private Fragment fragment;
    public PoliceAdapter(ArrayList<PolicePosition> policePositions, Fragment fragment) {
        this.policePositions = policePositions;
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.constable_card,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        PolicePosition position1 = policePositions.get(position);
        holder.police_name.setText(position1.getIOName());
        holder.batch_no.setText(position1.getKGID());

        holder.police_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("KGID "+position1.getKGID());
                Context context= v.getContext();
                AppCompatActivity activity= (AppCompatActivity) context;

                Bundle bundle=new Bundle();
                bundle.putString("KGID",position1.getKGID());
                bundle.putString("IONAME",position1.getIOName());

                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fraglayot,fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return policePositions.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView batch_no,police_name;
        private CardView police_card;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.batch_no =itemView.findViewById(R.id.batch_no);
            this.police_name =itemView.findViewById(R.id.police_name);
            this.police_card =itemView.findViewById(R.id.police_card);
        }
    }
}
