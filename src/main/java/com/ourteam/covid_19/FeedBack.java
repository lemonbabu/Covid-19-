package com.ourteam.covid_19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBack extends AppCompatActivity {
    AdView adView;
    TextView logo;
    TextView feedbackView;
    EditText nameEdit;
    EditText feedbackEdit;
    Button submit;
    String language,name,feedback;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        adView=findViewById(R.id.adView);
        logo=findViewById(R.id.logo);
        feedbackView=findViewById(R.id.feedBackView);
        nameEdit=findViewById(R.id.name);
        feedbackEdit=findViewById(R.id.feedBack);
        submit=findViewById(R.id.submit);
        databaseReference= FirebaseDatabase.getInstance().getReference("feedback");

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
            if(language.equals("bangla"))
            {
                logo.setText("প্রতিক্রিয়া");
                feedbackView.setText("আপনার মন্তব্য দিয়ে অ্যাপটিকে আরো কার্যকর করতে সহায়তা করুন");
                submit.setText("জমা দিন");
                nameEdit.setHint("নাম:");
                feedbackEdit.setHint("প্রতিক্রিয়া:");
            }
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameEdit.getText().toString();
                feedback=feedbackEdit.getText().toString();
                if(name.isEmpty())
                {
                    if(language.equals("bangla"))
                    {
                        nameEdit.setError("আপনার নাম লিখুন");
                    }
                    else
                    {
                        nameEdit.setError("Enter your name");
                    }

                    nameEdit.requestFocus();
                    return;
                }
                if(feedback.isEmpty())
                {
                    if(language.equals("bangla"))
                    {
                        nameEdit.setError("আপনার প্রতিক্রিয়া লিখুন");
                    }
                    else
                    {
                        nameEdit.setError("Enter your Feedback");
                    }

                    nameEdit.requestFocus();
                    return;
                }
                String key =databaseReference.push().getKey();
                FeedBackClass feedBackClass=new FeedBackClass(name,feedback);
                databaseReference.child(key).setValue(feedBackClass);
                nameEdit.setText("");
                feedbackEdit.setText("");

            }
        });
    }
}
