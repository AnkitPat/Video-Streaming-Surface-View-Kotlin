package com.example.bbim1041.videostreamingdemo

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.media.AudioManager
import android.widget.MediaController


class MainActivity : AppCompatActivity(), SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {
    private var mediaPlayer: MediaPlayer? = null
    private var vidHolder: SurfaceHolder? = null
    private var vidSurface: SurfaceView? = null
    var vidAddress = "https://s3-eu-west-1.amazonaws.com/bbi.appsdata.2013/Modular+Apps/Test2/how_to_use.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vidSurface =  findViewById(R.id.surfView);
        vidHolder = vidSurface!!.getHolder();
        vidHolder!!.addCallback(this);


        
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
        
    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        try {
            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setDisplay(vidHolder)
            mediaPlayer!!.setDataSource(vidAddress)
            mediaPlayer!!.prepare()
            mediaPlayer!!.setOnPreparedListener(this)
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer!!.start();
    }
}
