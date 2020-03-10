package com.example.note;

public class Note {
    private String title;
    private String descriptyion;
    private String dayOfWeek;
    private int priority;
    private int id;

    public Note(int id, String title, String descriptyion, String dayOfWeek, int priority) {
        this.id = id;
        this.title = title;
        this.descriptyion = descriptyion;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriptyion() {
        return descriptyion;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriority() {
        return priority;
    }
}
