package com.example.dibyadarshan.fesafe;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int PERMISSION_REQUEST_CODE = 1;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

            }
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void start(View view) {
        Intent intent = new Intent(getApplicationContext(), second.class);
        startActivity(intent);
        try {
            URL url = new URL("https://raw.githubusercontent.com/mnaveenkumar2009/xceed-geekathon/master/sources/tipoftheday.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            final String str=in.readLine();
            in.close();

            Intent temp = new Intent();
            PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,0,temp,0);
            Notification noti = new Notification.Builder(MainActivity.this)
                    .setContentTitle("Tip of the Day")
                    .setContentText(str)
                    .setSmallIcon(R.drawable.one)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setContentIntent(pIntent).getNotification();
            noti.flags= Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0,noti);

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }
}
