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
import android.widget.Button;

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
    public int botaoSelecionado = 1;

    float startX, startY;

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
        float x = event.getX();
        float y = event.getY();

        switch (botaoSelecionado) {

            case 1:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        currentPath.moveTo(x, y);
                        startX = x;
                        startY = y;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(x, y);
                        break;

                    case MotionEvent.ACTION_UP:
                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;

            case 2:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = x;
                        startY = y;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float radiusMove = (float) Math.sqrt(
                                Math.pow(x - startX, 2) +
                                        Math.pow(y - startY, 2)
                        );
                        currentPath.reset();
                        currentPath.addCircle(startX, startY, radiusMove, Path.Direction.CW);
                        break;

                    case MotionEvent.ACTION_UP:
                        float radiusEnd = (float) Math.sqrt(
                                Math.pow(x - startX, 2) +
                                        Math.pow(y - startY, 2)
                        );
                        currentPath.reset();
                        currentPath.addCircle(startX, startY, radiusEnd, Path.Direction.CW);

                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;

            case 3:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = x;
                        startY = y;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float left = Math.min(startX, x);
                        float top = Math.min(startY, y);
                        float right = Math.max(startX, x);
                        float bottom = Math.max(startY, y);

                        currentPath.reset();
                        currentPath.addRect(left, top, right, bottom, Path.Direction.CW);
                        break;

                    case MotionEvent.ACTION_UP:
                        float L = Math.min(startX, x);
                        float T = Math.min(startY, y);
                        float R = Math.max(startX, x);
                        float B = Math.max(startY, y);

                        currentPath.reset();
                        currentPath.addRect(L, T, R, B, Path.Direction.CW);

                        mPaintList.add(currentPaint);
                        mPathList.add(currentPath);
                        initLayerDraw();
                        break;
                }
                break;
        }

        invalidate();
        return true;

    }

    public void limparPaint(){
        mPaintList.clear();
        mPathList.clear();
        currentPath.reset();
        invalidate();
    }

    public void setColor(Color color) {
        currentColor.setColor(color.toArgb());
        currentPaint.setColor(color.toArgb());
    }
}
