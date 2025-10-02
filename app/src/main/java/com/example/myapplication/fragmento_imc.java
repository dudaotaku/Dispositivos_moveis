package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class fragmento_imc extends Fragment {

    TextView tvImc;
    ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View s = inflater.inflate(R.layout.fragment_fragmento_imc, container, false);
        tvImc=s.findViewById(R.id.tvImc);
        imageView=s.findViewById(R.id.imageView);
        Bundle bun = this.getArguments();
        float peso= bun.getFloat("Peso");
        float altura = bun.getFloat("Altura");
        float imc = (peso)/(altura*altura);

        tvImc.setText(Float.toString(imc));

        if(imc<18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
        } else if (imc>18.5) {
            imageView.setImageResource(R.drawable.normal);
        } else if (imc>25 && imc<29.9) {
            imageView.setImageResource(R.drawable.sobrepeso);
        } else if (imc>30 && imc<34.9) {
            imageView.setImageResource(R.drawable.obesidade1);
        } else if (imc>35 && imc<39.9) {
            imageView.setImageResource(R.drawable.obesidade2);
        }else if(imc>40){
            imageView.setImageResource(R.drawable.obesidade3);
        }
        return s;
    }
}