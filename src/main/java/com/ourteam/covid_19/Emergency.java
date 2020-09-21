package com.ourteam.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Emergency extends AppCompatActivity {
    String language;
    TextView logo;
    Button doctors;
    String location;
    Button ambulance;
    Button emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        doctors=findViewById(R.id.doctors);
        ambulance=findViewById(R.id.ambulance);
        logo=findViewById(R.id.logo);
        emergency=findViewById(R.id.emergency);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            if(language.equals("bangla"))
            {
                logo.setText("জরুরি");
                doctors.setText("ডাক্তার");
                doctors.setTextSize(18);
                ambulance.setText("অ্যাম্বুলেন্স");
                ambulance.setTextSize(18);
                emergency.setText("জরুরি নম্বর");
                emergency.setTextSize(18);
            }
        }


        doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    location="ডাক্তার";
                }
                else
                {
                    location="doctor";
                }

                Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                intent.putExtra("language",language);
                intent.putExtra("location",location);
                startActivity(intent);
            }
        });
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    location="অ্যাম্বুলেন্স";
                }
                else
                {
                    location="ambulance";
                }

                Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                intent.putExtra("language",language);
                intent.putExtra("location",location);
                startActivity(intent);

            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    location="জরুরি";
                }
                else
                {
                    location="emergency";
                }

                Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                intent.putExtra("language",language);
                intent.putExtra("location",location);
                startActivity(intent);

            }
        });
    }
}
