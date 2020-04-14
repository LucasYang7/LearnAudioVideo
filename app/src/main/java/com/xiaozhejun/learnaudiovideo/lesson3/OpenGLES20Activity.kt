package com.xiaozhejun.learnaudiovideo.lesson3

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaozhejun.learnaudiovideo.R

class OpenGLES20Activity : AppCompatActivity() {

    private var mGLView: GLSurfaceView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_open_gles20)
        mGLView = MyGLSurfaceView(this)
        setContentView(mGLView)
    }
}
