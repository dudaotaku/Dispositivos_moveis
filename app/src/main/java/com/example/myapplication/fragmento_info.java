package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragmento_info extends Fragment {

    TextView tvpeso,tvnome,tvaltura;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_fragmento_info, container, false);
        tvaltura = v.findViewById(R.id.tvaltura);
        tvnome = v.findViewById(R.id.tvnome);
        tvpeso = v.findViewById(R.id.tvpeso);
        Bundle b =this.getArguments();
        String s = b.getString("nome");

        float peso= b.getFloat("Peso");
        float altura = b.getFloat("Altura");
        String nome = b.getString("Nome");
        tvaltura.setText(Float.toString(altura));
        tvpeso.setText(Float.toString(peso));
        tvnome.setText(s);


        return v;
    }
}