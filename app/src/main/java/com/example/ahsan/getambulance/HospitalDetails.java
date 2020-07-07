package com.example.ahsan.getambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HospitalDetails extends AppCompatActivity {

    String hname=Hospitals.hospitalname;
    ListView attri,value;
    private ArrayList<String> forchild=new ArrayList<>();
    private ArrayList<String>forparent=new ArrayList<>();
    Button bookb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        bookb=(Button)findViewById(R.id.button11);

        attri=(ListView)findViewById(R.id.attri);
        value=(ListView)findViewById(R.id.value);

        DatabaseReference first= FirebaseDatabase.getInstance().getReference("HospitalList/"+hname);

        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,forchild);
        final ArrayAdapter<String> arrayAdapter2= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,forparent);
        attri.setAdapter(arrayAdapter2);
        value.setAdapter(arrayAdapter);

        first.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String s1=dataSnapshot.getKey().toString();
                String s2=dataSnapshot.getValue(String.class);
                forparent.add(s1);
                forchild.add(s2);
                arrayAdapter.notifyDataSetChanged();
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        bookb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalDetails.this,BookingActivity.class));
            }
        });

    }
}
