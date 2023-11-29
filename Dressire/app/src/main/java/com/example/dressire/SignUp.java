package com.example.dressire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText email, password;
    private Button signup;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.isEmpty()){
                    email.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    password.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignUp.this, "SignUp Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, MainActivity.class));
                            }else{
                                Toast.makeText(SignUp.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });

    }
}