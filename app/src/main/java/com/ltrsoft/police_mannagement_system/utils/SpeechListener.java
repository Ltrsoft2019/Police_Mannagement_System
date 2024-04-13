package com.ltrsoft.police_mannagement_system.utils;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SpeechListener implements RecognitionListener {

    EditText editText;
        private static final int REQUEST_RECORD_AUDIO_PERMISSION = 1;
        private SpeechRecognizer speechRecognizer;
        private Intent recognizerIntent;
    public SpeechListener(EditText editText) {
        this.editText = editText;
        this.speechRecognizer = SpeechRecognizer.createSpeechRecognizer(editText.getContext());
        this.speechRecognizer.setRecognitionListener(this);
        this.recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        this.recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        this.recognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
    }

    public void startListening(){
        this.speechRecognizer.startListening(this.recognizerIntent);
    }
    @Override
    public void onReadyForSpeech(Bundle bundle) {
        Toast.makeText(editText.getContext(), "on event started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBeginningOfSpeech() {
        Toast.makeText(editText.getContext(), "on event started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRmsChanged(float v) {
        Toast.makeText(editText.getContext(), "on event started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBufferReceived(byte[] bytes) {
        Toast.makeText(editText.getContext(), "on buffered received", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onEndOfSpeech() {
        Toast.makeText(editText.getContext(), "on event ended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int i) {
        Toast.makeText(editText.getContext(), "on Error started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResults(Bundle bundle) {
        Toast.makeText(editText.getContext(), "on result started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPartialResults(Bundle bundle) {
        ArrayList<String> partialMatches = bundle
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        if (partialMatches != null) {
            // Update the text view with partial results
            editText.setText(partialMatches.get(0));
        }
    }

    @Override
    public void onEvent(int i, Bundle bundle) {
        Toast.makeText(editText.getContext(), "on event started", Toast.LENGTH_SHORT).show();
    }
}
