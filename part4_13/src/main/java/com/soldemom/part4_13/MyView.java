package com.soldemom.part4_13;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    Context context;

    public MyView(Context context) {
        super(context);


    }

    public MyView(Context context, AttributeSet attrs) {
        super(context,attrs);

        this.context = context;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
//            color = a.getColor(R.styleable.MyView_customColor,Color.RED);
        }

        String attribute = "";
        for (int i = 0; i<attrs.getAttributeCount(); i++) {
            attribute = attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i);
        }


    }





    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawColor(Color.alpha(Color.CYAN));

        RectF rect = new RectF(15,15,160,160);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawArc(rect,0,360,false,paint);
    }


}

