package com.ltrsoft.police_mannagement_system.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Fragment.analysis.Filter_month;
import com.ltrsoft.police_mannagement_system.Fragment.analysis.FirFragment;
import com.ltrsoft.police_mannagement_system.Model.Monthmodel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;


public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{
    ArrayList<Monthmodel> list;

    public MonthAdapter(ArrayList<Monthmodel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_card,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Monthmodel monthmodel=list.get(position);
      holder.t1.append(monthmodel.getMonthname());
        holder.t2.append(monthmodel.getTotalcases());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity= (AppCompatActivity) context;
                activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fraglayot,new FirFragment()).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.monthname);
            t2=itemView.findViewById(R.id.total_case);
            cardView=itemView.findViewById(R.id.monthcard);
        }
    }
}
