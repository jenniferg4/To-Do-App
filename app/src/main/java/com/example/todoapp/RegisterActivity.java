package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstName, lastName, email, password;
    private Button createAccount;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmailAddress1);
        password = findViewById(R.id.editTextPassword1);
        createAccount = findViewById(R.id.button2);

        createAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                String emailID = email.getText().toString();
                String pwd = password.getText().toString();

                if(first.isEmpty()) {
                    firstName.setError("Enter First Name");
                    firstName.requestFocus();
                } else if (last.isEmpty()) {
                    lastName.setError("Enter email");
                    lastName.requestFocus();
                } else if (emailID.isEmpty()) {
                    email.setError("Enter email");
                    email.requestFocus();
                } else if(pwd.isEmpty()){
                    password.setError("Enter Password");
                    password.requestFocus();
                } else if (! (first.isEmpty() && last.isEmpty() && emailID.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emailID, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Unsucessful", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(RegisterActivity.this, HomepageActivity.class));
                            }
                        }
                    });

                } else{
                    Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}