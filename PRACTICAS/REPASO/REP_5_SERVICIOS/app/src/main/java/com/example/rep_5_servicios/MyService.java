package com.example.rep_5_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Intent miIntento;
    Thread thread;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MI SERVICIO", "ONCREATE");

    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MI SERVICIO", intent.getStringExtra("DATO"));
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //Log.wtf("MI SERVICIO", "THREAD");
                        miIntento= new Intent("MI SERVICIO");
                        miIntento.putExtra("ENVIADOS", "Escuchando my servicio");
                    sendBroadcast(miIntento);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MI SERVICIO", "ONDESTROY");
        thread.interrupt();
    }

}


