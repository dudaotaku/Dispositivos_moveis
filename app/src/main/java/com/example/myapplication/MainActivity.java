package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.LocaleManager;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> nomes;
    EditText editText;
    ControllerPlaneta controllerPlaneta;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controllerPlaneta = new ControllerPlaneta();

        PlanetaAdapter adapter = new PlanetaAdapter(this,R.layout.item_listagem, controllerPlaneta.getPlanetas());
        listView = findViewById(R.id.listView);
        button=findViewById(R.id.Button);

        //Define um tratamento para o evento de click sobre o bottão
        button.setOnClickListener(v -> {

        });
        //Definir um tratamento para o evento de click sobre o item da lista
        listView.setOnItemClickListener((parent, view, position, id) -> {});
        listView.setAdapter(adapter);
    }
}