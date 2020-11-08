package com.soldemom.part6_17;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    Context context;

    public MyItemDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void getItemOffsets(
            @NonNull Rect outRect,
            @NonNull View view,
            @NonNull RecyclerView parent,
            @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //항목의 index 값 획득
        int index = parent.getChildAdapterPosition(view) + 1;

        if (index % 3 == 0) {
            //left, top, right, bottom
            outRect.set(20,20,20,60);
        } else {
            outRect.set(20,20,20,20);
        }

        view.setBackgroundColor(0xFFECE9E9);
        ViewCompat.setElevation(view,100.0f);
    }

//    @Override
//    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.onDraw(c, parent, state);
//
//        //RecyclerView의 사이즈 계산
//        int width = parent.getWidth();
//        int height = parent.getHeight();
//
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        c.drawRect(0,0,width/3,height,paint);
//        paint.setColor(Color.BLUE);
//        c.drawRect(width/3,0,width/3*2,height,paint);
//        paint.setColor(Color.GREEN);
//        c.drawRect(width/3*2,0,width,height,paint);
//    }

    //RecyclerView에 항목이 모두 추가된 후에 그림을 그리는것
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        //RecyclerView의 사이즈
        int width = parent.getWidth();
        int height = parent.getHeight();

        //이미지 사이즈 계산
        Drawable dr = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_launcher_foreground, null);
        int drWidth = dr.getIntrinsicWidth();
        int drHeight = dr.getIntrinsicHeight();


        int left = width/2 - drWidth/2;
        int top = height/2 - drHeight/2;
//        c.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_foreground),left, top, null);


    }
}
