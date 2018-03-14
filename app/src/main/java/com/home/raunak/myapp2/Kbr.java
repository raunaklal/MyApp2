package com.home.raunak.myapp2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Kbr extends Service implements MediaPlayer.OnCompletionListener{
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.kabira);
    }
/*
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (!mp.isLooping()){
            mp.start();
        }
    }
*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isLooping()){
            mp.start();
        }
        if(mp.isPlaying()){
            mp.pause();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying()){
            mp.stop();
        }
    }

}
