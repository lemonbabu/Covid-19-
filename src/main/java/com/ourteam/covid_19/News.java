package com.ourteam.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class News extends AppCompatActivity {
    AdView adView;
    TextView logo;
    TextView newsView;
    TextView courseView;
    Button prothomalo;
    Button dhakaT;
    Button bbc;
    Button who;
    Button muktopaath;
    Button bdnews24;
    Button jugantor;
    Button ittefaq;
    Button un;
    Button unicef;
    Button aljazeera;
    Button thedailystar;
    Button covidMap;
    Button IEDCR;
    String url,language,courseTest;
    ScrollView news;
    ScrollView course;
    ImageView imageView;
    int [] img =new int[]{R.drawable.diploma};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        adView=findViewById(R.id.adView);
        prothomalo=findViewById(R.id.prothomalo);
        bbc=findViewById(R.id.bbc);
        courseView=findViewById(R.id.courseView);
        logo=findViewById(R.id.logo);
        un=findViewById(R.id.un);
        newsView=findViewById(R.id.newsView);
        ittefaq=findViewById(R.id.ittefaq);
        who=findViewById(R.id.who);
        covidMap=findViewById(R.id.covidMap);
        muktopaath=findViewById(R.id.muktopaath);
        bdnews24=findViewById(R.id.bdnews24);
        unicef=findViewById(R.id.unicef);
        jugantor=findViewById(R.id.jugantor);
        news=findViewById(R.id.news);
        IEDCR=findViewById(R.id.IEDCR);
        imageView=findViewById(R.id.imageView);
        course=findViewById(R.id.course);
        aljazeera=findViewById(R.id.aljazeera);
        thedailystar=findViewById(R.id.star);
        dhakaT=findViewById(R.id.dhakaT);



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
            courseTest=bundle.getString("course");
            if (courseTest.equals("no"))
            {
                if(language.equals("bangla"))
                {
                    logo.setText("খবর");
                }
                news.setVisibility(View.VISIBLE);
                course.setVisibility(View.GONE);
            }
            else {
                if(language.equals("bangla"))
                {
                    logo.setText("কোর্স");
                }
                else {
                    logo.setText("Course");
                }
                imageView.setImageResource(img[0]);
                news.setVisibility(View.GONE);
                course.setVisibility(View.VISIBLE);
            }

            if(language.equals("bangla"))
            {


                courseView.setText("কোভিড -19 সম্পর্কিত ফ্রি কোর্স এবং প্রতিযোগিতা সার্টিফিকেট সহ");
                newsView.setText("কোভিড -১৯ সাম্প্রতিক আপডেট");
                prothomalo.setText("প্রথম আলো");
                prothomalo.setTextSize(18);
                bbc.setText("বিবিসি খবর ");
                bbc.setTextSize(18);
                dhakaT.setText("ঢাকা ট্রাইবুন");
                dhakaT.setTextSize(18);
                thedailystar.setText("দ্য ডেইলি স্টার");
                thedailystar.setTextSize(18);
                aljazeera.setText("আলজাযীরা");
                aljazeera.setTextSize(18);
                bdnews24.setText("বিডি নিউজ ২৪");
                bdnews24.setTextSize(18);
                jugantor.setText("যুগান্তর");
                jugantor.setTextSize(18);
                ittefaq.setText("বিইত্তেফাক");
                ittefaq.setTextSize(18);
                who.setText("ওয়ার্ল্ড হেলথ অর্গানাইজেশন");
                who.setTextSize(18);
                muktopaath.setText("মুক্তপাঠ");
                muktopaath.setTextSize(18);
                un.setText("ইউনাইটেড নেশন");
                un.setTextSize(18);
                unicef.setText("ইউনিসেফ");
                unicef.setTextSize(18);
                covidMap.setText("কোভিড-১৯ ম্যাপ ");
                covidMap.setTextSize(18);
                IEDCR.setText("আই.ই.ডি.সি.আর এর ওয়েবসাইট ");
                IEDCR.setTextSize(18);
            }
        }
        prothomalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    url="https://www.prothomalo.com/topic/%E0%A6%95%E0%A6%B0%E0%A7%8B%E0%A6%A8%E0%A6%BE%E0%A6%AD%E0%A6%BE%E0%A6%87%E0%A6%B0%E0%A6%BE%E0%A6%B8";
                }
                else
                {
                    url="https://en.prothomalo.com/topic/coronavirus-2";
                }

                openWeb();
            }
        });
        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    url="https://www.bbc.com/bengali/topics/ckedkq6lle1t";
                }
                else
                {
                    url="https://www.bbc.com/news/coronavirus";
                }

                openWeb();
            }
        });
        dhakaT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    url="https://bangla.dhakatribune.com/";
                }
                else
                {
                    url="https://www.dhakatribune.com/hashtag/coronavirus?__cf_chl_jschl_tk__=d59c33f81fe78341f502066a25c4662c10429ce5-1585832107-0-AZgdr9HjQMwLkcxUMyGwewBC32vjQxbLwUdo-aCZ3Z0C-26kwI5ZAaMmU4dNVi2LydPOZmgjUiqetlwSA6cxk2fDhEC-MEFVsd8ulR3SFmo3AKLM6I3LPFzKmaDbEpmrhp3X0CVNGap8tymUiY8fUfjFU3mnj29LDQ4buyumOvJyGtgg3jWyDzsPlbiBjwsz2Jd3A6FOgNhrgsFFEz5Hj9Z2gOh4SWZ1dM2GNeIY_8V0ye4PrdG4WoRW6BxpUKIKFr2DINd9dRdxO-YjBde-6FRyx_eItdiKMYeRvcbYS1QP";
                }

                openWeb();
            }
        });

        aljazeera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://www.aljazeera.com/topics/events/coronavirus-outbreak.html";
                openWeb();
            }
        });
        jugantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://www.jugantor.com/covid-19";
                openWeb();
            }
        });
        ittefaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://www.ittefaq.com.bd/covid19-update";
                openWeb();
            }
        });
        who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://openwho.org/courses";
                openWeb();
            }
        });
        muktopaath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="http://muktopaath.gov.bd/course-search?type=category&id=5&name=&page=1";
                openWeb();
            }
        });
        un.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://publicadministration.un.org/en/E-Learning";
                openWeb();
            }
        });
        unicef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://volunteer.unicefbangladesh.org/wash-hand?fbclid=IwAR2UtYcPNLsavskRJws0Qj8E6arfczKotFMHsmw8PKvXVW60KdZIYpb4Sdc";
                openWeb();
            }
        });
        covidMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://www.google.com/covid19-map/";
                openWeb();
            }
        });
        IEDCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="https://www.iedcr.gov.bd/";
                openWeb();
            }
        });
        thedailystar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    url="https://www.thedailystar.net/bangla/";
                }
                else
                {
                    url="https://www.thedailystar.net/tags/coronavirus";
                }

                openWeb();
            }
        });
        bdnews24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(language.equals("bangla"))
                {
                    url="https://bangla.bdnews24.com/health/";
                }
                else
                {
                    url="https://bdnews24.com/health/";
                }

                openWeb();
            }
        });

    }
    public void openWeb()
    {
        Intent intent=new Intent(getApplicationContext(),NewsWeb.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
