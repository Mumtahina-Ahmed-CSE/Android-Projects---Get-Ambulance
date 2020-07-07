package com.example.ahsan.getambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {

    ListView right,left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        right=(ListView)findViewById(R.id.right);
        left=(ListView)findViewById(R.id.left);

        Button bookcon=(Button)findViewById(R.id.button12);
        Button homeb=(Button)findViewById(R.id.button13);

        ArrayList<String> list1=new ArrayList<>();
        list1.add("Oxyzen Musk");
        list1.add("Air conditioned");
        list1.add("Important Medicines");
        list1.add("Approximate cost");
        ArrayList<String> list2=new ArrayList<>();
        list2.add("Yes");
        list2.add("Yes");
        list2.add("Yes");
        list2.add("500tk");
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list2);

        right.setAdapter(adapter1);
        left.setAdapter(adapter2);

        bookcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Thanks for booking a ambulance.",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Please rate our app from home page.",Toast.LENGTH_LONG).show();

            }
        });
        homeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookingActivity.this,MainActivity.class));
            }
        });
    }
}
