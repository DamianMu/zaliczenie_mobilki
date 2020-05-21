package com.example.zaliczenienotatki;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Calculation {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "a")
    public Integer a;

    @ColumnInfo(name = "b")
    public Integer b;

    @ColumnInfo(name = "c")
    public Integer c;

    @ColumnInfo(name = "current")
    public Boolean current;

    public Calculation(Integer a, Integer b, Integer c, Boolean current) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.current = current;
    }
}
