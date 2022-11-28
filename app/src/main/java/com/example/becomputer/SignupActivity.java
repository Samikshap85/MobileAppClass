package com.example.becomputer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {
   //variable declaration
   private String username, fullname, email, password;
    private EditText etUsername, etFullname, etEmail, etPassword;
    private Button btSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btSignup = findViewById(R.id.btSignup);
        etUsername = findViewById(R.id.etUsername);
        etFullname = findViewById(R.id.etFullname);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (meroValidation()) {

                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Please enter details correctly", Toast.LENGTH_SHORT).show();
                }
            }



        });
        setAppBar();
    }

    protected void setAppBar(){
        if (getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true); //creating an app bar i.e back buttom
        }

    }

    private boolean meroValidation() {
        username = etUsername.getText().toString();
        fullname = etFullname.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError("Username cannot be blank");
            return false;
        }
        if (fullname.isEmpty()) {
            etFullname.setError("Fullname cannot be blank");
            return false;

        }
        if (email.isEmpty()) {
            etEmail.setError("Email cannot be blanked");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password cannot be blank");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //button select huda k garne vani kura yeta declare garinxa , menu iteam ley chai tyo iteam ko id dinxa
        if(item.getItemId()== android.R.id.home)//id of back button (given by android)
        {
           onBackPressed(); //backbutton run hunxa
        }
        return super.onOptionsItemSelected(item);
    }
}