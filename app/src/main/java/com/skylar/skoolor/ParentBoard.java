package com.skylar.skoolor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ParentBoard extends AppCompatActivity {

    TextView tvName;
    Button btnResult,btnMeeting,btnLogout;
    SharedPreferences sp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_board);

        tvName=findViewById(R.id.tvName);
        btnLogout=findViewById(R.id.btnLogout);
        btnMeeting=findViewById(R.id.btnMeeting);
        btnResult=findViewById(R.id.btnResult);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp5=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp5.getString("name","");
        tvName.setText("Welcome "+name+"'s Parent");

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentBoard.this, ParentResults.class);
                startActivity(i);
                finish();
            }
        });

        btnMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentBoard.this, ParentMeetings.class);
                startActivity(i);
                finish();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentBoard.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}































