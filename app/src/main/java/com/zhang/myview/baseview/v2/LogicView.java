package com.zhang.myview.baseview.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class LogicView extends View {

    private Paint paint = new Paint();
    private float rx = 0;
    private MyThread thread;
    private RectF rectF = new RectF(0 ,60 ,100, 160);
    private float sweepAngle = 0;

    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setTextSize(42);
        canvas.drawText("LogicView", rx, 42, paint);

        canvas.drawArc(rectF, 0, sweepAngle, true, paint);

        if(thread == null){
            thread = new MyThread();
            thread.start();
        }
    }

    class MyThread extends Thread{
        Random rand = new Random();

        @Override
        public void run() {

            while(true){
                rx += 3;

                if(rx > getWidth()){
                    rx = 0 - paint.measureText("LogicView");
                }

                sweepAngle ++;
                if(sweepAngle > 360){
                    sweepAngle = 0;
                }

                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);

                paint.setARGB(255, r, g, b);

                postInvalidate();

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
