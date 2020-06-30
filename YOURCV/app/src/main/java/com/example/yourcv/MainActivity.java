package com.example.yourcv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   private TextView tvDate;
   private EditText etDate;
   private DatePickerDialog.OnDateSetListener setListener;
   private RadioGroup group;
   private RadioButton female;
   private RadioButton male;
   private Spinner spn2;
   private String gender;
   private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username = findViewById(R.id.username);
        group = findViewById(R.id.group);
        female = findViewById(R.id.Female);
        male = findViewById(R.id.Male);
        spn2 = findViewById(R.id.spn2);
        email = findViewById(R.id.email);
        final EditText p = findViewById(R.id.Phone);

        // to activate radio group
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId() == findViewById(R.id.Male).getId())
                   gender="Male";
               else
                   gender="Female";

            }
        });

        //Calender
        tvDate = findViewById(R.id.tv_date);
        etDate = findViewById(R.id.et_date);
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                tvDate.setText(date); }
        };
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });

        // activate button next
        Button next = findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("username1", username.getText().toString());
                i.putExtra("gender1", gender);
                i.putExtra("job",spn2.getSelectedItem().toString());
                i.putExtra("ubirth1", etDate.getText().toString());
                i.putExtra("email1", email.getText().toString());
                i.putExtra("num", p.getText().toString());

                startActivity(i);
            }
        });
        // make spinner for job item
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.job, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn2.setAdapter(adapter);
        spn2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}