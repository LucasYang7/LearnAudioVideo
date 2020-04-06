package com.xiaozhejun.learnaudiovideo.Lesson2.mp3

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Binder
import android.os.Environment
import android.os.IBinder
import android.util.Log

class Mp3Service : Service() {

    companion object {
        const val TAG = "Mp3Service"
    }

    private var mPlayMp3Binder = PlayMp3Binder()

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Mp3Service onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Mp3Service onStartCommand()")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        mPlayMp3Binder.initAndPlayMp3()
        Log.d(TAG, "Mp3Service onBind()")
        return mPlayMp3Binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "Mp3Service onUnbind()")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayMp3Binder.releaseMediaPlayer()
        Log.d(TAG, "Mp3Service onDestroy()")
    }
}

class PlayMp3Binder : Binder() {
    private var mp3Uri: String? = null
    private var mediaPlayer: MediaPlayer? = null

    fun startPlayMp3() {
        mediaPlayer?.start()
    }

    fun pausePlayMp3() {
        mediaPlayer?.pause()
    }

    fun stopPlayMp3() {
        mediaPlayer?.stop()
    }

    // 初始化播放器
    fun initAndPlayMp3() {
        if (mp3Uri == null || mediaPlayer == null) {
            mp3Uri = Environment.getExternalStorageDirectory().path.plus("/qqmusic/song/成都.mp3")
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(AudioAttributes.Builder().apply {
                    setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                }.build())
                // 循环播放
                isLooping = true
                setDataSource(mp3Uri)
                // 使用prepareAsync防止阻塞主线程，但是需要注册监听MediaPlayer.OnPreparedListener
                prepareAsync()
            }
            mediaPlayer?.setOnPreparedListener {
                Log.d(Mp3Service.TAG, "mediaPlayer is prepared.")
            }
        }
    }

    // 销毁播放器
    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        Log.d(Mp3Service.TAG, "releaseMediaPlayer()")
    }
}