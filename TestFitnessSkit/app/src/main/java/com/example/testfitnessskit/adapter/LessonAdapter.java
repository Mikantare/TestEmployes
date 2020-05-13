package com.example.testfitnessskit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testfitnessskit.R;
import com.example.testfitnessskit.pojo.Lesson;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {


    private List<Lesson> lessons;

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item,parent,false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.textViewName.setText(lesson.getName());
        holder.textViewNameTeacher.setText(lesson.getTeacher());
        holder.textViewDescription.setText(lesson.getDescription());
        holder.textViewBeginLesson.setText(lesson.getStartTime());
        holder.textViewEndLesson.setText(lesson.getEndTime());
        holder.textViewPlase.setText(lesson.getPlace());
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewNameTeacher;
        private TextView textViewDescription;
        private TextView textViewBeginLesson;
        private TextView textViewEndLesson;
        private TextView textViewPlase;


        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNameTeacher = itemView.findViewById(R.id.textViewNameTeacher);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewBeginLesson = itemView.findViewById(R.id.textViewBeginLesson);
            textViewEndLesson = itemView.findViewById(R.id.textViewEndLesson);
            textViewPlase = itemView.findViewById(R.id.textViewPlase);
        }
    }
}
