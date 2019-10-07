package com.example.notes;

import android.util.Log;
import android.widget.Toast;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tittle;
    private String description;
    private int dayOfWeek;
    private int priority;

    public String getTittle() {
        return tittle;
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
    @Ignore
    public Note(String tittle, String description, int dayOfWeek, int priority) {
        this.tittle = tittle;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public Note(int id, String tittle, String description, int dayOfWeek, int priority) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static String getDayAsString(int position){
        switch (position){
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