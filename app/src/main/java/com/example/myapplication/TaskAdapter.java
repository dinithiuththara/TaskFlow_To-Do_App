package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<String> tasks;
    private OnTaskStatusChangedListener listener;

    public interface OnTaskStatusChangedListener {
        void onStatusChanged(boolean isChecked);
    }

    public TaskAdapter(ArrayList<String> tasks, OnTaskStatusChangedListener listener) {
        this.tasks = tasks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use your custom item_task layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.taskText.setText(tasks.get(position));

        // Reset state to avoid recycling bugs
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(false);
        holder.taskText.setPaintFlags(holder.taskText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        holder.taskText.setTextColor(Color.BLACK);

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Strike-through effect
                holder.taskText.setPaintFlags(holder.taskText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.taskText.setTextColor(Color.GRAY);
            } else {
                // Remove Strike-through
                holder.taskText.setPaintFlags(holder.taskText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                holder.taskText.setTextColor(Color.BLACK);
            }
            listener.onStatusChanged(isChecked);
        });
    }

    @Override
    public int getItemCount() { return tasks.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskText;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            taskText = itemView.findViewById(R.id.taskText);
            checkBox = itemView.findViewById(R.id.taskCheckbox);
        }
    }
}