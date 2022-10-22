package com.example.notoptimusprime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.notoptimusprime.R;
import com.example.notoptimusprime.model.Speaker;

public class SpeakerDetailActivity extends AppCompatActivity {
    String ngrok = "https://ed94-2407-7000-8955-b100-bc00-4e9f-118-f242.au.ngrok.io";

    LottieAnimationView lottieAnimationView;
    TextView tvSpeaker, tvIntelligibility, tvCommand, dysarthricPrediction, normalPrediction;
    Button btn, normalSpeechBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_speaker_detail);

        lottieAnimationView = findViewById(R.id.animation);
        tvSpeaker = (TextView) findViewById(R.id.speaker_details);
        tvIntelligibility = (TextView) findViewById(R.id.speaker_intelligibility_details);
        tvCommand = (TextView) findViewById(R.id.speaker_command_details);
        dysarthricPrediction = (TextView) findViewById(R.id.DysarthricPrediction);
        normalPrediction = (TextView) findViewById(R.id.NormalPrediction);
        btn = findViewById(R.id.button_dysarthric);
        normalSpeechBtn = findViewById(R.id.button_normal);

        Intent thisIntent = getIntent();

        //Use the book to populate the data into our views

        Speaker speaker = (Speaker) thisIntent.getSerializableExtra(MainActivity.SPEAKER_DETAIL_KEY);

        String speakerFilename = speaker.getOriginalFileName();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                lottieAnimationView.playAnimation();
                lottieAnimationView.setVisibility(View.VISIBLE);
                RequestQueue queue = Volley.newRequestQueue(SpeakerDetailActivity.this);
                String url = ngrok +"/dysarthric_speech/" + speakerFilename;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(SpeakerDetailActivity.this, response, Toast.LENGTH_SHORT).show();
                                dysarthricPrediction.setText("Prediction: " + response);
                                lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
                                lottieAnimationView.pauseAnimation();
                                lottieAnimationView.setVisibility(View.INVISIBLE);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                        Toast.makeText(SpeakerDetailActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                stringRequest.setRetryPolicy(new DefaultRetryPolicy(400000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(stringRequest);

            }
        });



        normalSpeechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                lottieAnimationView.playAnimation();
                lottieAnimationView.setVisibility(View.VISIBLE);
                RequestQueue queue = Volley.newRequestQueue(SpeakerDetailActivity.this);
                String url = ngrok + "/normal_speech/" + speakerFilename;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(SpeakerDetailActivity.this, response, Toast.LENGTH_SHORT).show();
                                normalPrediction.setText("Prediction: " + response);
                                lottieAnimationView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
                                lottieAnimationView.pauseAnimation();
                                lottieAnimationView.setVisibility(View.INVISIBLE);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);
                        Toast.makeText(SpeakerDetailActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                stringRequest.setRetryPolicy(new DefaultRetryPolicy(400000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                queue.add(stringRequest);

            }
        });

        loadSpeaker(speaker);
    }

    private void loadSpeaker(Speaker speaker){
        //Change activity title
        tvSpeaker.setText(speaker.getSpeakerName());
        tvIntelligibility.setText(speaker.getIntelligibility());
        tvCommand.setText(speaker.getCommand());
    }
}