package com.sachin.services_musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicSerivces extends Service
{
    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "service created", Toast.LENGTH_SHORT).show();

        mp=MediaPlayer.create(this,R.raw.ringtone);
        mp.setLooping(true);



    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Toast.makeText(this, "Service started", Toast.LENGTH_LONG).show();
        mp.start();

        // Get activity main thread.
        Thread currThread = Thread.currentThread();

        // Get main thread info.
        String threadInfo = getThreadInfo(currThread);

        // Log main thread info.
        Log.d("thread data", "Activity main thread info. " + threadInfo);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "service stop", Toast.LENGTH_SHORT).show();

        mp.stop();
    }

    public static String getThreadInfo(Thread thread)
    {
        long threadId = thread.getId();
        String threadName = thread.getName();
        int threadPriority = thread.getPriority();

        StringBuffer buffer = new StringBuffer();
        buffer.append(" id = ");
        buffer.append(threadId);
        buffer.append(" , name = ");
        buffer.append(threadName);
        buffer.append(" , priority = ");
        buffer.append(threadPriority);

        return buffer.toString();
    }

}
