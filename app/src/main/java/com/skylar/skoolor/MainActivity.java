package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
                Intent i= new Intent(MainActivity.this,StudentActivity1.class);
                startActivity(i);
                finish();
            }
        });
        iTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,TeacherActivity1.class);
                startActivity(i);
                finish();
            }
        });

        iParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,ParentActivity1.class);
                startActivity(i);
                finish();

            }
        });

    }
}

    }
}