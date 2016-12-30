package com.zhang.myview.rain.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public abstract class BaseView extends View {

    private MyThread thread;
    private boolean running = true;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void drawSub(Canvas canvas);

    protected abstract void logic();

    protected abstract void init();

    @Override
    protected final void onDraw(Canvas canvas) {
        if (thread == null) {
            thread = new MyThread();
            thread.start();
        } else {
            drawSub(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            //此时以获取View宽高
            init();
            while (running) {

                logic();
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
