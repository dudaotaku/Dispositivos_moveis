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
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ControllerPlaneta = new ControllerPlaneta;

        PlanetaAdapter = new PlanetaAdapter(this.R.layout.);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.Button);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );
        //Define um tratamento de click sobre o botão
        button.setOnClickListener( v ->{
            String nome = editText.getText().toString();
            nomes.add(nome);
            adapter.notifyDataSetChanged();
        });
        //Definer um tratamento para o evento de click sobre o item da lista
        listView.setOnItemClickListener(
                (parent,view, position, id)-> {
                    Toast.makeText(
                            getApplicationContext(),
                            "Elemento clicado"+nomes.get(position),
                            Toast.LENGTH_SHORT).show();

        });

        listView.setOnItemLongClickListener(
                (parent,view, position, id)-> {
                    nomes.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                }
        );
        listView.setAdapter(adapter);
    }
}