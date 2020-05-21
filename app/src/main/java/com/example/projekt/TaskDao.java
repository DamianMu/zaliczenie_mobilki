package com.example.zaliczenienotatki;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class NoteDao {
    @Query("SELECT * FROM note")
    public abstract List<Note> getAll();

    @Query("SELECT * FROM note WHERE uid =:uid LIMIT 1")
    public abstract Note findById(int uid);

    @Query("SELECT * FROM note ORDER BY uid DESC LIMIT 1")
    public abstract Note last();

    @Insert
    public abstract void insertAll(Note... note);

    @Delete
    public abstract void delete(Note note);
}
