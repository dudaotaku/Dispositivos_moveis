package com.example.myapplication;

import android.app.LocaleManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("Ciclo vida","onCreat");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo vida","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo vida","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo vida","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo vida","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo vida","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo vida","onDestroy");
    }


}