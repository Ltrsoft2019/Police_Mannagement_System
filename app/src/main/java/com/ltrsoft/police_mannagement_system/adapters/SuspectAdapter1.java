package com.ltrsoft.police_mannagement_system.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SuspectAdapter1 extends RecyclerView.Adapter <SuspectAdapter1.viewholder>{


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
