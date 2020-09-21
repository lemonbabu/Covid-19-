package com.ourteam.covid_19;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class NewsWeb extends AppCompatActivity {
    AdView adView;
    WebView myWeb;
    TextView error;
    ProgressBar progressBar;
    int che=0;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);
        adView=findViewById(R.id.adView);
        myWeb=findViewById(R.id.myWeb);
        error=findViewById(R.id.error);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setMax(100);


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
            url=bundle.getString("url");
        }
        load();
    }



    public void load()
    {
        checkInternet();
        if(che==1)
        {
            myWeb.setVisibility(View.VISIBLE);
            error.setVisibility(View.GONE);
            WebSettings myWebSetting = myWeb.getSettings();
            myWebSetting.setJavaScriptEnabled(true);
            myWeb.setWebViewClient(new WebViewClient());
            myWeb.loadUrl(url);

        }
        else
        {
            myWeb.setVisibility(View.GONE);
            error.setVisibility(View.VISIBLE);
        }

    }


    public void checkInternet()
    {
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
        if(activeNetwork!=null)
        {
            if(activeNetwork.getType()==(ConnectivityManager.TYPE_WIFI))
            {
                che=1;
            }
            if(activeNetwork.getType()==(ConnectivityManager.TYPE_MOBILE))
            {
                che=1;
            }

        }
        else
        {
            che=0;
        }
    }

    @Override
    public void onBackPressed() {
        if(myWeb.canGoBack())
        {
            myWeb.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}
