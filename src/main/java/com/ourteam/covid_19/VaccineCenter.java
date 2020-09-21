package com.ourteam.covid_19;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
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

public class VaccineCenter extends AppCompatActivity {
    AdView adView;
    ImageView imageView;
    ListView listView;
    TextView empty;
    TextView logo;
    String language,location;
    DatabaseReference databaseReference;
    private List<Hospital> addressList;
    private AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_center);
        adView=findViewById(R.id.adView);
        imageView=findViewById(R.id.imageView);
        addressList = new ArrayList<>();
        listView=findViewById(R.id.list);
        logo=findViewById(R.id.logo);
        empty=findViewById(R.id.empty);
        addressAdapter= new AddressAdapter(VaccineCenter.this,addressList);


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
            location=bundle.getString("location");
            logo.setText(location);
            if(location.equals("ডাক্তার")||location.equals("doctor"))
            {
                imageView.setImageResource(R.drawable.doctor);
            }
            if(location.equals("অ্যাম্বুলেন্স")||location.equals("ambulance"))
            {
                imageView.setImageResource(R.drawable.ambulance);
            }
            if(location.equals("জরুরি")||location.equals("emergency"))
            {
                imageView.setImageResource(R.drawable.emergency);
            }
            if(language.equals("bangla"))
            {
                empty.setText("টিকা এখনো পাওয়া যায়নি!");
            }

        }

        databaseReference= FirebaseDatabase.getInstance().getReference(location);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                addressList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Hospital hospital=dataSnapshot1.getValue(Hospital.class);
                    addressList.add(hospital);
                }
                if(addressList.isEmpty())
                {
                    empty.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                }
                else{
                    empty.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    listView.setAdapter(addressAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
