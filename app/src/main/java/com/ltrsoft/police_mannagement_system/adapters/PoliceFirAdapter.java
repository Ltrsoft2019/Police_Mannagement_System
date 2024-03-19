package com.ltrsoft.police_mannagement_system.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Model.FircardModel;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;

public class PoliceFirAdapter extends RecyclerView.Adapter<PoliceFirAdapter.viewholder>{

 ArrayList<FircardModel>list;

    public PoliceFirAdapter(ArrayList<FircardModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.policefircard,parent,false);

      return new viewholder(view);

     }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
         FircardModel model=list.get(position); 
         holder.unitname.setText(model.getUnitName());
         holder.firno.setText(model.getFIRNo());
         holder.firstate.setText(model.getFIR_Type());
         holder.actsection.setText(model.getFIR_ID());
         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              }
         });
    
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        private TextView firno,firstate,actsection,unitname;
        private CardView cardView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            firno=itemView.findViewById(R.id.Fir_no);
            firstate=itemView.findViewById(R.id.Fir_stages);
            actsection=itemView.findViewById(R.id.Act_Section);
            unitname=itemView.findViewById(R.id.Unit_names);
            cardView=itemView.findViewById(R.id.policefircard);
        }
    }

}