package com.example.myapplication; // This MUST match your project's folder name

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Edit Profile Navigation
        findViewById(R.id.btnEdit).setOnClickListener(v -> {
            startActivity(new Intent(this, EditProfileActivity.class));
        });

        // Sign Out Logic
        findViewById(R.id.btnSignOut).setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // Navigation Bar Logic
        findViewById(R.id.navHome).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}