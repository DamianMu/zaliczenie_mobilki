package com.example.projekt;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "status")
    public String status;

    public Task(String text, String title, String status) {
        this.text = text;
        this.title = title;
        this.status = status;
    }
}
