package com.ltrsoft.police_mannagement_system.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ltrsoft.police_mannagement_system.fragments.Analysis1;
import com.ltrsoft.police_mannagement_system.fragments.Analysis2;
import com.ltrsoft.police_mannagement_system.fragments.Analysis3;
import com.ltrsoft.police_mannagement_system.fragments.Analysis4;

public class AnalysisPageAdapter extends FragmentStateAdapter {
    public AnalysisPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new Analysis1();
        } else if (position==1) {
            Analysis2 addComplaintOnBehalf = new Analysis2();
            return addComplaintOnBehalf;
        }
        else if (position==2){
            return new Analysis3();
        }
        else if (position==3){
            return new Analysis4();
        }

       else return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
