package com.zhang.myview.music;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class MusicItem implements IAnimation {

    private Paint paint = new Paint();
    private Random random = new Random();
    private int itemWidth;//宽度 view中赋值
    private int musicColor = Color.CYAN;//颜色 xml赋值给view 再传给item
    private boolean randColor = false;//颜色随机 xml赋值给view 再传给item
    //矩形
    private int maxHeight;//view高度 view中得到
    private int height;
    private int x;//x轴起始坐标  view中传数量计算
    //多矩形
    private int maxRectNum;
    private int rectNum;
    private int distance = 3;
    //镜像
    private int centerY;

    private final int RECT = 1; // 矩形
    private final int MRECT = 2; // 多矩形
    private final int MMRECT = 3; // 镜像
    private int state = MMRECT;//状态 xml赋值给view 再传给item

    public MusicItem(int maxHeight) {
        this.maxHeight = maxHeight;
        paint.setColor(Color.BLUE);
    }

    public MusicItem(int maxHeight, int x, int itemWidth) {
        this.maxHeight = maxHeight;
        this.x = x;
        this.itemWidth = itemWidth;

        init();
    }

    public MusicItem(int maxHeight, int x, int itemWidth, int musicColor) {
        this.x = x;
        this.maxHeight = maxHeight;
        this.itemWidth = itemWidth;
        this.musicColor = musicColor;

        init();
    }

    public MusicItem(int maxHeight, int x, int itemWidth, int musicColor, boolean randColor) {
        this.musicColor = musicColor;
        this.randColor = randColor;
        this.maxHeight = maxHeight;
        this.x = x;
        this.itemWidth = itemWidth;

        init();
    }

    public MusicItem(int maxHeight, int x, int itemWidth, int musicColor, boolean randColor,int musicType) {
        this.musicColor = musicColor;
        this.randColor = randColor;
        this.maxHeight = maxHeight;
        this.x = x;
        this.itemWidth = itemWidth;
        this.state = musicType;

        init();
    }

    private void init() {
        if (randColor) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            paint.setARGB(255, r, g, b);
        } else {
            paint.setColor(musicColor);
        }
        switch (state) {
            case MRECT:
                maxRectNum = maxHeight / (itemWidth + distance);
                break;
            case MMRECT:
                centerY = maxHeight / 2;
                maxRectNum = centerY / (itemWidth + distance);
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        switch (state) {
            case RECT:
                canvas.drawRect(x, height, x + itemWidth, maxHeight, paint);
                break;
            case MRECT:
                int num = maxRectNum - rectNum;
                for (int i = 0; i < rectNum; i++) {
                    canvas.drawRect(x, (itemWidth + distance) * (i + num), x + itemWidth, (itemWidth + distance) * (i + 1 + num) - distance, paint);
                }
                break;
            case MMRECT:
//                paint.setAlpha(255);
                int num1 = maxRectNum - rectNum;
                for (int i = 0; i < rectNum; i++) {
                    paint.setAlpha(255);
                    canvas.drawRect(x, (itemWidth + distance) * (i + num1), x + itemWidth, (itemWidth + distance) * (i + 1 + num1) - distance, paint);
                    paint.setAlpha(60);
                    canvas.drawRect(x, (itemWidth + distance) * (i + maxRectNum), x + itemWidth, (itemWidth + distance) * (i + 1 + maxRectNum) - distance, paint);
                }
//                paint.setAlpha(60);
//                for (int i = 0; i < rectNum; i++) {
//                    canvas.drawRect(x, (itemWidth + distance) * (i + maxRectNum), x + itemWidth, (itemWidth + distance) * (i + 1 + maxRectNum) - distance, paint);
//                }
                break;
        }


    }

    @Override
    public void move() {
        if (randColor) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            paint.setARGB(255, r, g, b);
        } else {
            paint.setColor(musicColor);
        }
        switch (state) {
            case RECT:
                height = random.nextInt(maxHeight);
                break;
            case MRECT:
            case MMRECT:
                rectNum = 1 + random.nextInt(maxRectNum);
                break;
        }
    }
}
