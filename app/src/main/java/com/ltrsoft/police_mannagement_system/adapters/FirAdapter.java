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

import com.ltrsoft.police_mannagement_system.Fragment.analysis.FirAnalysis;
import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class FirAdapter extends RecyclerView.Adapter<FirAdapter.ViewHolder>{
    ArrayList <FirModel >models;

    public FirAdapter(ArrayList<FirModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fir_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FirModel model = models.get(position);
    holder.id.setText(model.getFir_id());
    holder.name.setText(model.getFir_name());
    holder.card.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context=v.getContext();
            AppCompatActivity activity= (AppCompatActivity) context;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FirAnalysis());
        }
    });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id,name;
        public CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card=itemView.findViewById(R.id.fircard);
            id=itemView.findViewById(R.id.fir_id);
            name=itemView.findViewById(R.id.fir_type);
        }
    }
}
