package com.example.ahsan.getambulance;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    Spinner dropdown;
    EditText tname,tlocation,tcontact;
    String s1,s2;
    ArrayList <String> a1=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button updateb=(Button)findViewById(R.id.button10);
         tname= (EditText) findViewById(R.id.editTextn);
          tlocation= (EditText) findViewById(R.id.editTextl);
        tcontact= (EditText) findViewById(R.id.editTextc);

       /* String name,location,contact;
        name=tname.getText().toString();
        location=tlocation.getText().toString();
        contact=tcontact.getText().toString();*/


        DatabaseReference first= FirebaseDatabase.getInstance().getReference("HospitalList");
        dropdown=findViewById(R.id.spinner);

        final ArrayAdapter<String> arrayAdapter2= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Hospitals.forparent);

        dropdown.setAdapter(arrayAdapter2);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                DatabaseReference ref1= FirebaseDatabase.getInstance().getReference("HospitalList/CHEVRON/");
                DatabaseReference ref2= FirebaseDatabase.getInstance().getReference("HospitalList//CHEVRON/");

                ref1.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        try {
                            s1 = dataSnapshot.getValue(String.class);
                            a1.add(s1);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

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
                ref2.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String s2=dataSnapshot.getValue(String.class);


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
                //tlocation.setText(a1.get(1));
              //  tcontact.setText(a1.get(0));
                Toast.makeText(getApplicationContext(), "This is " +
                        adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                try {
                    String sss=adapterView.getItemAtPosition(i).toString();
                    tname.setText(sss);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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

        //tcontact.setText();
        /* okb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=edittext.getText().toString();
                String key=keyvalue.getText().toString();
                if(value.isEmpty()&&key.isEmpty()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Why no text??").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setNegativeButton("Cancel",null);

                    AlertDialog alert=builder.create();
                    alert.show();
                }
                else {
                    Firebase mRefChild = mRef.child(key);
                    mRefChild.setValue(value);
                    edittext.setText("");
                }
            }
        });*/



    }




}
