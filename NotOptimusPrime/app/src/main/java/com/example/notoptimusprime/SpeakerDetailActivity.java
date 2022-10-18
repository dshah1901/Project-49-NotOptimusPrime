package com.example.notoptimusprime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.notoptimusprime.R;
import com.example.notoptimusprime.model.Speaker;

public class SpeakerDetailActivity extends AppCompatActivity {

    TextView tvSpeaker, tvIntelligibility, tvCommand;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_speaker_detail);

        tvSpeaker = (TextView) findViewById(R.id.speaker_details);
        tvIntelligibility = (TextView) findViewById(R.id.speaker_intelligibility_details);
        tvCommand = (TextView) findViewById(R.id.speaker_command_details);

        Intent thisIntent = getIntent();

        //Use the book to populate the data into our views

        Speaker speaker = (Speaker) thisIntent.getSerializableExtra(MainActivity.SPEAKER_DETAIL_KEY);

        String speakerFilename = speaker.getOriginalFileName();

        loadSpeaker(speaker);
    }

    private void loadSpeaker(Speaker speaker){
        //Change activity title
        tvSpeaker.setText(speaker.getSpeakerName());
        tvIntelligibility.setText(speaker.getIntelligibility());
        tvCommand.setText(speaker.getCommand());
    }
}