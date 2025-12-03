package com.example.myapplication.controller;

import android.content.Context;

import com.example.myapplication.modelo.Nota;
import com.example.myapplication.modelo.NotaDao;

import java.util.ArrayList;

public class NotaController {
    Context mContext;
    static NotaDao notaDao;
    public NotaController(Context c) {
        mContext = c;
        notaDao = new NotaDao(c);
    }

    public Nota cadastrarNovaNota(Nota n){
        return notaDao.inserirNota(n);

    }

    public ArrayList<Nota> listarNotas(){
        return notaDao.listarNotas();
    }

    public void atualizarNota(Nota n){
        notaDao.atualizarNota(n);
    }

    public void deletarNota(int id){
        notaDao.deletarNota(id);
    }

    public Nota buscar(int id){ return notaDao.buscarPorId(id); }

    public static ArrayList<Nota> listar(){ return notaDao.listarNotas(); }
}
