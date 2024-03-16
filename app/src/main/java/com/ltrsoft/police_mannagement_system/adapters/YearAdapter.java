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

import com.ltrsoft.police_mannagement_system.Fragment.analysis.Filter_month;
import com.ltrsoft.police_mannagement_system.Model.YearModel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class YearAdapter extends RecyclerView.Adapter<YearAdapter.ViewHolder>
{
    ArrayList<YearModel>list;

    public YearAdapter(ArrayList<YearModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.year_card,parent,false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YearModel model = list.get(position);
        holder.t1.append(model.getName());
        holder.t2.append(model.getTotalcases());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context  context=view.getContext();
                AppCompatActivity activity= (AppCompatActivity) context;
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fraglayot,new Filter_month() ).addToBackStack(null).commit();

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
            t1=itemView.findViewById(R.id.yearname);
            t2=itemView.findViewById(R.id.total_case);
            cardView=itemView.findViewById(R.id.yearcard);
        }
    }
}
