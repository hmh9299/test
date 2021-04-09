package com.example.lab1_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    JobAdapter jobAdapter;
    List<ModelJob> jobList = new ArrayList<>();
    ListView listView;

    EditText et_name, et_salary, et_dateCreated;
    Spinner spinnerAnh;
    Button buttonThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView1);
        jobAdapter = new JobAdapter(this, R.layout.item_list, jobList);
        listView.setAdapter(jobAdapter);

        et_name = findViewById(R.id.et_TenNV);
        et_salary = findViewById(R.id.et_Luong);
        et_dateCreated = findViewById(R.id.et_Ngaythuchien);

        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);

        et_dateCreated.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,(view, year1, month1, dayOfMonth) -> {
                et_dateCreated.setText(dayOfMonth+"/"+month+"/"+year);
            },year,month,day);
            datePickerDialog.show();
        });

        spinnerAnh = findViewById(R.id.spinner_anh);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(R.drawable.anh1);
        integerList.add(R.drawable.anh2);
        integerList.add(R.drawable.anh3);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,integerList);
        spinnerAnh.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        buttonThem = findViewById(R.id.btnThem);
        buttonThem.setOnClickListener(v -> {
            int resImg = (int) spinnerAnh.getSelectedItem();
            String name = String.valueOf(et_name.getText());
            String salary = String.valueOf(et_salary.getText());
            String dateCreated = String.valueOf(et_dateCreated.getText());

            ModelJob modelJob = new ModelJob(resImg,name,salary,dateCreated);
            jobList.add(modelJob);
            jobAdapter.notifyDataSetChanged();
        });




    }
}