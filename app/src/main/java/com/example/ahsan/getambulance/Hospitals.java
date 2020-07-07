package com.example.ahsan.getambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.zip.Inflater;

public class Hospitals extends AppCompatActivity {


    ListView mylist;
    ListView parentview,test;
    ArrayAdapter<String> adapter;
    ExpandableListView expandableListView;
    private Firebase mRef;
    private ArrayList<String> forchild=new ArrayList<>();
    public static ArrayList<String>forparent=new ArrayList<>();
    public static String hospitalname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);



        final ArrayAdapter<String>  arrayAdapter2= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Hospitals.forparent);
        parentview=(ListView)findViewById(R.id.parenlist);
        parentview.setAdapter(arrayAdapter2);

        parentview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) adapterView.getItemAtPosition(i);

                hospitalname=(String) adapterView.getItemAtPosition(i);

                //Toast.makeText(getApplicationContext(),"This is "+selected,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"This is "+hospitalname,Toast.LENGTH_LONG).show();
                startActivity(new Intent(Hospitals.this,HospitalDetails.class));

            }
        });

        DatabaseReference first= FirebaseDatabase.getInstance().getReference("HospitalList");

        first.addChildEventListener(new com.google.firebase.database.ChildEventListener() {
            @Override
            public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                String ss=dataSnapshot.getKey().toString();

                Hospitals.forparent.add(ss);

                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        adapter=arrayAdapter2;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem item=menu.findItem(R.id.parenlist);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
