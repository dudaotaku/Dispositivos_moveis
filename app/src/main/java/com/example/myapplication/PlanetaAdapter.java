package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PlanetaAdapter extends Planeta{

    Context mContext;
    int layoutResorceId;
    View view;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects){
        super(context, resource, objects);
        this.mContext = context;
        this.layoutResorceId = resource;
    }

    @NonNull
    @Override
    public View getView (int position, @NonNull view convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(layoutResorceId,parent,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView =view.findViewById(R.id.)
    };

}
