package com.maulana.thisipline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.maulana.thisipline.TIPLApp.db;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addTaskByFab;
    private List<Task> tasks = new ArrayList<>();
    private TaskAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTaskDataAdapter();
        setupRecyclerView();

        addTaskByFab = findViewById(R.id.fabAdder);
        addTaskByFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAddTask = new Intent(MainActivity.this, AddTask.class);
                startActivity(iAddTask);
            }
        });
    }
    private void setTaskDataAdapter(){
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class,"Tugas").allowMainThreadQueries().build();
        tasks = db.taskDao().getAll();

        mAdapter = new TaskAdapter((ArrayList<Task>) tasks);
    }
    private void setupRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);

    }


}