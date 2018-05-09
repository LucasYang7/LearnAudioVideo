package com.xiaozhejun.learnaudiovideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yangzhe on 18-5-9.
 */
public class MyCustomView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private int mDefaultWidth;    // 当自定义View宽度为wrap_content时对应的默认宽度
    private int mDefaultHeight;   // 当自定义View宽度为wrap_content时对应的默认高度

    public MyCustomView(Context context) {
        super(context);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // 如果自定义View的宽度或者高度为wrap_content,则将Bitmap的宽度和高度作为自定义View的默认宽度和高度
        int measuredWidth = getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT
                ? mDefaultWidth : widthSize;
        int measuredHeight = getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT
                ? mDefaultHeight : heightSize;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            // 这里的left和top是以MyCustomView的左上角坐标为参考点的
            canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        }
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mBitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()
                .getPath().concat("/Download/2.jpg"));
        mDefaultWidth = mBitmap.getWidth();
        mDefaultHeight = mBitmap.getHeight();
    }
}
