package com.ourteam.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    AdView adView;
    InterstitialAd interstitialAd;
    TextView logo;
    TextView informationView;
    TextView handCleanView;
    TextView vaccineView;
    TextView vaccineCenterView;
    TextView testView;
    TextView newsView;
    TextView aboutUsView;
    TextView feedBackView;
    TextView totalCaseText;
    TextView totalCaseNumber;
    TextView effectedCountryText;
    TextView effectedCountryNumber;
    TextView totalDeathsText;
    TextView updateView;
    TextView emergencyView;
    TextView totalDeathsNumber;
    LinearLayout information;
    LinearLayout handClean;
    LinearLayout vaccine;
    LinearLayout course;
    LinearLayout testOrHospital;
    LinearLayout news;
    LinearLayout emergency;
    LinearLayout coronaUpdate;
    LinearLayout aboutUs;
    LinearLayout feedBack;
    TextView languageChange;
    String language,location,vaccineTest,courseTest,informationCheck,triggerValue="1";
    DatabaseReference databaseReference;
    DatabaseReference databaseReferenceTrigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView=findViewById(R.id.adView);

        logo=findViewById(R.id.logo);
        informationView=findViewById(R.id.informationView);
        handCleanView=findViewById(R.id.handCleanView);
        vaccineCenterView=findViewById(R.id.vaccineCenterView);
        vaccineView=findViewById(R.id.vaccineView);
        testView=findViewById(R.id.testView);
        emergency=findViewById(R.id.emergency);
        newsView=findViewById(R.id.newsView);
        emergencyView=findViewById(R.id.emergencyView);
        coronaUpdate=findViewById(R.id.coronaUpdate);
        aboutUsView=findViewById(R.id.aboutUsView);
        feedBackView=findViewById(R.id.feedBackView);
        updateView=findViewById(R.id.updateView);
        totalCaseText=findViewById(R.id.totalCaseText);
        totalCaseNumber=findViewById(R.id.caseView);
        effectedCountryText=findViewById(R.id.effectedCountrytext);
        effectedCountryNumber=findViewById(R.id.CountryView);
        totalDeathsText=findViewById(R.id.totalDeathsText);
        totalDeathsNumber=findViewById(R.id.deathsView);
        information=findViewById(R.id.information);
        handClean=findViewById(R.id.handClean);
        languageChange=findViewById(R.id.languageChange);
        vaccine=findViewById(R.id.vaccine);
        course=findViewById(R.id.course);
        testOrHospital=findViewById(R.id.testOrHospital);
        news=findViewById(R.id.news);
        aboutUs=findViewById(R.id.aboutUs);
        feedBack=findViewById(R.id.feedBack);




        MobileAds.initialize(this, "ca-app-pub-9189255863868239~2015463408");
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        interstitialAd =new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9189255863868239/6449053509");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            if(language.equals("bangla"))
            {
                languageChange.setText("English");
                logo.setText("কোভিড-১৯");
                updateView.setText("করোনা আপডেট");
                emergencyView.setText("জরুরি");
                informationView.setText("তথ্য");
                handCleanView.setText("হাত পরিষ্কার");
                vaccineView.setText("টীকা");
                vaccineCenterView.setText("বিনামূল্যে কোর্স");
                testView.setText("পরীক্ষা হাসপাতাল");
                newsView.setText("খবর");
                aboutUsView.setText("আমাদের সম্পর্কে");
                feedBackView.setText("প্রতিক্রিয়া");
                totalCaseText.setText("মোট রোগী");
                effectedCountryText.setText("সুস্থ হয়েছেন");
                totalDeathsText.setText("মোট মৃত্যু");

            }
        }
        if (language.equals("bangla"))
        {

            databaseReference= FirebaseDatabase.getInstance().getReference("কাউন্টডাউন");
        }
        else
        {
            databaseReference= FirebaseDatabase.getInstance().getReference("countDown");
        }

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    CountDown countDown= dataSnapshot1.getValue(CountDown.class);
                    String totalCase=countDown.getTotalCase();
                    totalCaseNumber.setText(totalCase);
                    effectedCountryNumber.setText(countDown.getCountry());
                    totalDeathsNumber.setText(countDown.getDeaths());
                    if(totalCase.isEmpty())
                    {
                        totalCaseText.setVisibility(View.VISIBLE);
                        totalCaseNumber.setVisibility(View.VISIBLE);
                        effectedCountryText.setVisibility(View.VISIBLE);
                        effectedCountryNumber.setVisibility(View.VISIBLE);
                        totalDeathsText.setVisibility(View.VISIBLE);
                        totalDeathsNumber.setVisibility(View.VISIBLE);

                    }

                    break;

                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceTrigger=FirebaseDatabase.getInstance().getReference("trigger");
        databaseReferenceTrigger.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    TriggerUpdate triggerUpdate= dataSnapshot1.getValue(TriggerUpdate.class);
                    triggerValue=triggerUpdate.getTriggerValue();
                    if(triggerValue.equals("0"))
                    {
                        coronaUpdate.setVisibility(View.GONE);
                        news.setVisibility(View.GONE);
                        information.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(triggerValue.equals("1"))
                {
                    informationCheck="yes";
                    Intent intent=new Intent(getApplicationContext(),Information.class);
                    intent.putExtra("informationCheck",informationCheck);
                    intent.putExtra("language",language);
                    startActivity(intent);
                }

            }
        });
        handClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informationCheck="no";
                Intent intent=new Intent(getApplicationContext(),Information.class);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });
        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaccineTest="yes";
                Intent intent=new Intent(getApplicationContext(),TestOrHospital.class);
                intent.putExtra("vaccineTest",vaccineTest);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseTest="yes";
                Intent intent=new Intent(getApplicationContext(),News.class);
                intent.putExtra("language",language);
                intent.putExtra("course",courseTest);
                startActivity(intent);
            }
        });
        testOrHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaccineTest="no";
                Intent intent=new Intent(getApplicationContext(),TestOrHospital.class);
                intent.putExtra("language",language);
                intent.putExtra("vaccineTest",vaccineTest);
                startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(triggerValue.equals("1"))
                {
                    courseTest="no";
                    Intent intent=new Intent(getApplicationContext(),News.class);
                    intent.putExtra("language",language);
                    intent.putExtra("course",courseTest);
                    startActivity(intent);
                }

            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AboutUs.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }

        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Emergency.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }

        });
        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FeedBack.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });

        languageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("english"))
                {
                    language="bangla";
                }
                else
                {
                    language="english";
                }

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("language",language);
                startActivity(intent);
                finish();
            }
        });
        coronaUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(triggerValue.equals("1"))
                {
                    String url="https://www.worldometers.info/coronavirus/";
                    Intent intent=new Intent(getApplicationContext(),NewsWeb.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure wont to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        interstitialAd.show();
                        MainActivity.super.onBackPressed();
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
