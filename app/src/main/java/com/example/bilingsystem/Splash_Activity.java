package com.example.bilingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.bilingsystem.databinding.ActivitySplashBinding;

public class Splash_Activity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash );
        SystemClock.sleep( 3000 );
        Intent billingOpen = new Intent(this,MainActivity.class);
        startActivity( billingOpen );
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}