package com.home.raunak.myapp2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyNotificationDemo extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification_demo);
        button=findViewById(R.id.button20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplication()).setSmallIcon(R.drawable.pick).setContentTitle("Notifications Example").setContentTitle("This is a test notification");

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);

                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });
    }
}
