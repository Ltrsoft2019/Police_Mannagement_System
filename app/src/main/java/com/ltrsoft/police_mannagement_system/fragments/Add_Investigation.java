package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Interfaces.NewCallBack;
import com.ltrsoft.police_mannagement_system.Model.Criminal;
import com.ltrsoft.police_mannagement_system.Model.Evidance;
import com.ltrsoft.police_mannagement_system.Model.Suspect;
import com.ltrsoft.police_mannagement_system.Model.Victims;
import com.ltrsoft.police_mannagement_system.Model.Witnesses;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;
import com.ltrsoft.police_mannagement_system.adapters.SuspectAdapter1;
import com.ltrsoft.police_mannagement_system.deo.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class Add_Investigation extends Fragment {


    public Add_Investigation() {

     }
     private String Evidance_by_complainr_id="https://rj.ltr-soft.com/public/police_api/complaint_evidance/by_complaint_id.php";
     private String Witness_by_complaint_id="https://rj.ltr-soft.com/public/police_api/complaint_witness/id_complaint_witness.php";
     private String Victim_by_complaintid="https://rj.ltr-soft.com/public/police_api/complaint_victim/complaint_id_victim.php";
     private String Suspects_by_complaintid="https://rj.ltr-soft.com/public/police_api/complaint_suspect/complaint_id_suspect.php";
     View rootView;
    Fragment fragment;
    private TextView complaintIdTextView,investigationStartTextView, investigationEndDateTextView,
     locationTextView,incidentReportingTextView,evidencePropertyTextView,investigationDescriptionTextView;
    private ImageView microphoneImage1,microphoneImage2,microphoneImage3 ,microphoneImage4,
   suspectViewImageView , suspectPlusImageView ,victimViewImageView ,victimPlusImageView,
    witnessViewImageView , witnessPlusImageView , evidenceViewImageView ,evidencePlusImageView;
     private CardView suspectCardView,victimCardView,witnessCardView,evidenceCardView;
     private RecyclerView suspectRecyclerView , victimRecyclerView, witnessRecyclerView, evidenceRecyclerView;
     private Button nextButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            rootView= inflater.inflate(R.layout.add__investigation, container, false);
        setid();
        clicklist();
        setsuspectadapter();
        setvictimadapter();
        setwitnessadapter();
        evidanceadapter();


        suspectCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newVisibility = ( locationTextView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                locationTextView.setVisibility( newVisibility);int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                suspectRecyclerView.setVisibility(oppositeVisibility);

            }
        });
        victimCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newVisibility = ( locationTextView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                locationTextView.setVisibility( newVisibility);int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                victimRecyclerView.setVisibility(oppositeVisibility);

            }
        });
       witnessCardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int newVisibility = ( locationTextView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
               locationTextView.setVisibility( newVisibility);int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
               witnessRecyclerView.setVisibility(oppositeVisibility);
           }
       });
       evidenceCardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int newVisibility = ( locationTextView.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
               locationTextView.setVisibility( newVisibility);int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
               evidenceRecyclerView.setVisibility(oppositeVisibility);
           }
       });


    return rootView;
    }
    private void setid(){
        complaintIdTextView = rootView.findViewById(R.id.complaint_id);
        investigationStartTextView = rootView.findViewById(R.id.investigation_start);
        investigationEndDateTextView = rootView.findViewById(R.id.investigation_end_date);
        locationTextView = rootView.findViewById(R.id.location);
        incidentReportingTextView = rootView.findViewById(R.id.incidant_reporting);
        evidencePropertyTextView = rootView.findViewById(R.id.evidance_property);
        investigationDescriptionTextView = rootView.findViewById(R.id.investigation_description);
        microphoneImage1 = rootView.findViewById(R.id.mike_img1);
        microphoneImage2 = rootView.findViewById(R.id.mike_img2);
        microphoneImage3 = rootView.findViewById(R.id.mike_img3);
        microphoneImage4 = rootView.findViewById(R.id.mike_img4);
        suspectViewImageView = rootView.findViewById(R.id.Suspect_View);
        suspectPlusImageView = rootView.findViewById(R.id.Suspect_plus);
        victimViewImageView = rootView.findViewById(R.id.Victim_view);
        victimPlusImageView = rootView.findViewById(R.id.Victim_plus);
        witnessViewImageView = rootView.findViewById(R.id.Witness_View);
        witnessPlusImageView = rootView.findViewById(R.id.Witness_plus);
        evidenceViewImageView = rootView.findViewById(R.id.Evidance_View);
        evidencePlusImageView = rootView.findViewById(R.id.Evidance_plus);
        suspectCardView = rootView.findViewById(R.id.suspect_card);
        victimCardView = rootView.findViewById(R.id.victim_card);
        witnessCardView = rootView.findViewById(R.id.witness_card);
        evidenceCardView = rootView.findViewById(R.id.evidence_card);
        suspectRecyclerView = rootView.findViewById(R.id.suspect_recycler);
        victimRecyclerView = rootView.findViewById(R.id.Victim_recycler);
        witnessRecyclerView = rootView.findViewById(R.id.Witness_recycler);
        evidenceRecyclerView = rootView.findViewById(R.id.Evidance_recycler);

         nextButton = rootView.findViewById(R.id.next_btn);

    }


    private void loadfragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fraglayot,fragment).addToBackStack(null).commit();
    }
    private void clicklist(){
        suspectPlusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new Add_Suspect();
                loadfragment(fragment);
            }
        });
        evidencePlusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new Add_Suspect();
                loadfragment(fragment);
            }
        });
        victimPlusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new Add_Suspect();
                loadfragment(fragment);
            }
        });
        witnessPlusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment=new Add_Suspect();
                loadfragment(fragment);
            }
        });
    }
    private void setsuspectadapter()
    {
        DAO dao=new DAO(getContext());
        dao.select(Suspect.class, "complaint_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>> maps = new ArrayList<>();
                ArrayList<Suspect>models= (ArrayList<Suspect>) object;
                for(Suspect model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "Suspect Id :"+model.getSuspect_id());
                    map.put("map2","Suspect Full Name :"+ model.getFull_name());
                    map.put("map3", "Suspect Address :"+model.getAddress());
                    map.put("map4", "Gender :"+model.getGender());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                suspectRecyclerView.setLayoutManager(layoutManager);
                suspectRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(),"No data available",Toast.LENGTH_SHORT).show();

            }
        },Suspects_by_complaintid);

    }
    public void setvictimadapter(){
        DAO dao=new DAO(getContext());
        dao.select(Victims.class, "complaint_id", "1", new NewCallBack() {
            @Override
            public void onError(String error) {
                Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(Object object) {
                ArrayList<HashMap<String,String>> maps = new ArrayList<>();
                ArrayList<Victims>models= (ArrayList<Victims>) object;
                for(Victims model:models){
                    HashMap<String,String>map=new HashMap<>();
                    map.put("map1", "Victim Id :"+model.getVictim_id());
                    map.put("map2","Victim Full Name :"+ model.getFull_name());
                    map.put("map3", "Victim Address :"+model.getAddress());
                    map.put("map4", "Gender :"+model.getGender());
                    maps.add(map);
                }
                CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                victimRecyclerView.setLayoutManager(layoutManager);
                victimRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onEmpty() {
                Toast.makeText(getContext(),"No data available",Toast.LENGTH_SHORT).show();

            }
        },Victim_by_complaintid);

    }
   public void setwitnessadapter(){
       DAO dao=new DAO(getContext());
       dao.select(Witnesses.class, "complaint_id", "1", new NewCallBack() {
           @Override
           public void onError(String error) {
               Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onSuccess(Object object) {
               ArrayList<HashMap<String,String>> maps = new ArrayList<>();
               ArrayList<Witnesses>models= (ArrayList<Witnesses>) object;
               for(Witnesses model:models){
                   HashMap<String,String>map=new HashMap<>();
                   map.put("map1", "Witness Id :"+model.getWitness_id());
                   map.put("map2","Witness Full Name :"+ model.getFull_name());
                   map.put("map3", "Witness Address :"+model.getAddress());
                   map.put("map4", "Gender :"+model.getGender());
                   maps.add(map);
               }
               CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
               LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
               witnessRecyclerView.setLayoutManager(layoutManager);
               witnessRecyclerView.setAdapter(adapter);
           }

           @Override
           public void onEmpty() {
               Toast.makeText(getContext(),"No data available",Toast.LENGTH_SHORT).show();

           }
       },Witness_by_complaint_id);


   }
   public void evidanceadapter(){
       DAO dao=new DAO(getContext());
       dao.select(Evidance.class, "complaint_id", "1", new NewCallBack() {
           @Override
           public void onError(String error) {
               Toast.makeText(getContext(),"error",Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onSuccess(Object object) {
               ArrayList<HashMap<String,String>> maps = new ArrayList<>();
               ArrayList<Evidance>models= (ArrayList<Evidance>) object;
               for(Evidance model:models){
                   HashMap<String,String>map=new HashMap<>();
                   map.put("map1", "Evidance Id :"+model.getEvidence_id());
                   map.put("map2","Evidance Type :"+ model.getEvidance_type_id());
                  // map.put("map3", "Evidance Address :"+model.getAddress());
                   map.put("map4", "Description :"+model.getItem_description());
                   maps.add(map);
               }
               CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
               LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
               witnessRecyclerView.setLayoutManager(layoutManager);
               witnessRecyclerView.setAdapter(adapter);
           }

           @Override
           public void onEmpty() {
               Toast.makeText(getContext(),"No data available",Toast.LENGTH_SHORT).show();

           }
       },Evidance_by_complainr_id);

   }
    private void updateCardClickability(CardView cardView, boolean clickable) {
        cardView.setClickable(clickable);
        cardView.setFocusable(clickable);
    }
}