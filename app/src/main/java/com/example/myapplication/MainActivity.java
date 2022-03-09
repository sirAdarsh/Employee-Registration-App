package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText name, doj, email, address;
    Button sbmt, fb;

    String sName, sEmail, sAddress, sDOJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.userName);
        doj = findViewById(R.id.userDOJ);
        email = findViewById(R.id.userEmail);
        address = findViewById(R.id.userAddress);
        sbmt = findViewById(R.id.submit);
        fb = findViewById(R.id.fb);

        sName = name.getText().toString();
        sEmail = email.getText().toString();
        sAddress = address.getText().toString();
        sDOJ = doj.getText().toString();

        sbmt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                // NOTIFICATION
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("MyNotif", "MyNotif", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(MainActivity.this, UserDetail.class);

                intent.putExtra("userName", sName).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "MyNotif")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Employee Details")
                        .setContentText("ADDED!")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                NotificationManagerCompat manager = NotificationManagerCompat.from(MainActivity.this);
                manager.notify(999, builder.build());

                processinsert(sName, sDOJ, sEmail, sAddress);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FetchData.class));
            }
        });

    }

    private void processinsert(String name, String doj, String email, String address) {
        String res = new dbmanager(this).addrecord(name, email, address, doj);
//        this.name.setText("");
//        this.doj.setText("");
//        this.email.setText("");
//        this.address.setText("");
        Toast.makeText(getApplicationContext(),res, Toast.LENGTH_SHORT).show();
    }
}