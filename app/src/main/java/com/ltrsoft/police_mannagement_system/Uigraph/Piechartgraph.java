package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class Piechartgraph {
    ArrayList<PiechartModelclass> list;
    private Context context;
    LinearLayout layout;

    public Piechartgraph(ArrayList<PiechartModelclass> list, LinearLayout layout) {
        this.list = list;
        this.layout = layout;
        this.context=layout.getContext();
    }

//    public void setpie(PieChart pieChart) {
//        pieChart.clearChart(); // Clear existing pie chart data
//        for (PiechartModelclass model : list) {
//            pieChart.addPieSlice(new PieModel(model.getLabel(), model.getValue(), Color.parseColor(model.getColor())));
//        }
//        pieChart.startAnimation();
//    }


    public  void setpie(PieChart chart){
        for (PiechartModelclass modellist :list){

            chart.addPieSlice(
            new PieModel(
                        modellist.getLabel(), modellist.getValue(), Color.parseColor(modellist.getColorcode())));
        }
        setcardlist();
       chart.startAnimation();
     }



     public void setcardlist(){
         CardView cardView=new CardView(context);
       LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT,
               ViewGroup.LayoutParams.WRAP_CONTENT
       );
         layoutParams.setMargins(30, 20, 30, 20);
         cardView.setLayoutParams(layoutParams);
         cardView.setCardBackgroundColor(Color.WHITE);
         cardView.setRadius(15);
         cardView.setCardElevation(2);


         LinearLayout linearLayout1=new LinearLayout(context);
       linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT,
               ViewGroup.LayoutParams.WRAP_CONTENT
       ));
            linearLayout1.setOrientation(LinearLayout.VERTICAL);
           for (PiechartModelclass modellist :list){
               LinearLayout linearLayout2=new LinearLayout(context);
               linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(
                  ViewGroup.LayoutParams.MATCH_PARENT,
                       ViewGroup.LayoutParams.WRAP_CONTENT
               ));
               linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

               View  view=new View(context);
               LinearLayout.LayoutParams viewlayout=new LinearLayout.LayoutParams(
                        0,
                       ViewGroup.LayoutParams.WRAP_CONTENT,
                       1
               );

               int color=Color.parseColor(modellist.getColorcode());
                view.setBackgroundColor(color);
                 view.setPadding(10,10,0,0);
                 view.setLayoutParams(viewlayout);
                TextView textView=new TextView(context);
               LinearLayout.LayoutParams textviewparam=new LinearLayout.LayoutParams(
                       0,
                       ViewGroup.LayoutParams.WRAP_CONTENT,
                       1
               );

                textView.setText(modellist.getLabel());
                textView.setLayoutParams(textviewparam);
               linearLayout2.addView(view);
               linearLayout2.addView(textView);
                linearLayout1.addView(linearLayout2);
           }
         cardView.addView(linearLayout1);
         layout.addView(cardView);
     }

}
