package com.example.localservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation. Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    public class MyLocalBinder extends Binder {
        MyService getService() { return MyService.this;}
    }
    private final IBinder myBinder = new MyLocalBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {return myBinder;}
    public String GetCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
        return simpleDateFormat.format(new Date());
    }
}
