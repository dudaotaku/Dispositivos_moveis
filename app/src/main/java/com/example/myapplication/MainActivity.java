package com.example.myapplication;

import android.app.LocaleManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {

    SimplePaint simplePaint;
    ImageView imColorPicker;
    Button linha;
    Button circulo;
    Button quadrado;
    Button limpar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       simplePaint = findViewById(R.id.simplePaint);
       linha = findViewById(R.id.linha);
       circulo = findViewById(R.id.circulo);
       quadrado = findViewById(R.id.quadrado);
       limpar = findViewById(R.id.limpar);
       imColorPicker = findViewById(R.id.imColorPicker);
       imColorPicker.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               colorPickerSelectColor();
           }
       });
        linha.setOnClickListener(v -> simplePaint.botaoSelecionado = 1);
        circulo.setOnClickListener(v -> simplePaint.botaoSelecionado = 2);
        quadrado.setOnClickListener(v -> simplePaint.botaoSelecionado = 3);
        limpar.setOnClickListener(v -> {
            simplePaint.limparPaint();
        });
    }
    public void colorPickerSelectColor(){

            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Confirma",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setColor(envelope);
                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();

    }



    public void setColor(ColorEnvelope envelope){

        simplePaint.setColor(Color.valueOf(envelope.getColor()));
        imColorPicker.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
    }
}