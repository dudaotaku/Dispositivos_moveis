package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    Context mContext;
    int mResourceLayout;
    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResourceLayout,parent,false);


        ImageView imageView = convertView.findViewById(R.id.logo);
        TextView tvAppname = convertView.findViewById(R.id.tvNome);

        ApplicationInfo appInfo = getItem(position);

        if(appInfo == null){
            return convertView;
        }
        imageView.setImageDrawable(appInfo.loadIcon(mContext.getPackageManager()));
        tvAppname.setText(appInfo.loadLabel(mContext.getPackageManager()).toString());


       // imageView.setImageResource(appInfo.logo);
        //tvAppname.setText(appInfo.loadLabel(mContext.getPackageManager()).toString());


        convertView.setOnClickListener(v -> {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(appInfo.packageName);
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                Log.e("MainActivity", "Não foi possivel iniciar o aplicativo" + appInfo.packageName);
            }
        });

        return convertView;
       // return super.getView(position, convertView, parent);
    }
}
