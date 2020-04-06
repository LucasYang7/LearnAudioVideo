package com.xiaozhejun.learnaudiovideo.Lesson2.mp3

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.xiaozhejun.learnaudiovideo.R

class SampleMediaPlayerActivity : AppCompatActivity() {

    private var mp3Uri: String? = null
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_media_player)
        initMediaPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun initMediaPlayer() {
        mp3Uri = Environment.getExternalStorageDirectory().path.plus("/qqmusic/song/成都.mp3")
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(AudioAttributes.Builder().apply {
                setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            }.build())
            // 循环播放
            isLooping = true
            setDataSource(mp3Uri)
            prepare()
            start()
        }
    }
}
