package com.example.localservice;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyService myService;
    private boolean isBounded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

   ServiceConnection serviceConnection = new ServiceConnection() {
       @Override
       public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           MyService.MyLocalBinder myLocalBinder = (MyService.MyLocalBinder) iBinder;

           myService = myLocalBinder.getService();
           isBounded = true;
       }

       @Override
       public void onServiceDisconnected(ComponentName componentName) {isBounded = false; }
   };

    public void InitAction (View view){
        String time = myService.GetCurrentTime();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(time);
    }
}