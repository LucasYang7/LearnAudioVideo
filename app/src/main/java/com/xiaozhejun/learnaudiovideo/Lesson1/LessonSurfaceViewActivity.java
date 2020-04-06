package com.xiaozhejun.learnaudiovideo.Lesson1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by yangzhe on 18-5-9.
 */
public class LessonSurfaceViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }
}
