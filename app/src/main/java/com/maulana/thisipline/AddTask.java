package com.maulana.thisipline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import static com.maulana.thisipline.TIPLApp.db;

public class AddTask extends AppCompatActivity {
    private FloatingActionButton okkey;
    private FloatingActionButton batal;
    private EditText tiplTugas;
    private EditText tiplBatasWaktu;
    private EditText tiplDeskripsi;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        okkey = findViewById(R.id.ok);
        batal = findViewById(R.id.no);
        tiplTugas = findViewById(R.id.edit_nama_tugas);
        tiplBatasWaktu = findViewById(R.id.edit_bataswaktu);
        tiplDeskripsi = findViewById(R.id.edit_deskripsi);

        okkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tiplTugas.getText().toString().isEmpty()&&!tiplBatasWaktu.getText().toString().isEmpty()
                        &&!tiplDeskripsi.getText().toString().isEmpty()){

                    task = new Task();
                    task.setNamaTugas(tiplTugas.getText().toString());
                    task.setBatasWaktu(tiplBatasWaktu.getText().toString());
                    task.setDeskripsi(tiplDeskripsi.getText().toString());
                    db.taskDao().insertAll(task);

                    Toast.makeText(getApplicationContext(),"Tugas Bertambah",Toast.LENGTH_LONG).show();

                    Intent okkey = new Intent(AddTask.this,MainActivity.class);
                    startActivity(okkey);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Data Tidak Valid",Toast.LENGTH_LONG).show();
                }
            }
        });

        batal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent iBatal = new Intent(AddTask.this,MainActivity.class);
                startActivity(iBatal);
                finish();
            }
        });
    }
}
