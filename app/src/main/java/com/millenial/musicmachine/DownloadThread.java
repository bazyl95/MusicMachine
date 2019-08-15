package com.millenial.musicmachine;

import android.os.Looper;
import android.util.Log;

public class DownloadThread extends Thread {
    public DownloadHandler mHandler;

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }
}
