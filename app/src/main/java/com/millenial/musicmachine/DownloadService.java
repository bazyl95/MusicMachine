package com.millenial.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DownloadService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
