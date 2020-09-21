package com.ourteam.covid_19;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Language extends AppCompatActivity {
    Button english;
    Button bangla;
    String language="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        english=findViewById(R.id.english);
        bangla=findViewById(R.id.bangla);


        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language="english";
                openMain();
            }
        });
        bangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language="bangla";
                openMain();
            }
        });
    }
    private void openMain()
    {
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("language",language);
        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure wont to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Language.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();;
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();;




    }
}
