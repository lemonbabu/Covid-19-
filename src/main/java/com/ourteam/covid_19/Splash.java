package com.ourteam.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private ProgressBar pb;
    private int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pb=(ProgressBar) findViewById(R.id.pbar);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startMain();
            }
        });
        thread.start();


    }

    public void doWork()
    {
        for(prog=1;prog<=100;prog+=1)
        {
            try {
                Thread.sleep(15);
                pb.setProgress(prog);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void startMain()
    {
        Intent intent=new Intent(this,Language.class);
        startActivity(intent);
        finish();

    }
}
