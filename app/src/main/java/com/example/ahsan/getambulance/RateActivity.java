package com.example.ahsan.getambulance;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Button done=(Button)findViewById(R.id.button8);
        final RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(RateActivity.this);
                builder.setMessage("Thanks for rating us. Your rating is "+ratingBar.getRating()+"\nYou can give feed back also.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("",null);

                AlertDialog alert=builder.create();
                alert.show();
                }
        });
    }
}