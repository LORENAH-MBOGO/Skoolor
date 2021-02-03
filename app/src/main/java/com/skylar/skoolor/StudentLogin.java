package com.skylar.skoolor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentLogin extends AppCompatActivity {

    Button btnLogin, btnNot, btnRegister,btnBack ;
    EditText etPhone , etUsername, etPassword , etEmail,etRoll;
    FirebaseDatabase database;
    DatabaseReference DbStudents;
    SharedPreferences sp,sp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DbStudents = FirebaseDatabase
                .getInstance()
                .getReference("students");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        etRoll=findViewById(R.id.etRoll);
        btnBack=findViewById(R.id.btnBack);
        btnLogin=findViewById(R.id.btnLogin);
        btnNot=findViewById(R.id.btnNot);
        etPhone=findViewById(R.id.etPhone);
        btnRegister=findViewById(R.id.btnRegister);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        etEmail=findViewById(R.id.etEmail);

        sp=getSharedPreferences("f1",MODE_PRIVATE);
        sp4=getSharedPreferences("f4",MODE_PRIVATE);

        btnNot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                etPhone.setVisibility(0);
                btnLogin.setVisibility(-1);
                btnRegister.setVisibility(0);
                btnNot.setVisibility(-1);
                etEmail.setVisibility(0);
                etRoll.setVisibility(0);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = etEmail.getText().toString();
                String pw = etPassword.getText().toString();
                String un = etUsername.getText().toString();
                String pn = etPhone.getText().toString();
                String rn = etRoll.getText().toString();
                if (un.length()<2){
                    etUsername.setError("Please enter correct username");
                    etUsername.setText("");
                    etUsername.requestFocus();
                }
                else if (!em.contains("@ves.ac.in")){
                    etEmail.setError("Please use college email Id");
                    etEmail.setText("");
                    etEmail.requestFocus();
                }
                else if (pw.length()<3){
                    etPassword.setError("please enter atleast 3 characters");
                    etPassword.setText("");
                    etPassword.requestFocus();
                }
                else if (pn.length()!=10){
                    etPhone.setError("please enter valid phone  number");
                    etPhone.setText("");
                    etPhone.requestFocus();
                }
                else{
                    Students s = new Students( un, pw, em, pn,rn);
                    DbStudents.child(un).setValue(s);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("name",un);
                    editor.commit();
                    SharedPreferences.Editor editor1=sp4.edit();
                    editor1.putString("name",rn);
                    editor1.commit();

                    Intent i= new Intent(StudentLogin.this,StudentBoard.class);
                    startActivity(i);
                    Toast.makeText(StudentLogin.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    finish();
                }


                /*if (!TextUtils.isEmpty(un) && !TextUtils.isEmpty(pw) && !TextUtils.isEmpty(em) && pn.length()==10 ) {
                    //String id = DbStudents.push().getKey();
                    //Toast.makeText(StudentActivity1.this, "added", Toast.LENGTH_SHORT).show();
                    }
                else {
                    Toast.makeText(StudentActivity1.this, "error", Toast.LENGTH_SHORT).show();
                }*/

            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pw = etPassword.getText().toString();
                String un = etUsername.getText().toString();
                signIn(un,pw);
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StudentLogin.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
    private void signIn(final String username, final String password){


        DbStudents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //s.clear();
                int a=0;
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Students data=d.getValue(Students.class);
                    if (data.getStUsername().equals(username))
                        if (data.getStPassword().equals(password)) {
                            a = 1;
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("name", username);
                            editor.commit();
                            Intent i = new Intent(StudentLogin.this, StudentBoard.class);
                            startActivity(i);
                            Toast.makeText(StudentLogin.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        }
                    //  s.add(data);

                }
                if(a==0){
                    Toast.makeText(StudentLogin.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }







}
