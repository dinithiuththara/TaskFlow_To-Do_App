package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> taskList = new ArrayList<>();
    private TaskAdapter adapter;
    private int pendingCount = 0;
    private int completedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtStats = findViewById(R.id.txtStats);
        EditText etTaskInput = findViewById(R.id.etTaskInput);
        Button btnOk = findViewById(R.id.btnOk);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTasks);

        // Updated Adapter with Checkbox listener
        adapter = new TaskAdapter(taskList, isChecked -> {
            if (isChecked) {
                pendingCount--;
                completedCount++;
            } else {
                pendingCount++;
                completedCount--;
            }
            txtStats.setText(pendingCount + " pending   " + completedCount + " completed");
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnOk.setOnClickListener(v -> {
            String task = etTaskInput.getText().toString();
            if (!task.isEmpty()) {
                taskList.add(task);
                pendingCount++;
                txtStats.setText(pendingCount + " pending   " + completedCount + " completed");
                adapter.notifyItemInserted(taskList.size() - 1);
                etTaskInput.setText("");
            }
        });

        findViewById(R.id.btnInfo).setOnClickListener(v -> startActivity(new Intent(this, DevInfoActivity.class)));
        findViewById(R.id.btnProfile).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
    }
}