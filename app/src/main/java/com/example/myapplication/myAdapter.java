package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{

    ArrayList<model> dataholder = new ArrayList<model>();

    public myAdapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.demail.setText(dataholder.get(position).getEmail());
        holder.daddress.setText(dataholder.get(position).getAddress());
        holder.ddoj.setText(dataholder.get(position).getDoj());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView dname,demail,daddress,ddoj;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.displayname);
            demail = itemView.findViewById(R.id.displayemail);
            daddress = itemView.findViewById(R.id.displayaddress);
            ddoj = itemView.findViewById(R.id.displaydoj);
        }
    }
}
