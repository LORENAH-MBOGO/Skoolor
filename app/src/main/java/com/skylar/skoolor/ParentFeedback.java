package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParentFeedback extends AppCompatActivity {
    SharedPreferences sp1,sp2,sp3;
    Button btnBack;
    TextView inqName,inqSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_feedback);
        inqName=findViewById(R.id.inqName);
        inqSelect=findViewById(R.id.inqSelect);
        btnBack=findViewById(R.id.btnBack);
        inqSelect.setText("");
        inqName.setText("");
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        sp2=getSharedPreferences("f2",MODE_PRIVATE);
        String sub=sp1.getString("sub","");
        String con=sp2.getString("con","");
        inqSelect.setText(sub);
        inqName.setText(con);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ParentFeedback.this,TeacherBoard.class);
                startActivity(i);
                finish();
            }
        });
    }
}