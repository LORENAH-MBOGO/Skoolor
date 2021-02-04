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

public class ParentInquiries extends AppCompatActivity {
    SharedPreferences sp1, sp2, sp3;
    EditText inqNote;
    Button btnSubmit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_inquiries);
        btnBack = findViewById(R.id.btnBack);

        inqNote = findViewById(R.id.inqNote);
        btnSubmit = findViewById(R.id.btnSubmit);
        sp1 = getSharedPreferences("f1", MODE_PRIVATE);
        sp2 = getSharedPreferences("f2", MODE_PRIVATE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Editable con = inqNote.getText();
                SharedPreferences.Editor editor = sp1.edit();
                editor.apply();
                SharedPreferences.Editor editor1 = sp2.edit();
                editor1.putString("con", String.valueOf(con));
                editor1.apply();
                Intent intent = new Intent(ParentInquiries.this, ParentBoard.class);
                startActivity(intent);
                Toast.makeText(ParentInquiries.this, "Feedback Posted", Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ParentInquiries.this, ParentBoard.class);
                startActivity(i);
                finish();
            }
        });

    }
}