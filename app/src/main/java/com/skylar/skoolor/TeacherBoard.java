package com.skylar.skoolor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherBoard extends AppCompatActivity {
    SharedPreferences sp;
    TextView tvName;
    Button btnAnnouncement,btnParent,btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_board);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp.getString("name","");
        tvName=findViewById(R.id.tvName);
        btnAnnouncement=findViewById(R.id.btnAnnouncement);
        btnLogout=findViewById(R.id.btnLogout);
        btnParent=findViewById(R.id.btnParent);
        tvName.setText("Welcome "+name);
        btnAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherBoard.this, TeacherAnnnouncements.class);
                startActivity(i);
                finish();

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherBoard.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherBoard.this, TeacherParent.class);
                startActivity(i);
                finish();

            }
        });


    }
}