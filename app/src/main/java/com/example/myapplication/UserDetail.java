package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    EditText name, doj, email, address;
    TextView detailName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailName = findViewById(R.id.detail_name);
        onNewIntent(getIntent());
    }
    @Override
    public void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if(extras!=null){
            if(extras.containsKey("userName")){
                setContentView(R.layout.activity_user_detail);
                String msg = extras.getString("userName");
                detailName.setText(msg);
            }
        }
        detailName.setText("DSD");
    }
}