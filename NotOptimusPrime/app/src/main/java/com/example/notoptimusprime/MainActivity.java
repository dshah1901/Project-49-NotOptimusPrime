package com.example.notoptimusprime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.notoptimusprime.adapter.SpeakerAdaptor;
import com.example.notoptimusprime.model.DataProvider;
import com.example.notoptimusprime.model.Speaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Testing the dictionary
        List<Speaker> speakerList = DataProvider.getSpeaker();
        SpeakerAdaptor itemsAdapter = new SpeakerAdaptor(this, R.layout.number_list_view_item, speakerList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(itemsAdapter);

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
}