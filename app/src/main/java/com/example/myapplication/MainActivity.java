package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.controller.NotaController;
import com.example.myapplication.modelo.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button button;
    EditText editText;
    ListView listView;
    NotaController notaController;
    ArrayList<Nota> listaNotas;
    ArrayAdapter<String> adapter;
    ArrayList<String> titulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        notaController = new NotaController(getApplicationContext());

        carregarLista();

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Nota nota = NotaController.listar().get(position);

            Intent intent = new Intent(this, ActivityExibirNota.class);
            intent.putExtra("id", nota.getId());
            startActivity(intent);
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }
    private void carregarLista() {
        ArrayList<Nota> notas = NotaController.listar();
        ArrayList<String> titulos = new ArrayList<>();

        for (Nota n : notas) {
            titulos.add(n.getTitulo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, titulos);

        listView.setAdapter(adapter);
    }
    public void novaNota(View v){
        Intent intent =  new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id nota",0);
        startActivity(intent);
    }

    /*public void carregarListagem() {
        ArrayList<String> titulos = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            titulos.add(titulo);
            cursor.moveToNext();
        }

        ArrayAdapter<String> titulosAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                titulos
        );

        listView.setAdapter(titulosAdapter);
    }*/
}


