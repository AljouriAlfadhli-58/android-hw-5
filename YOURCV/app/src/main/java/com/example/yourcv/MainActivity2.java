package com.example.yourcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity2 extends AppCompatActivity {

    private TextView Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView n = findViewById(R.id.txt1);
        Gender = findViewById(R.id.Gender);
        TextView j = findViewById(R.id.txt3);
        TextView b = findViewById(R.id.txt4);
        TextView e = findViewById(R.id.email);
        TextView p = findViewById(R.id.txt6);
        ImageView g = findViewById(R.id.imageView1);

        Bundle extras = getIntent().getExtras();
        n.setText(extras.getString("username1"));
        Gender.setText(extras.getString("gender1"));
        j.setText(extras.getString("job"));
        b.setText(extras.getString("ubirth1"));
        e.setText(extras.getString("email1"));
        p.setText(extras.getString("num"));
        String zz=extras.getString("job");
        if(zz.equals("Engineer"))
            g.setBackgroundResource(R.drawable.eng_icon);
        else if (zz.equals("Doctor"))
            g.setBackgroundResource(R.drawable.doctor_icon);
        else if (zz.equals("Teacher"))
            g.setBackgroundResource(R.drawable.teacher_icon);
        else if (zz.equals("Student"))
            g.setBackgroundResource(R.drawable.student_icon);
        else
            g.setBackgroundResource(R.drawable.doctor_icon);


    }


}