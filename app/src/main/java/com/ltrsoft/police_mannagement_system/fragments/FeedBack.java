package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Feedback;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.deo.DAO;

public class FeedBack extends Fragment {
    public FeedBack() {}
    private RatingBar satisfaction, trustConfidence, qualityOfService, fairness, timeTaken,training_support,usability_navigation;
    private Button submit;
    private EditText bribeDescription;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_back, container, false);

        training_support=view.findViewById(R.id.training_support);
        usability_navigation=view.findViewById(R.id.usability_navigation);
        satisfaction = view.findViewById(R.id.satisfaction);
        trustConfidence = view.findViewById(R.id.confidance);
        qualityOfService = view.findViewById(R.id.quality_of_service);
        fairness = view.findViewById(R.id.fairness);
        timeTaken = view.findViewById(R.id.time_taken);
        submit = view.findViewById(R.id.submit_feedback);

        DAO dao = new DAO(getContext());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String support = String.valueOf(training_support.getRating());
               String usability = String.valueOf(usability_navigation.getRating());
               String satisfact = String.valueOf(satisfaction.getRating());
               String trust = String.valueOf(trustConfidence.getRating());
               String quality = String.valueOf(qualityOfService.getRating());
               String fairnes = String.valueOf(fairness.getRating());
               String time = String.valueOf(timeTaken.getRating());
                Feedback feedback = new Feedback(satisfact,usability,support,fairnes,time,
                        quality,trust,"1");
               dao.insertOrUpdate(feedback, new NewCallBack() {
                   @Override
                   public void onError(String error) {
                       Toast.makeText(getContext(), "Error  "+error, Toast.LENGTH_SHORT).show();
                   }
                   @Override
                   public void onSuccess(Object object) {
                       Toast.makeText(getContext(), "Resposne "+object, Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onEmpty() {
                       Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
                   }
               }, "https://rj.ltr-soft.com/public/police_api/police_feedback/create_p_feed.php");
            }
        });

        return view;
    }
}