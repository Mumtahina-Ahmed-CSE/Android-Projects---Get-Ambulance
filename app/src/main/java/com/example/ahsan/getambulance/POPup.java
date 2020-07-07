package com.example.ahsan.getambulance;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AHSAN on 23-Mar-18.
 */

public class POPup extends Activity{
    Button popok;
    EditText edittextpassword;
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels, height=dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));

        edittextpassword=(EditText)findViewById(R.id.editText3);
        popok=(Button)findViewById(R.id.button5);
        popok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String es=edittextpassword.getText().toString();

                        if(es.equals("aa"))
                            startActivity(new Intent(POPup.this,Admin.class));
                        else{
                            AlertDialog.Builder builder=new AlertDialog.Builder(POPup.this);
                            builder.setMessage("Wrong password. Contact with AHSAN!!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).setNegativeButton("cancel",null);

                            AlertDialog alert=builder.create();
                            alert.show();
                        }
            }
        });
    }

}
