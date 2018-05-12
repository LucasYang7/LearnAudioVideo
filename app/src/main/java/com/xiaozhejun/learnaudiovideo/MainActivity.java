package com.xiaozhejun.learnaudiovideo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiaozhejun.learnaudiovideo.Lesson1.LessonSurfaceViewActivity;
import com.xiaozhejun.learnaudiovideo.Lesson1.LessonImageViewActivity;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 如果没有权限，则在运行时需要动态申请相关权限
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
        Button btnLesson1ImageView = (Button) findViewById(R.id.btn_lesson_1_imageview);
        btnLesson1ImageView.setOnClickListener(click);
        Button btnLesson1SurfaceView = (Button) findViewById(R.id.btn_lesson_1_sufaceview);
        btnLesson1SurfaceView.setOnClickListener(click);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted and now can proceed
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "无法获取读取外存权限，可能影响下载和分享图片等功能!",
                            Toast.LENGTH_SHORT).show();
                }
                return;
            }
            // add other cases for more permissions
        }
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_lesson_1_imageview:
                    gotoOtherActivity(LessonImageViewActivity.class);
                    break;
                case R.id.btn_lesson_1_sufaceview:
                    gotoOtherActivity(LessonSurfaceViewActivity.class);
                default:
                    break;
            }
        }
    };

    /**
     * goto other activity
     */
    private void gotoOtherActivity(Class clazz) {
        Intent intent = new Intent(MainActivity.this, clazz);
        startActivity(intent);
    }
}
