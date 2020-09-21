package com.ourteam.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Information extends AppCompatActivity {
    AdView adView;
    TextView hide;
    ImageView imageView;
    TextView logo;
    LinearLayout information;
    LinearLayout handClean;
    Button whatIsCovid;
    Button history;
    Button prevention;
    Button symptom;
    Button quarantine;
    Button howtoMake;
    Button afterSymptom;
    Button whenToClean;
    Button cleaner;
    Button howToClean;
    Button isolation;
    Button mask;
    String language,informationCheck,logoText,viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        adView=findViewById(R.id.adView);
        hide=findViewById(R.id.hide);
        information=findViewById(R.id.information);
        logo=findViewById(R.id.logo);
        symptom=findViewById(R.id.symptom);
        mask=findViewById(R.id.mask);
        history=findViewById(R.id.history);
        howToClean=findViewById(R.id.howToClean);
        quarantine=findViewById(R.id.quarantine);
        afterSymptom=findViewById(R.id.afterSymptom);
        isolation=findViewById(R.id.isolation);
        imageView=findViewById(R.id.imageView);
        cleaner=findViewById(R.id.cleaner);
        howtoMake=findViewById(R.id.howtoMake);
        whenToClean=findViewById(R.id.whenToClean);
        prevention=findViewById(R.id.prevention);
        whatIsCovid=findViewById(R.id.whatIsCovid);
        handClean=findViewById(R.id.handClean);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            informationCheck=bundle.getString("informationCheck");
            if(informationCheck.equals("yes"))
            {
                if(language.equals("bangla"))
                {
                    logo.setText("তথ্য");
                    whatIsCovid.setText("কোভিড-১৯ কি?");
                    whatIsCovid.setTextSize(18);
                    history.setText("কোভিড-১৯ এর ইতিহাস?");
                    history.setTextSize(18);
                    symptom.setText("লক্ষণ");
                    symptom.setTextSize(18);
                    prevention.setText("প্রতিরোধ");
                    prevention.setTextSize(18);
                    afterSymptom.setText("কিছু লক্ষণ দেখা দেওয়ার পর");
                    afterSymptom.setTextSize(18);
                    quarantine.setText("কোয়ারেন্টাইন");
                    quarantine.setTextSize(18);
                    isolation.setText("আইসোলেশন");
                    isolation.setTextSize(18);


                }
                information.setVisibility(View.VISIBLE);
                handClean.setVisibility(View.GONE);
            }
            else{
                if(language.equals("bangla"))
                {
                    logo.setText("হাত পরিষ্কার");
                    howToClean.setText("কিভাবে সঠিকভাবে হাত পরিষ্কার করবেন?");
                    howToClean.setTextSize(18);
                    whenToClean.setText("কখন আমাদের হাত পরিষ্কার করা উচিত?");
                    whenToClean.setTextSize(18);
                    cleaner.setText("কিছু হাত ক্লিনার");
                    cleaner.setTextSize(18);
                    howtoMake.setText("ককিভাবে সস্তায়  হাত ক্লিনার বানাবেন?");
                    howtoMake.setTextSize(18);
                    mask.setText("মাস্ক এবং হাতের গ্লোভস");
                    mask.setTextSize(18);

                }
                else
                {
                    logo.setText("Hand Clean");
                }
                imageView.setImageResource(R.drawable.handwash);
                information.setVisibility(View.GONE);
                handClean.setVisibility(View.VISIBLE);
            }
        }


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        whatIsCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=whatIsCovid.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.what_is_covid_19);

                }
                else
                {
                    hide.setText(R.string.what_is_covid_19_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=history.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.history);

                }
                else
                {
                    hide.setText(R.string.history_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        symptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=symptom.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.symptom);

                }
                else
                {
                    hide.setText(R.string.symptom_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        prevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=prevention.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.prevention);

                }
                else
                {
                    hide.setText(R.string.prevention_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        afterSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=afterSymptom.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.after_symptom);

                }
                else
                {
                    hide.setText(R.string.after_symptom_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        quarantine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=quarantine.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.home_quarantine);

                }
                else
                {
                    hide.setText(R.string.home_quarantine_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        howToClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=howToClean.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.how_t0_clean);

                }
                else
                {
                    hide.setText(R.string.how_t0_clean_bangla);
                }
                viewText="";
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        whenToClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=whenToClean.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.when_clean);

                }
                else
                {
                    hide.setText(R.string.when_clean_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=cleaner.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.some_hand_cleaner);

                }
                else
                {
                    hide.setText(R.string.some_hand_cleaner_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        howtoMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=howtoMake.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.how_to_make);

                }
                else
                {
                    hide.setText(R.string.how_to_make_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        isolation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=isolation.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.isolation);

                }
                else
                {
                    hide.setText(R.string.isolation_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoText=mask.getText().toString();
                if(language.equals("english"))
                {
                    hide.setText(R.string.mask);

                }
                else
                {
                    hide.setText(R.string.mask_bangla);
                }
                viewText=hide.getText().toString();
                Intent intent=new Intent(getApplicationContext(),HandClean.class);
                intent.putExtra("language",language);
                intent.putExtra("informationCheck",informationCheck);
                intent.putExtra("logoText",logoText);
                intent.putExtra("viewText",viewText);
                startActivity(intent);
            }
        });
    }
}
