package com.ltrsoft.police_mannagement_system.Uigraph;

import android.content.Context;
import android.graphics.Color;

import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.ArrayList;

public class Bargraphchart {
    Context context;
    ArrayList<BargraphModelclass>list;

    public Bargraphchart(ArrayList<BargraphModelclass> list) {
        this.list = list;
    }

    public  void setbargraph(BarChart barChart){
        for (BargraphModelclass barlist:list){
            BarModel model=new BarModel(barlist.getLabel(),barlist.getValue(), Color.parseColor(barlist.getColorcode()));
            barChart.addBar(model);
        }
        barChart.setBarWidth(0.1f);
        barChart.setElevation(.2f);
        barChart.startAnimation();

    }


}
