package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TinderButton extends androidx.appcompat.widget.AppCompatButton {

    int ColorR = 120;
    int ColorG = 120;
    int ColorB = 120;

    int x0;
    int y0;

    public TinderButton(@NonNull Context context) {
        super(context);
    }

    public TinderButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TinderButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setText("Tinder Button");
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();
        Log.d("position "," X " + x + " y " + y + " Event " + event.getAction());

        /*if(x < 0){
            setBackgroundColor(Color.RED);
        }else{
            setBackgroundColor(Color.GREEN);
        }
*/
        if(event.getAction() == MotionEvent.ACTION_DOWN){
           x0 = (int)x;
           y0 = (int)y;
        }
        int dx = (int)(x -x0);
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            ColorR = Math.min(255,Math.max(0,120-dx/5));
            ColorG = Math.min(255,Math.max(0,120+dx/5));
            ColorB = 120;
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            ColorR = 120;
            ColorG = 120;
            ColorB = 120;
        }
        this.setBackgroundColor(Color.rgb(ColorB,ColorG,ColorR));

        return super.onTouchEvent(event);
    }
}
