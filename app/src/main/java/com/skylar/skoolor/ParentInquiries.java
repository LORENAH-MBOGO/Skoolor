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
    EditText mSub, mChild, mFeed;
    Button btnSubmit, btnBack;
    SharedPreferences s7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_inquiries);
        mChild = findViewById(R.id.mChild);
        mFeed = findViewById(R.id.mFeed);
        mSub = findViewById(R.id.mSub);
        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnSubmit);
        s7 = getSharedPreferences("f4", MODE_PRIVATE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s1 = mChild.getText();
                Editable s2 = mSub.getText();
                Editable s3 = mFeed.getText();
                String s = "This is to inform you about " + s1 + ", concerning " + s2+ " : " + s3;
                SharedPreferences.Editor editor = s7.edit();
                editor.putString("n1", s);
                editor.apply();
                Toast.makeText(ParentInquiries.this, "Feedback submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ParentInquiries.this, ParentBoard.class);
                startActivity(intent);
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
