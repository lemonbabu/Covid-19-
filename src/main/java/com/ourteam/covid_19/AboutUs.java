package com.ourteam.covid_19;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AboutUs extends AppCompatActivity {
    AdView adView;
    String language;
    TextView logo;
    TextView team;
    TextView mojoName;
    TextView sanjidaName;
    TextView limonName;
    TextView update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        adView=findViewById(R.id.adView);
        logo =findViewById(R.id.logo);
        team=findViewById(R.id.team);
        update=findViewById(R.id.update);
        mojoName=findViewById(R.id.mojoName);
        sanjidaName=findViewById(R.id.sanjidaName);
        limonName=findViewById(R.id.limonName);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            if (language.equals("bangla"))
            {
                logo.setText("আমাদের সম্পর্কে");
                team.setText("আমাদের টিম");
                mojoName.setText("মোঃ মোজাম্মেল হোসেন।");
                sanjidaName.setText("সানজিদা আমিন রিয়া।");
                limonName.setText("লতিফুর রহমান লিমন।");
                update.setText("নতুন আপডেট শীঘ্রই আসছে ...");
            }
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
