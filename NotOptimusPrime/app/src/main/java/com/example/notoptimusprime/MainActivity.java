package com.example.notoptimusprime;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.notoptimusprime.adapter.SpeakerAdaptor;
import com.example.notoptimusprime.model.DataProvider;
import com.example.notoptimusprime.model.Speaker;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SPEAKER_DETAIL_KEY = "speaker";
    Button btn;
    ListView listView;
    SpeakerAdaptor itemsAdapter;
    List<Speaker> speakerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Testing the dictionary
        speakerList = DataProvider.getSpeaker();
        itemsAdapter = new SpeakerAdaptor(this, R.layout.number_list_view_item, speakerList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);
        setupSpeakerSelectedListener();

        //assign values to each control on the layout
//        btn = findViewById(R.id.button);

        //Click listeners for button
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                String url = "https://67ae-121-74-181-94.au.ngrok.io/normal_speech/F05_B1_C10_M2.wav";
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        System.out.println(error);
//                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                queue.add(stringRequest);
//
//            }
//        }
//        );
 }

    public void setupSpeakerSelectedListener() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
                Intent intent = new Intent(MainActivity.this, SpeakerDetailActivity.class);
                intent.putExtra(SPEAKER_DETAIL_KEY, itemsAdapter.getItem(position));
                startActivity(intent);


        });
    }
}

