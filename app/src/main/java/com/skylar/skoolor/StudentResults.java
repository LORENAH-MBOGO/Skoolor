package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentResults extends AppCompatActivity {
    SharedPreferences sp1,sp2,sp3;
    Button btnBack;
    TextView tvCon,tvSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_results);
        tvCon=findViewById(R.id.tvCon);
        tvSub=findViewById(R.id.tvSub);
        btnBack=findViewById(R.id.btnBack);
        tvCon.setText("");
        tvSub.setText("");
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        sp2=getSharedPreferences("f2",MODE_PRIVATE);
        String sub=sp1.getString("sub","");
        String con=sp2.getString("con","");
        tvSub.setText(sub);
        tvCon.setText(con);
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
