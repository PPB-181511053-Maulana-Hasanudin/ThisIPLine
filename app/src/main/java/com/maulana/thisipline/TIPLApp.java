package com.maulana.thisipline;

import android.app.Application;

import androidx.room.Room;

public class TIPLApp extends Application {
    public static TaskDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class,"Task").allowMainThreadQueries().build();
    }
}
