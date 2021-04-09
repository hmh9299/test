package com.example.lab1_bai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class JobAdapter extends ArrayAdapter {
    List<ModelJob> jobList;
    ArrayAdapter arrayAdapter;

    public JobAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.jobList = objects;
        this.arrayAdapter = this;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        ModelJob modelJob = jobList.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView name = convertView.findViewById(R.id.item_name);
        TextView salary = convertView.findViewById(R.id.item_luong);
        TextView dateCreated = convertView.findViewById(R.id.item_ngaytao);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(v -> {
            jobList.remove(position);
            notifyDataSetChanged();
        });
        imageView.setImageResource(modelJob.getImage());
        name.setText(modelJob.getName());
        salary.setText(modelJob.getSalary());
        dateCreated.setText(modelJob.getDateCreated());

        return convertView;
    }
}
