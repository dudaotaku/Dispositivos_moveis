package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMCResultado extends AppCompatActivity {


    TextView tvPeso, tvAltura, tvImc;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcresultado);
        tvPeso=findViewById(R.id.tvPeso);
        tvAltura=findViewById(R.id.tvAltura);
        tvImc=findViewById(R.id.tvImc);

        imageView=findViewById(R.id.imageView);

        Bundle b = getIntent().getExtras();

        float peso=b.getFloat("peso");
        float altura = b.getFloat("altura");

        float imc = (peso)/(altura*altura);

        tvPeso.setText(Float.toString(peso));
        tvAltura.setText(Float.toString(altura));
        tvImc.setText(Float.toString(imc));

        if(imc);
    }
}