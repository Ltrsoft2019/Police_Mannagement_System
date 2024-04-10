package com.ltrsoft.police_mannagement_system.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.MyHolder> {
    ArrayList<HashMap<String,String>>maps;
    int imagesrc;

    public CommonAdapter(ArrayList<HashMap<String, String>> maps,int imgsrc) {
        this.maps = maps;
        this.imagesrc=imgsrc;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_recycle_layout,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        HashMap <String,String>hashMap = maps.get(position);
        holder.img.setImageResource(imagesrc);
        for (int i = 0; i < hashMap.size(); i++) {
            switch (i){
                case 0:
                    holder.t1.setText(hashMap.get("map1"));
                    break;
                case 1:
                    holder.t2.setText(hashMap.get("map2"));
                    break;
                case 2:
                    holder.t3.setText(hashMap.get("map3"));
                    break;
                case 3:
                    holder.t4.setText(hashMap.get("map4"));
                    break;
            }
            if (holder.t1.getText().length()<0){
                holder.t1.setVisibility(View.GONE);
            }else if (holder.t2.getText().length()<0){
                holder.t2.setVisibility(View.GONE);
            }
            else if (holder.t3.getText().length()<0){
                holder.t3.setVisibility(View.GONE);
            }
            else if (holder.t4.getText().length()<0){
                holder.t4.setVisibility(View.GONE);
            }

            System.out.println("Visisbility "+holder.t3.getVisibility());

        }
    }

    @Override
    public int getItemCount() {
        return maps.size();
    }

    public class  MyHolder extends  RecyclerView.ViewHolder{
        private TextView t1,t2,t3,t4;
        private ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_logo);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t4=itemView.findViewById(R.id.t4);
        }
    }
}
