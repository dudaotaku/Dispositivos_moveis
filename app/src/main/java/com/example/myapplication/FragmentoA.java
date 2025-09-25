package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentoA extends Fragment {

    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle b = getArguments();
        String s = b.getString("msg");

        View v = inflater.inflate(R.layout.fragment_fragmento_a, container, false);
        tv=v.findViewById(R.id.textView);
        tv.setText(s);
        return v;
    }
}