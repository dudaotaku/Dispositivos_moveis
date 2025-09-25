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
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        findViewById(R.id.buttonA).setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Hello =)");
                fragmentoA.setArguments(bundle);

                fragmentTransaction.replace(R.id.frameLayout,fragmentoA);
                fragmentTransaction.commit();
        });

        findViewById(R.id.buttonB).setOnClickListener(v -> {
            fragmentTransaction.replace(R.id.frameLayout,fragmentoB);
            fragmentTransaction.commit();
        });

    }
}