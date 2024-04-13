package com.ltrsoft.police_mannagement_system.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Mick {
    private EditText editText;
    private ImageView imageView;
    private Context context;

    public Mick( Context context) {
        this.context=context;
    }
    int REQUEST_RECORD_AUDIO_PERMISSION = 1000;
    public void  startListening(EditText editText, ImageView imageView){
        this.editText = editText;
        this.imageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions((Activity) context, new String[]{android.Manifest.permission.RECORD_AUDIO},
                            REQUEST_RECORD_AUDIO_PERMISSION);
                    Toast.makeText(context.getApplicationContext(), " not", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(context.getApplicationContext(), " granted", Toast.LENGTH_SHORT).show();
                    SpeechListener listener = new SpeechListener(editText);
                    listener.startListening();
                }
//                SpeechListener speechListener = new SpeechListener(editText);
//                speechListener.startListening();
            }
        });
    }
}
