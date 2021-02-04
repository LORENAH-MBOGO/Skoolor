package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentResults extends AppCompatActivity {
    SharedPreferences r1,r2,r3;
    Button btnBack;
    TextView rCon,rSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_results);
        rCon=findViewById(R.id.rCon);
        rSub=findViewById(R.id.rSub);
        btnBack=findViewById(R.id.btnBack);
        rCon.setText("");
        rSub.setText("");
        r1=getSharedPreferences("f1",MODE_PRIVATE);
        r2=getSharedPreferences("f2",MODE_PRIVATE);
        String sub=r1.getString("sub","");
        String con=r2.getString("con","");
        rCon.setText(sub);
        rSub.setText(con);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(StudentResults.this,StudentBoard.class);
                startActivity(i);
                finish();
            }
        });
    }
}
