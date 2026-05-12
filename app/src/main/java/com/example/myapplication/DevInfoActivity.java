package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity to display Developer Information.
 * Part of Assignment 02 - TaskFlow App.
 * Student: Dinithi Uththara (2023t01906)
 */
public class DevInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_info);

        // 1. Initialize Global Navigation [Home, Info, Profile]
        // This connects the logic from your NavigationHelper class
        NavigationHelper.setupNavigation(this);

        // 2. Additional logic for specific buttons if needed
        // For example, if you added a back button in your XML:
        /*
        if (findViewById(R.id.btnBackDev) != null) {
            findViewById(R.id.btnBackDev).setOnClickListener(v -> finish());
        }
        */
    }

    @Override
    public void onBackPressed() {
        // Ensuring the back button returns the user to the Home screen
        super.onBackPressed();
        finish();
    }
}