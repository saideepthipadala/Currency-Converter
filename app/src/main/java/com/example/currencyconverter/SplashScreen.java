package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    Handler h = new Handler();

   @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_splash_screen);
       ImageView loading = findViewById(R.id.loadImage);
       loading.animate().rotation(3600).setDuration(5000);
       h.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent i=new Intent(SplashScreen.this,MainActivity.class);
               startActivity(i);
               finish();
           }
       },5000);



    }

}