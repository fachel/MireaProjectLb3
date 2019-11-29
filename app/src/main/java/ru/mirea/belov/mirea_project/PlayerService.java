package ru.mirea.belov.mirea_project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayerService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
// TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //в методе onCreate() производится инициализация медиа-проигрывателя
    //с помощью музыкального ресурса, который добавлен в папку res/raw.
    @Override
    public void onCreate(){
        mediaPlayer=MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
    }

    //в методе onStartCommand() начинается воспроизведение.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }

    //метод onDestroy() завершает воспроизведение.
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}
