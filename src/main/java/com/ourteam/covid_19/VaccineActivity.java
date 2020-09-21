package com.ourteam.covid_19;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VaccineActivity extends AppCompatActivity {
    AdView adView;
    ListView listView;
    ScrollView emptyScroll;
    TextView empty;
    TextView logo;
    String language,location;
    DatabaseReference databaseReference;
    private List<Vaccine> vaccineList;
    private VaccineAdapter vaccineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        adView=findViewById(R.id.adView);
        vaccineList = new ArrayList<>();
        emptyScroll=findViewById(R.id.emptyScroll);
        listView=findViewById(R.id.list);
        logo=findViewById(R.id.logo);
        empty=findViewById(R.id.empty);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        vaccineAdapter= new VaccineAdapter(VaccineActivity.this,vaccineList);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            language=bundle.getString("language");
            location=bundle.getString("location");
            logo.setText(location);
            if(language.equals("bangla"))
            {
                empty.setText(R.string.vaccine_string_bangla);
            }

        }

        databaseReference= FirebaseDatabase.getInstance().getReference(location);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                vaccineList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Vaccine vaccine=dataSnapshot1.getValue(Vaccine.class);
                    vaccineList.add(vaccine);
                }
                if(vaccineList.isEmpty())
                {
                    emptyScroll.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                }
                else{
                    emptyScroll.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    listView.setAdapter(vaccineAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
