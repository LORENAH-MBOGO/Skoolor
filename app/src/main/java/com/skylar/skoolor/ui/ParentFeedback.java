package com.skylar.skoolor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skylar.skoolor.R;

public class ParentFeedback extends AppCompatActivity {

    TextView pContext;
    SharedPreferences s7;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_feedback);
        pContext=findViewById(R.id.pContext);
        btnBack=findViewById(R.id.btnBack);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        s7=getSharedPreferences("f4",MODE_PRIVATE);
        String name=s7.getString("n1","");
        pContext.setText(name);
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