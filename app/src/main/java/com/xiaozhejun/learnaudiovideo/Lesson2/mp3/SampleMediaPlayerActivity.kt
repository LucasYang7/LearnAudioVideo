package com.xiaozhejun.learnaudiovideo.Lesson2.mp3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xiaozhejun.learnaudiovideo.R
import kotlinx.android.synthetic.main.activity_sample_media_player.*

class SampleMediaPlayerActivity : AppCompatActivity(), View.OnClickListener {

    private var mp3PlayBinder: PlayMp3Binder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_media_player)
        btn_play_mp3.setOnClickListener(this@SampleMediaPlayerActivity)
        btn_pause_mp3.setOnClickListener(this@SampleMediaPlayerActivity)
        btn_stop_mp3.setOnClickListener(this@SampleMediaPlayerActivity)
        val intent = Intent(this@SampleMediaPlayerActivity, Mp3Service::class.java)
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(mServiceConnection)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_play_mp3 -> {
                mp3PlayBinder?.startPlayMp3()
            }

            R.id.btn_pause_mp3 -> {
                mp3PlayBinder?.pausePlayMp3()
            }

            R.id.btn_stop_mp3 -> {
                mp3PlayBinder?.stopPlayMp3()
            }
        }
    }

    private var mServiceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mp3PlayBinder = service as? PlayMp3Binder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mp3PlayBinder = null
        }
    }
}
