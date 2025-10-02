package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMCResultado extends AppCompatActivity {


    TextView tvPeso, tvAltura, tvImc, tvnome;
    Button button;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcresultado);
        button = findViewById(R.id.buttonVoltar);

        button.setOnClickListener(v -> {
            finish();
        });

        tvImc=findViewById(R.id.tvImc);

        imageView=findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        float peso= bundle.getFloat("Peso");
        float altura = bundle.getFloat("Altura");
        String nome = bundle.getString("Nome");

        float imc = (peso)/(altura*altura);

        /*tvPeso.setText(Float.toString(peso));
        tvAltura.setText(Float.toString(altura));
        tvnome.setText(String.valueOf(nome));*/
        tvImc.setText(Float.toString(imc));

        if(imc<18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if (imc>18.5) {
            imageView.setImageResource(R.drawable.normal);
        } else if (imc>25 && imc<29.9) {
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc>30 && imc<34.9) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc>35 && imc<39.9) {
            imageView.setImageResource(R.drawable.obesidade2);
        }else if(imc>40){
            imageView.setImageResource(R.drawable.obesidade3);
        }

    }


    }