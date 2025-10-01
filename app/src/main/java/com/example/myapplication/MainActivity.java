package com.example.myapplication;

import android.app.LocaleManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        LocaleManager lm;
        getString(R.string.Hello);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FragmentoA fragmentoA = new FragmentoA();
        FragmentoB fragmentoB = new FragmentoB();

        FragmentManager fragmentManager = getSupportFragmentManager();


        findViewById(R.id.buttonEntrar).setOnClickListener(v -> {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Bem vindo =)");
                fragmentoA.setArguments(bundle);

                fragmentTransaction.replace(R.id.frameLayout,fragmentoA);
                fragmentTransaction.commit();
        });

        findViewById(R.id.buttonCadastar).setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,fragmentoB);
            fragmentTransaction.commit();
        });

    }
}