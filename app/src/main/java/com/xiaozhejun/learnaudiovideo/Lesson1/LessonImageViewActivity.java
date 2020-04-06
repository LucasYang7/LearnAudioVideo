package com.xiaozhejun.learnaudiovideo.Lesson1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.xiaozhejun.learnaudiovideo.R;

public class LessonImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_imageview);
        showBitmapInImageView();
    }

    private void showBitmapInImageView() {
        ImageView img = (ImageView) findViewById(R.id.iv_show_bitmap);
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()
                .getPath().concat("/Download/1.jpg"));
        img.setImageBitmap(bitmap);
    }

}
