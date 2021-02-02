package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentBoard extends AppCompatActivity {
    SharedPreferences sp,sp4;
    TextView tvName;
    Button btnAnnouncement,btnAssignment,btnResult,btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_board);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp.getString("name","");

        tvName=findViewById(R.id.tvName);
        btnAnnouncement=findViewById(R.id.btnAnnouncement);
        btnAssignment=findViewById(R.id.btnAssignment);
        btnLogout=findViewById(R.id.btnLogout);
        btnResult=findViewById(R.id.btnResult);
        tvName.setText("Welcome "+name);
        btnAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StudentBoard.this,StudentAnnouncements.class);
                startActivity(i);
                finish();

            }
        });

        btnAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StudentBoard.this,StudentAssignments.class);
                startActivity(i);
                finish();

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StudentBoard.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentBoard.this,StudentA.class);
                startActivity(i);
                finish();
            }
        });


    }
}