package com.example.projekt;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class TaskDao {
    @Query("SELECT * FROM task")
    public abstract List<Task> getAll();

    @Query("SELECT * FROM task WHERE uid =:uid LIMIT 1")
    public abstract Task findById(int uid);

    @Query("SELECT * FROM task ORDER BY uid DESC LIMIT 1")
    public abstract Task last();

    @Query("SELECT COUNT(*) FROM task")
    public abstract Integer count();

    @Insert
    public abstract void insertAll(Task... task);

    @Delete
    public abstract void delete(Task task);
}
