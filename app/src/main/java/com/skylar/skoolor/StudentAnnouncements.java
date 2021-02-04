package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentAnnouncements extends AppCompatActivity {
    SharedPreferences a1,a2,a3;
    Button btnBack;
    TextView tvCon,tvSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_announcements);
        tvSub=findViewById(R.id.tvSub);
        tvCon=findViewById(R.id.tvCon);

        btnBack=findViewById(R.id.btnBack);
        tvCon.setText("");
        tvSub.setText("");
        a1=getSharedPreferences("f1",MODE_PRIVATE);
        a2=getSharedPreferences("f2",MODE_PRIVATE);
        String sub=a1.getString("sub","");
        String con=a2.getString("con","");
        tvSub.setText(sub);
        tvCon.setText(con);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i =new Intent(StudentAnnouncements.this,StudentBoard.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    }