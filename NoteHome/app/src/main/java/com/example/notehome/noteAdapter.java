package com.example.notehome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class noteAdapter extends RecyclerView.Adapter<noteAdapter.noteViewHolder> {

    private ArrayList<Note> notes;

    public noteAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public noteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_description, parent, false);
        return new noteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(note.getDescription());
        holder.textViewDayOfWeek.setText(Note.getStringDayOfWeek(note.getDayOfWeek()));
        int priority = note.getPriority();
        switch (priority) {
            case 1:
                holder.textViewTitle.setBackgroundColor(holder.itemView.getResources().getColor(android.R.color.holo_red_light));
                break;
            case 2:
                holder.textViewTitle.setBackgroundColor(holder.itemView.getResources().getColor(android.R.color.holo_orange_light));
                break;
            default:
                holder.textViewTitle.setBackgroundColor(holder.itemView.getResources().getColor(android.R.color.holo_green_light));
                break;
        }

    }

    @Override
    public int getItemCount() {

        return notes.size();
    }

    class noteViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDayOfWeek;


        public noteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek = itemView.findViewById(R.id.textViewDayOfWeek);
        }
    }
}
