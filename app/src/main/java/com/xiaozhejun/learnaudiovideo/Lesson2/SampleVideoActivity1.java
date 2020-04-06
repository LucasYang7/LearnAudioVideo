package com.xiaozhejun.learnaudiovideo.Lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

import com.xiaozhejun.learnaudiovideo.R;

public class SampleVideoActivity1 extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_video1);
        // VideoView继承自SurfaceView,内部通过MediaPlayer进行播放视频
        mVideoView = findViewById(R.id.video_view);
        String videoPath = Environment.getExternalStorageDirectory().getPath().concat("/DCIM/Camera/1.mp4");
        mVideoView.setVideoPath(videoPath);
        // MediaController继承自FrameLayout，内部通过MediaPlayerControl控制播放视频
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();
    }
}
