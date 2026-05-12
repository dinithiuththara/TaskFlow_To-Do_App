package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button btnSave = findViewById(R.id.btnSaveChanges);
        findViewById(R.id.btnBackEdit).setOnClickListener(v -> finish());

        btnSave.setOnClickListener(v -> {
            // Add your saving logic here
            Toast.makeText(this, "Changes Saved!", Toast.LENGTH_SHORT).show();
            finish(); // Returns to Profile Screen
        });
    }
}