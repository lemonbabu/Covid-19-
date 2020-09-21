package com.ourteam.covid_19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class RiskTest extends AppCompatActivity {
    AdView adView;
    RadioGroup ageGroup;
    RadioGroup feverGroup;
    RadioGroup breathGroup;
    RadioGroup weaknessGroup;
    RadioGroup coldGroup;
    RadioGroup visitGroup;
    RadioGroup affectedGroup;
    RadioButton ageBtn;
    RadioButton feverBtn;
    RadioButton breathBtn;
    RadioButton weaknessBtn;
    RadioButton coldBtn;
    RadioButton visitBtn;
    RadioButton affectedBtn;
    Button submit;
    Button checkAgain;
    String age;
    String fever;
    String breath;
    String weakness;
    String cold;
    String visit;
    String affected,language;
    TextView resultText;
    LinearLayout result;
    ScrollView question;

    TextView logo;
    TextView ageText;
    TextView feverText;
    TextView breathText;
    TextView weaknessText;
    TextView coldText;
    TextView visitText;
    TextView affectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_test);
        adView=findViewById(R.id.adView);
        logo=findViewById(R.id.logo);
        ageGroup=findViewById(R.id.ageGroup);
        feverGroup=findViewById(R.id.feverGroup);
        breathGroup=findViewById(R.id.breathGroup);
        weaknessGroup=findViewById(R.id.weaknessGroup);
        coldGroup=findViewById(R.id.coldGroup);
        submit=findViewById(R.id.submit);
        coldText=findViewById(R.id.coldText);
        feverText=findViewById(R.id.feverText);
        weaknessText=findViewById(R.id.weaknessText);
        result=findViewById(R.id.result);
        visitText=findViewById(R.id.visitText);
        ageText=findViewById(R.id.ageText);
        breathText=findViewById(R.id.breathText);
        checkAgain=findViewById(R.id.checkAgain);
        question=findViewById(R.id.Question);
        resultText=findViewById(R.id.resultText);
        visitGroup=findViewById(R.id.visitGroup);
        affectedText=findViewById(R.id.affectedText);
        affectedGroup=findViewById(R.id.affectedGroup);


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
                logo.setText("প্রাথমিক করোনভাইরাস ঝুঁকি পরীক্ষা");
                ageText.setText("আপনার বয়স কি 60 এর উপরে?");
                feverText.setText("আপনার কি জ্বর আছে ?");
                breathText.setText("আপনার কি শ্বাসকষ্ট আছে বা শ্বাস নিতে বা ফেলতে কোন কষ্ট হচ্ছে ?");
                weaknessText.setText("আপনার কি কাশি এবং শারীরিক দূর্বলতা আছে ?");
                coldText.setText("আপনার, সর্দি, গলাব্যথা আছে বা ঢোক গিলতে সমস্যা হয় ?");
                visitText.setText("আপনি কি গত ১৪ দিনের ভিতরে কোভিড- ১৯ ( করোনা) এ আক্রান্ত কোন দেশ চীন, ইতালি, দক্ষিণ কোরিয়া, জাপান, সিংগাপুর, আমেরিকা, বা ইউরোপের দেশে ভ্রমণ করেছেন ?");
                affectedText.setText("আপনি কি কোভিড- ১৯ ( করোনা) এ আক্রান্ত কোন ব্যক্তির সংস্পর্শে ছিলেন ( একই সাথে অবস্থান, বা ভ্রমন করেছেন) ?");
                submit.setText("জমা দিন");
                checkAgain.setText("আবার পরীক্ষা করুন");
            }
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId;
                radioId=ageGroup.getCheckedRadioButtonId();
                ageBtn=findViewById(radioId);
                age =ageBtn.getText().toString();

                radioId=feverGroup.getCheckedRadioButtonId();
                feverBtn=findViewById(radioId);
                fever =feverBtn.getText().toString();

                radioId=breathGroup.getCheckedRadioButtonId();
                breathBtn=findViewById(radioId);
                breath =breathBtn.getText().toString();

                radioId=weaknessGroup.getCheckedRadioButtonId();
                weaknessBtn=findViewById(radioId);
                weakness =weaknessBtn.getText().toString();

                radioId=coldGroup.getCheckedRadioButtonId();
                coldBtn=findViewById(radioId);
                cold =coldBtn.getText().toString();

                radioId=visitGroup.getCheckedRadioButtonId();
                visitBtn=findViewById(radioId);
                visit =visitBtn.getText().toString();

                radioId=affectedGroup.getCheckedRadioButtonId();
                affectedBtn=findViewById(radioId);
                affected =affectedBtn.getText().toString();

                if((affected.equals("Yes")||visit.equals("Yes")))
                {
                    if(fever.equals("No")&&breath.equals("No")&&weakness.equals("No")&&cold.equals("No"))
                    {
                        if(language.equals("bangla"))
                        {
                            resultText.setText("কোন লক্ষণ নেই; নিজস্ব-কোয়ারান্টাইন আবশ্যক");
                        }
                        else
                        {
                            resultText.setText("No symptom! But self Quarantine is required");
                        }
                    }
                    else
                    {
                        if(language.equals("bangla"))
                        {
                            resultText.setText("কভিড-১৯ এর সম্ভাব্য সন্দেহভাজন!\nআইইডিছিআর এর সাথে যোগাযোগ করুনঃ ৩৩৩, ১০৬৫৫, ১৬২৬৩");
                        }
                        else
                        {
                            resultText.setText("Possible suspects of Cavid-19!\n contact with IEDCR: 333, 10655, 16263.");
                        }

                    }

                }
                else
                {
                    if(language.equals("bangla"))
                    {
                        resultText.setText("কভিড -১৯ এর জন্য আপনার ঝুঁকি এই মুহুর্তে খুব ন্যূনতম");
                    }
                    else
                    {
                        resultText.setText("Your risk for Quid-19 is very minimal at the moment");
                    }

                }
                question.setVisibility(View.GONE);
                result.setVisibility(View.VISIBLE);
            }
        });
        checkAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setVisibility(View.VISIBLE);
                result.setVisibility(View.GONE);
            }
        });
    }


}
