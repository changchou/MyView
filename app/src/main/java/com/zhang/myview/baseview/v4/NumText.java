package com.zhang.myview.baseview.v4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.zhang.myview.R;
import com.zhang.myview.baseview.v3.BaseView;

/**
 * Created by Mr.Z on 2016/12/29 0029.
 */

public class NumText extends BaseView {

    private Paint paint = new Paint();
    private int lineNum = 0;
    private int mx = 0;
    private boolean xScroll = false;

    public NumText(Context context) {
        super(context);
    }

    public NumText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NumText);
        lineNum = ta.getInt(R.styleable.NumText_lineNum, 1);
        xScroll = ta.getBoolean(R.styleable.NumText_xScroll, false);
        ta.recycle();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (int i = 0; i < lineNum; i++) {
            int textSize = 30 + i;
            paint.setTextSize(textSize);
            canvas.drawText("Hello Anny", mx, textSize + textSize * i, paint);
        }
    }

    @Override
    protected void logic() {
        if (xScroll) {
            mx += 3;
            if (mx > getWidth()) {
                mx = (int) -paint.measureText("Hello Anny");
            }
        }
    }
}
