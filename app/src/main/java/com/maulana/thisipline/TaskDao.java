package com.maulana.thisipline;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task_table")
    List<Task> getAll();

    @Query("SELECT * FROM task_table WHERE tugas LIKE :tugas ")
    Task findByName(String tugas);

    @Insert
    void insertAll(Task task);

    @Delete
    public void deleteTasks(Task tasks);

    @Update
    public void update(Task task);

    @Delete
    public void deleteAll(Task task1,Task task2);

}
