package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.controller.NotaController;
import com.example.myapplication.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {

    Button salvar;
    Button deletar;
    NotaController notaController;
    EditText titulo;
    EditText texto;
    int idNota = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibir_nota);
        notaController = new NotaController(getApplicationContext());
        titulo = findViewById(R.id.titulo);
        texto = findViewById(R.id.texto);
        salvar = findViewById(R.id.salvar);
        deletar = findViewById(R.id.deletar);

        idNota = getIntent().getIntExtra("id", 0);

        if(idNota > 0){
            Nota n = notaController.buscar(idNota);
            titulo.setText(n.getTitulo());
            texto.setText(n.getTexto());
            deletar.setVisibility(View.VISIBLE);
        }
    }

    public void salvarNota(View v){
        if(idNota == 0){
            notaController.cadastrarNovaNota(new Nota(
                    titulo.getText().toString(),
                    texto.getText().toString()
            ));
        } else {
            notaController.atualizarNota(new Nota(
                    idNota,
                    titulo.getText().toString(),
                    texto.getText().toString()
            ));
        }

        Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void deletarNota(View v){
        notaController.deletarNota(idNota);
        Toast.makeText(this, "Nota deletada!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
