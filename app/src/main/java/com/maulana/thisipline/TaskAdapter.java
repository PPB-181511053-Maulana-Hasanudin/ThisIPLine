package com.maulana.thisipline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    private ArrayList<Task> dataList;

    public TaskAdapter(ArrayList<Task> dataList){
        this.dataList = dataList;
    }

    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.thisipline_task, parent, false);
        return new TaskViewHolder(view);
    }

    public void onBindViewHolder(TaskViewHolder holder, int position){
        holder.txtNamaTugas.setText(dataList.get(position).getNamaTugas());
        holder.txtBatasWaktu.setText(dataList.get(position).getBatasWaktu());
        holder.txtDeskripsi.setText(dataList.get(position).getDeskripsi());
    }

    public int getItemCount(){
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaTugas, txtBatasWaktu, txtDeskripsi;

        public TaskViewHolder(View itemView){
            super(itemView);
            txtNamaTugas = (TextView) itemView.findViewById(R.id.tugas);
            txtBatasWaktu = (TextView) itemView.findViewById(R.id.deadline);
            txtDeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
        }
    }
}
