package com.example.ahsan.getambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ahsan.getambulance.View.AboutActivity;

public class MainActivity extends AppCompatActivity {

    private Button okb,adminbutton,hospitabutton;
    private EditText edittext,keyvalue;
    private TextView textView;


    private ListView listView,listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=(Button) findViewById(R.id.button2);
        Button searchb=(Button)findViewById(R.id.button4);
        Button rateb=(Button)findViewById(R.id.button9);
        adminbutton=(Button)findViewById(R.id.button7);
        hospitabutton=(Button)findViewById(R.id.button6);
        Button aboutbutton=(Button) findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MapsActivity.class));
            }
        });
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AboutActivity.class));

            }

        });
        hospitabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Hospitals.class));

            }

        });
        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,POPup.class));

            }

        });

        rateb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RateActivity.class));
            }
        });

        searchb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Hospitals.class));
            }
        });



    }




}
