package com.ourteam.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TestOrHospital extends AppCompatActivity {
    AdView adView;
    Button riskTest;
    TextView testView;
    Button test;
    Button hospital;
    TextView logo;
    String language,location,vaccineTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_or_hospital);
        adView=findViewById(R.id.adView);
        test =findViewById(R.id.test);
        logo=findViewById(R.id.logo);
        riskTest=findViewById(R.id.riskTest);
        testView=findViewById(R.id.testView);
        hospital=findViewById(R.id.hospital);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            vaccineTest=bundle.getString("vaccineTest");
            if(language.equals("bangla")&&vaccineTest.equals("no"))
            {
                logo.setText("পরীক্ষা কেন্দ্র/\nহাসপাতাল");
                test.setText("পরীক্ষা কেন্দ্র");
                hospital.setText("হাসপাতাল");
                riskTest.setText("করোনা ভাইরাস ঝুঁকি পরীক্ষা");
                testView.setText("কোভিড -১৯  এর সর্বাধিক সাধারণ পরীক্ষাগুলির মধ্যে রোগীর নাক এবং গলা থেকে একটি সোয়াব নেওয়া এবং ভাইরাসটির জিনগত পদক্ষেপের জন্য তাদের পরীক্ষা করা হয় । এইগুলোকে \"পিসিআর পরীক্ষা\" বলা হয়। কোভিড -১৯ এর জন্য প্রথম পিসিআর পরীক্ষাগুলি খুব দ্রুত বিকাশ লাভ করে - রোগটি সনাক্ত হওয়ার দুই সপ্তাহের মধ্যে। এইগুলো এখন এই রোগের মোকাবিলার জন্য বিশ্ব স্বাস্থ্য সংস্থার (ডব্লিউ এইচ ও) প্রস্তাবিত প্রোটোকলের অংশ।");
            }
            if(language.equals("bangla")&&vaccineTest.equals("yes"))
            {
                logo.setText("টিকা/\nটিকাকেন্দ্র");
                test.setText("টিকা");
                hospital.setText("টিকাকেন্দ্র");
                testView.setVisibility(View.GONE);
                riskTest.setVisibility(View.GONE);
            }
            if(language.equals("english")&&vaccineTest.equals("yes"))
            {
                logo.setText("Vaccine/\nVaccine Center");
                test.setText("Vaccine");
                hospital.setText("Vaccine Center");
                testView.setVisibility(View.GONE);
                riskTest.setVisibility(View.GONE);
            }
        }
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaccineTest.equals("no"))
                {
                    if(language.equals("bangla"))
                    {
                        location="পরীক্ষা";
                    }
                    else
                    {
                        location="test";
                    }

                    Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                    intent.putExtra("language",language);
                    intent.putExtra("location",location);
                    startActivity(intent);
                }
                if(vaccineTest.equals("yes"))
                {
                    if(language.equals("bangla"))
                    {
                        location="টিকা";
                    }
                    else
                    {
                        location="vaccine";
                    }
                    Intent intent=new Intent(getApplicationContext(),VaccineActivity.class);
                    intent.putExtra("location",location);
                    intent.putExtra("language",language);
                    startActivity(intent);
                }

            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaccineTest.equals("no"))
                {
                    if(language.equals("bangla"))
                    {
                        location="হাসপাতাল";
                    }
                    else
                    {
                        location="hospital";
                    }

                    Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                    intent.putExtra("language",language);
                    intent.putExtra("location",location);
                    startActivity(intent);
                }
                if(vaccineTest.equals("yes"))
                {
                    if(language.equals("bangla"))
                    {
                        location="টিকাকেন্দ্র";
                    }
                    else
                    {
                        location="vaccineCenter";
                    }

                    Intent intent=new Intent(getApplicationContext(),VaccineCenter.class);
                    intent.putExtra("language",language);
                    intent.putExtra("location",location);
                    startActivity(intent);
                }

            }
        });
        riskTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RiskTest.class);
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });
    }
}
