package com.millenial.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class DownloadHandler extends Handler {
    private static final String TAG = DownloadHandler.class.getSimpleName();
    private DownloadService mService;

    @Override
    public void handleMessage(@NonNull Message msg) {
        downloadSong(msg.obj.toString());
        mService.stopSelf(msg.arg1);

    }

    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10 * 1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d(TAG, song + " successfully downloaded");
    }

    public void setService(DownloadService downloadService) {
        mService = downloadService;
    }
}
