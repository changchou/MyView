package com.zhang.myview.music;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import com.zhang.myview.R;

import java.util.ArrayList;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class MusicView extends BaseView {

    //    private MusicItem musicItem;
    private ArrayList<MusicItem> list = new ArrayList<>();
    private int itemNum = 20;
    private int itemWidth = 20;
    private int musicColor = Color.CYAN;
    private boolean randColor = false;
    private int musicType = 3;

    public MusicView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MusicView);
        itemNum = ta.getInteger(R.styleable.MusicView_itemNum, 20);
        itemWidth = ta.getDimensionPixelSize(R.styleable.MusicView_itemWidth, 20);
        musicColor = ta.getColor(R.styleable.MusicView_musicColor, Color.CYAN);
        randColor = ta.getBoolean(R.styleable.MusicView_musicRandColor, false);
        musicType = ta.getInteger(R.styleable.MusicView_musicType, 3);
        ta.recycle();
    }

    public MusicView(Context context) {
        super(context);
    }

    @Override
    protected void drawSub(Canvas canvas) {
//        musicItem.draw(canvas);
        for (MusicItem item : list) {
            item.draw(canvas);
        }
    }

    @Override
    protected void logic() {
//        musicItem.move();
        for (MusicItem item : list) {
            item.move();
        }
    }

    @Override
    protected void init() {
//        musicItem = new MusicItem(getHeight());
        for (int i = 0; i < itemNum; i++) {
//            list.add(new MusicItem(getHeight(), getWidth() / itemNum * i, itemWidth));
//            list.add(new MusicItem( getHeight(),getWidth() / itemNum * i, itemWidth, musicColor));
//            list.add(new MusicItem(getHeight(), getWidth() / itemNum * i, itemWidth, musicColor, randColor));
            list.add(new MusicItem(getHeight(), getWidth() / itemNum * i, itemWidth, musicColor, randColor, musicType));
        }
        sleepTime = 150;
    }
}
