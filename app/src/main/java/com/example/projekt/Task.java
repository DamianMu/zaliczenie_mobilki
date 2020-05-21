package com.example.zaliczenienotatki;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "title")
    public String title;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
