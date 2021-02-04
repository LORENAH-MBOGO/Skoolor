package com.skylar.skoolor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skylar.skoolor.R;

public class MainActivity extends AppCompatActivity {
    ImageButton iStudent, iParent, iTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iStudent = findViewById(R.id.iStudent);
        iParent=findViewById(R.id.iParent);
        iTeacher=findViewById(R.id.iTeacher);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        iStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,StudentLogin.class);
                startActivity(i);
                finish();
            }
        });
        iTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,TeacherLogin.class);
                startActivity(i);
                finish();
            }
        });

        iParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,ParentLogin.class);
                startActivity(i);
                finish();

            }
        });

    }
}

