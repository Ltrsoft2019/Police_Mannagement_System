package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
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
               layoutParams.setMargins(10,  10, 10, 10);

               View  view=new View(context);
               LinearLayout.LayoutParams viewlayout=new LinearLayout.LayoutParams(
                        0,
                       (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30
                               , context.getResources().getDisplayMetrics()), // Adjust width as needed
                       1
               );

               int color=Color.parseColor(modellist.getColorcode());
               view. setBackgroundColor(color);
              viewlayout.setMargins(10,13,120,5);
                  view.setPadding(15,13,0,0);
                 view.setLayoutParams(viewlayout);
                TextView textView=new TextView(context);
               LinearLayout.LayoutParams textviewparam=new LinearLayout.LayoutParams(
                       0,
                       (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, context.getResources().getDisplayMetrics()),
                       1
               );

                textView.setText(modellist.getLabel()+" :");
               textviewparam.setMargins(5,10,120,0);
               textView.setPadding(0,10,0,0);
                textView.setLayoutParams(textviewparam);
               TextView textView2=new TextView(context);
               LinearLayout.LayoutParams textviewparam2=new LinearLayout.LayoutParams(
                       0,
                       (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, context.getResources().getDisplayMetrics()),
                       1
               );

               textView2.setText(String.valueOf(modellist.getValue()));
               textviewparam2.setMargins(5,10,50,0);
               textView2.setPadding(0,10,0,0);
               textView2.setLayoutParams(textviewparam2);
                linearLayout2.addView(view);
               linearLayout2.addView(textView);
               linearLayout2.addView(textView2);

               linearLayout1.addView(linearLayout2);
           }
         cardView.addView(linearLayout1);
         layout.addView(cardView);
     }

}
