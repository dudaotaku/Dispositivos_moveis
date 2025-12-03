package com.example.myapplication.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase database;

    public NotaDao(Context c) {
        database = c.openOrCreateDatabase("dbNotas", c.MODE_PRIVATE, null);

        // CORREÇÃO: adicionando IF NOT EXISTS
        database.execSQL(
                "CREATE TABLE IF NOT EXISTS notas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "titulo VARCHAR, " +
                        "texto VARCHAR)"
        );
    }

    public Nota inserirNota(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo",n.getTitulo());
        contentValues.put("texto", n.getTexto());
        int i = (int) database.insert("notas",null,contentValues);
        n.setId(i);
        return n;
    }

    public void atualizarNota(Nota n){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        database.update("notas", contentValues, "id=?", new String[]{String.valueOf(n.getId())});
    }

    public void deletarNota(int id){
        database.delete("notas", "id=?", new String[]{String.valueOf(id)});
    }

    public Nota buscarPorId(int id){
        Cursor c = database.rawQuery("SELECT * FROM notas WHERE id=?", new String[]{String.valueOf(id)});
        if(c.moveToFirst()){
            return new Nota(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2)
            );
        }
        return null;
    }

    public ArrayList<Nota> listarNotas(){
        ArrayList<Nota> lista = new ArrayList<>();
        Cursor c = database.rawQuery("SELECT * FROM notas", null);
        while (c.moveToNext()){
            lista.add(new Nota(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2)
            ));
        }
        return lista;
    }
}

