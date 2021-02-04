package com.skylar.skoolor.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skylar.skoolor.R;

public class TeacherParent extends AppCompatActivity {

    EditText etDate, etTime, etVenue;
    Button btnSubmit, btnBack;
    SharedPreferences sp7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_parent);

        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etVenue = findViewById(R.id.etVenue);
        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnSubmit);
        sp7 = getSharedPreferences("f4", MODE_PRIVATE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s1 = etDate.getText();
                Editable s2 = etTime.getText();
                Editable s3 = etVenue.getText();
                String s = "Meeting will be held on " + s1 + ", " + s2 + " in school's " + s3;
                SharedPreferences.Editor editor = sp7.edit();
                editor.putString("n1", s);
                editor.apply();
                Toast.makeText(TeacherParent.this, "Notification submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TeacherParent.this, TeacherBoard.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeacherParent.this, TeacherBoard.class);
                startActivity(i);
                finish();

            }
        });
    }
}
