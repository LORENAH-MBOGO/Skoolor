package com.skylar.skoolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TeacherResults extends AppCompatActivity {
    SharedPreferences r1, r2, r3;
    EditText rNote;
    Button btnSubmit, btnBack;
    Spinner rSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_results);
        btnBack = findViewById(R.id.btnBack);
        rSubject = findViewById(R.id.rSubject);
        rNote = findViewById(R.id.rNote);
        btnSubmit = findViewById(R.id.btnSubmit);
        r1 = getSharedPreferences("f1", MODE_PRIVATE);
        r2 = getSharedPreferences("f2", MODE_PRIVATE);
        final ArrayList<String> s = new ArrayList<>();
        s.add("DBMS");
        s.add("OS");
        s.add("Maths");
        s.add("COA");
        s.add("AOA");
        s.add("CN");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, s);
        rSubject.setAdapter(arrayAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id1 = rSubject.getSelectedItemPosition();
                final String sub = s.get(id1);
                final Editable con = rNote.getText();
                SharedPreferences.Editor editor = r1.edit();
                editor.putString("sub", sub);
                editor.apply();
                SharedPreferences.Editor editor1 = r2.edit();
                editor1.putString("con", String.valueOf(con));
                editor1.apply();
                Intent intent = new Intent(TeacherResults.this, TeacherBoard.class);
                startActivity(intent);
                Toast.makeText(TeacherResults.this, "Results Posted", Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeacherResults.this, TeacherBoard.class);
                startActivity(i);
                finish();
            }
        });

    }
}