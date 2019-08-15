package com.millenial.musicmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadButton = findViewById(R.id.downloadButton);
        final DownloadThread thread = new DownloadThread();     // Doing exactly the same actions
        thread.setName("downloadThread");                       // by creating a separate thread object
        thread.start();                                         // and inherit everything from Thread class

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_LONG).show();

                // Send Messages to Handler for processing
                for (String song : Playlist.songs) {
                    Message message = Message.obtain();
                    message.obj = song;
                    thread.mHandler.sendMessage(message);
                }

            }
        });
    }
}