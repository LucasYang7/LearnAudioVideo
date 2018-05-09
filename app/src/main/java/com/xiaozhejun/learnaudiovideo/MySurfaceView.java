package com.xiaozhejun.learnaudiovideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by yangzhe on 18-5-8.
 */
public class MySurfaceView extends SurfaceView {
    private Bitmap mBitmap;
    private SurfaceHolder mHolder;

    public MySurfaceView(Context context) {
        super(context);
        mHolder = getHolder();
        mBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()
                        .getPath().concat("/Download/2.jpg")); // 获取bitmap
        mHolder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas c = holder.lockCanvas(null);
                onDraw(c);
                holder.unlockCanvasAndPost(c);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(mBitmap, getLeft(), getTop(), null);
    }
}
