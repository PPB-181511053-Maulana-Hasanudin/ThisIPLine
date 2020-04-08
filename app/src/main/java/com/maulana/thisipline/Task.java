package com.maulana.thisipline;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {
    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "tugas")
    private String namaTugas;

    @ColumnInfo(name = "batas")
    private String batasWaktu;

    @ColumnInfo(name = "deskripsi")
    private String deskripsi;

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setBatasWaktu(String batasWaktu) {
        this.batasWaktu = batasWaktu;
    }

    public String getBatasWaktu() {
        return batasWaktu;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
