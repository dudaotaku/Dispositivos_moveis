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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class IMCResultado extends AppCompatActivity {



    Button button, buttonImc,buttonInfo;
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

        fragmento_imc fragmento_imc = new fragmento_imc();
        fragmento_info fragmento_info = new fragmento_info();

        FragmentManager fragmentManager = getSupportFragmentManager();

        Bundle bundle = getIntent().getExtras();

        fragmento_info.setArguments(bundle);
        fragmento_imc.setArguments(bundle);

        buttonInfo = findViewById(R.id.buttonInfo);
        buttonInfo.setOnClickListener(v -> {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,fragmento_info);

            fragmentTransaction.commit();
        });

        buttonImc = findViewById(R.id.buttonImc);
        buttonImc.setOnClickListener(v -> {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout2,fragmento_imc);

            fragmentTransaction.commit();
        });














    }


    }