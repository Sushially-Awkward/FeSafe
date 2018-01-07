package com.example.dibyadarshan.fesafe;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class second extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
        URL url = null;
        try {
            url = new URL("https://raw.githubusercontent.com/mnaveenkumar2009/xceed-geekathon/master/sources/scraping/news.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Read all the text returned by the server
        final BufferedReader in;
        try {
            final String[] str = new String[1];
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            Timer t = new Timer();
            t.scheduleAtFixedRate(new TimerTask() {

                                      @Override
                                      public void run() {
                                          try {
                                              if((str[0] = in.readLine()) != null){
                                                  Intent temp = new Intent();
                                                  PendingIntent pIntent = PendingIntent.getActivity(second.this,0,temp,0);
                                                  Notification noti = new Notification.Builder(second.this)
                                                          .setTicker("Ticker")
                                                          .setContentTitle("News")
                                                          .setContentText(str[0])
                                                          .setSmallIcon(R.drawable.news)
                                                          .setDefaults(Notification.DEFAULT_ALL)
                                                          .setContentIntent(pIntent).getNotification();
                                                  noti.flags= Notification.FLAG_AUTO_CANCEL;
                                                  NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                                  nm.notify(0,noti);
                                              }
                                          } catch (IOException e) {
                                              e.printStackTrace();
                                          }
                                      }

                                  },
                    60000,
                    600000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button one = (Button)this.findViewById(R.id.button1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                }
                else{
                    mp.start();
                    SmsManager smsManager =     SmsManager.getDefault();
                    smsManager.sendTextMessage("+919886594337", null, "Help!", null, null);
                }

            }
        });
    }
    public void buttonClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(),svg.class);
        startActivity(intent);
    }
    public void hlpF(View v)
    {
        Intent intent = new Intent(getApplicationContext(),hlp.class);
        startActivity(intent);
    }
    public void dfcF(View v)
    {
        Intent intent = new Intent(getApplicationContext(),dfc.class);
        startActivity(intent);
    }
    public void findPoliceStations(View v){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=police stations near me");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void findHospitals(View v){

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals near me");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
