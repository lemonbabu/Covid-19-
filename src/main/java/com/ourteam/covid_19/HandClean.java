package com.ourteam.covid_19;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HandClean extends AppCompatActivity {
    AdView adView;
    ImageView imageView;
    ImageView imageViewHand;
    TextView logo;
    TextView textView;
    String language,informationCheck,logoText,viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_clean);
        imageView=findViewById(R.id.imageView);
        imageViewHand=findViewById(R.id.imageViewHand);
        logo=findViewById(R.id.logo);
        textView=findViewById(R.id.textView);
        adView=findViewById(R.id.adView);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            informationCheck=bundle.getString("informationCheck",informationCheck);
            logoText=bundle.getString("logoText");
            logo.setText(logoText);
            viewText=bundle.getString("viewText");

            if(informationCheck.equals("no"))
            {
                imageView.setImageResource(R.drawable.handwash);
            }
            if(logoText.equals("কিভাবে সঠিকভাবে হাত পরিষ্কার করবেন?")||logoText.equals("How to clean hands properly?"))
            {
                imageViewHand.setVisibility(View.VISIBLE);
                if(language.equals("english"))
                {
                    imageViewHand.setImageResource(R.drawable.handenglish);
                }
            }
            if(logoText.equals("কোভিড-১৯ কি?")||logoText.equals("What is Covid-19"))
            {

                    imageView.setImageResource(R.drawable.what);

            }
            if(logoText.equals("লক্ষণ")||logoText.equals("Symptom"))
            {

                    imageView.setImageResource(R.drawable.symptom);
            }
            if(logoText.equals("মাস্ক এবং হাতের গ্লোভস")||logoText.equals("Mask and Hand gloves"))
            {

                imageView.setImageResource(R.drawable.mask);
            }
            textView.setText(viewText);
        }



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
