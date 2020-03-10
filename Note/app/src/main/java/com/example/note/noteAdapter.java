package com.example.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class noteAdapter extends RecyclerView.Adapter <noteAdapter.NoteViewHolder> {


    private ArrayList <Note> notes;
    private OnNoteClickListener onNoteClickListener;

    interface OnNoteClickListener {
        void OnNoteClick (int position);
        void OnNoteLongClick (int position);
    }

    public noteAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_description,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewTitle.setText(note.getTitle());
        holder.textViewDescription.setText(note.getDescriptyion());
        holder.textViewDayOfWeek.setText(note.getDayOfWeek());
        int priority = note.getPriority();
        switch (priority){
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



    class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewDayOfWeek;

        public NoteViewHolder(@NonNull View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewDayOfWeek = itemView.findViewById(R.id.textViewDayOfWeek);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClickListener != null){
                        onNoteClickListener.OnNoteClick(getAdapterPosition());
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onNoteClickListener != null) {
                        onNoteClickListener.OnNoteLongClick(getAdapterPosition());
                    }

                    return true;
                }
            });

        }
    }
}
