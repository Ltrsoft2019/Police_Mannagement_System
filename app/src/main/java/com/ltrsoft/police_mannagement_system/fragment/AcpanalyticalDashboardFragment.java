package com.ltrsoft.police_mannagement_system.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_mannagement_system.R;

import java.util.Timer;
import java.util.TimerTask;

public class AcpanalyticalDashboardFragment extends Fragment {
    private HorizontalScrollView horizontalScrollView;
    private int currentLayoutIndex = 0;
    private Timer timer;
    private Handler handler;


    public AcpanalyticalDashboardFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acpanlyticaldashboard, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        handler = new Handler();

        // Schedule automatic sliding
        timer = new Timer();
        // Interval between slides in milliseconds
        long INTERVAL = 2000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        slideToNextLayout();
                    }
                });
            }
        }, 0, INTERVAL);
        return  view;
    }

    private void slideToNextLayout() {
        currentLayoutIndex++;
        // Total number of ConstraintLayouts
        int NUM_LAYOUTS = 10;
        if (currentLayoutIndex >= NUM_LAYOUTS) {
            currentLayoutIndex = 0;
        }
System.out.println("index= "+ horizontalScrollView.getWidth());
        int scrollTo = currentLayoutIndex * horizontalScrollView.getWidth();
        horizontalScrollView.smoothScrollTo(scrollTo, 0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Cancel the timer task
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
