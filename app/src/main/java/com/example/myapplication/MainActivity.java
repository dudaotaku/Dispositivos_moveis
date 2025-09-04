package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText edpeso,edaltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.Button);
        edpeso=findViewById(R.id.EdPeso);
        edaltura=findViewById(R.id.EdAltura);
        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            //passar os dados para o bundle

            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());

            intent.putExtra("Altura", altura);
            intent.putExtra("Peso", peso);

            startActivity(intent);
        });

    }
}