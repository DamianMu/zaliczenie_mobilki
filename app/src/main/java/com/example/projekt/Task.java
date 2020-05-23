package com.example.projekt;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "status")
    public String status;

    public Task(String description, String title, String status) {
        this.description = description;
        this.title = title;
        this.status = status;
    }
}
