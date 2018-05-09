package com.xiaozhejun.learnaudiovideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yangzhe on 18-5-9.
 */
public class Lession1SurfaceViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }
}
