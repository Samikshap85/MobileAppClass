package com.example.becomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {
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

            ;

        });
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
}