package com.zhang.myview.rain.v2;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class RainItem {

    private int width;
    private int height;

    private float startX;
    private float startY;
    private float stopX;
    private float stopY;
    private float sizeX;
    private float sizeY;
    private float opt;
    private Paint paint;
    private Random random;

    private int size = 20;
    private int color;
    private boolean randColor = false;

    public RainItem(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    public RainItem(int width, int height, int size) {
        this.width = width;
        this.height = height;
        this.size = size;
        init();
    }

    public RainItem(int width, int height, int size, int color) {
        this.width = width;
        this.height = height;
        this.size = size;
        this.color = color;
        init();
    }

    public RainItem(int width, int height, int size, int color, boolean randColor) {
        this.width = width;
        this.height = height;
        this.size = size;
        this.color = color;
        this.randColor = randColor;
        init();
    }

    private void init() {
        paint = new Paint();
        random = new Random();
        startX = random.nextInt(width);
        startY = random.nextInt(height);
        sizeX = 1 + random.nextInt(size / 2);
        sizeY = 10 + random.nextInt(size);
        stopX = startX + sizeX;
        stopY = startY + sizeY;
        opt = 0.2f + random.nextFloat();

        if (randColor) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            paint.setARGB(255, r, g, b);
        } else {
            paint.setColor(color);
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }

    public void move() {
        startX += sizeX * opt;
        stopX += sizeX * opt;

        startY += sizeY * opt;
        stopY += sizeY * opt;

        if (startY > height) {
            init();
        }
    }
}
