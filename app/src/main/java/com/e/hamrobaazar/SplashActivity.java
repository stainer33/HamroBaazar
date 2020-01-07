package com.e.hamrobaazar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("term", MODE_PRIVATE);
                String term = sharedPreferences.getString("term", "");
                if(term.equals("true")){
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();}
                else
                {
                    Intent intent = new Intent(SplashActivity.this, TermPolicyActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }
}
