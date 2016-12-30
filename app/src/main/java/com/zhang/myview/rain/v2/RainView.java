package com.zhang.myview.rain.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.zhang.myview.R;

import java.util.ArrayList;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class RainView extends BaseView {

    private ArrayList<RainItem> list = new ArrayList<>();
    private int rainNum = 80;
    private int size;
    private int rainColor;
    private boolean randColor;

    public RainView(Context context) {
        super(context);
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RainView);
        rainNum = ta.getInteger(R.styleable.RainView_rainNum, 80);
        size = ta.getInteger(R.styleable.RainView_size, 20);
        rainColor = ta.getInteger(R.styleable.RainView_rainColor, 0xffffffff);
        randColor = ta.getBoolean(R.styleable.RainView_randColor, false);
        ta.recycle();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (RainItem rain : list) {
            rain.draw(canvas);
        }
    }

    @Override
    protected void logic() {
        for (RainItem rain : list) {
            rain.move();
        }
    }

    @Override
    protected void init() {
        for (int i = 0; i < rainNum; i++) {
            RainItem rain = new RainItem(getWidth(), getHeight(), size, rainColor, randColor);
            list.add(rain);
        }
    }
}
