package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {


    List<Paint> mPaintList;
    List<Path> mPathList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;

    public void setup() {
        mPaintList = new ArrayList<Paint>();
        mPathList = new ArrayList<Path>();
        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        initLayerDraw();

    }

    public SimplePaint(Context context) {
        super(context);
        setup();
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();

    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();

    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();

    }

    public void initLayerDraw(){
        currentPaint = new Paint();
        currentPath = new Path();
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(10);
        currentPaint.setColor(currentColor.getColor());
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<mPaintList.size(); i++){
            canvas.drawPath(mPathList.get(i),mPaintList.get(i));
        }
        canvas.drawPath(currentPath, currentPaint);
        //canvas.save();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(event.getX(), event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                currentPath.lineTo(event.getX(), event.getY());
                mPaintList.add(currentPaint);
                mPathList.add(currentPath);
                initLayerDraw();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public void setColor(Color color) {
        currentColor.setColor(color.toArgb());
        currentPaint.setColor(color.toArgb());
    }
}
