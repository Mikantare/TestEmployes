package com.example.notehome;

public class Note {
    private String title;
    private String description;
    private int dayOfWeek;
    private int priority;
    private int id;

    public Note(String title, String description, int dayOfWeek, int priority, int id) {
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public static String getStringDayOfWeek (int position){
        switch (position) {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            default:
                return "Воскресенье";
        }
    }
}
