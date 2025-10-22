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
        float x = event.getX();
        float y = event.getY();
        Log.d("position "," X " + x + " y " + y + " Event " + event.getAction());

        if(x < 0){
            setBackgroundColor(Color.RED);
        }else{
            setBackgroundColor(Color.GREEN);
        }


        return super.onTouchEvent(event);
    }
}
