package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class FetchData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataholder = new ArrayList<model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new dbmanager(this).readalldata();

        while(cursor.moveToNext()){
            model obj = new model(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            dataholder.add(obj);
        }

        recyclerView.setAdapter(new myAdapter(dataholder));

    }
}