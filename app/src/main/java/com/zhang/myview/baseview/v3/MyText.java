package com.zhang.myview.baseview.v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class MyText extends BaseView {

    private Paint paint = new Paint();
    private float rx = 0;

    public MyText(Context context) {
        super(context);
    }

    public MyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(45);
        canvas.drawText("MyText", rx, 45, paint);
    }

    @Override
    protected void logic() {
        rx += 3;
        if(rx > getWidth()){
            rx = - paint.measureText("MyText");
        }
    }
}
