package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sing_up extends AppCompatActivity {

    private Button alrady, login, sing;
    private FirebaseAuth auth;
    private EditText singupname, singupemail, singuppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        auth = FirebaseAuth.getInstance();
        singupname = findViewById(R.id.editTextText);
        singupemail = findViewById(R.id.editTextTextEmailAddress);
        singuppassword = findViewById(R.id.editTextTextPassword);

        alrady = findViewById(R.id.button57);
        alrady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sing_up.this, MainActivity.class);
                startActivity(intent);
            }
        });

        login = findViewById(R.id.button58);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sing_up.this, com.example.app1.login.class);
                startActivity(intent);
            }
        });

        sing = findViewById(R.id.button59);
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = singupname.getText().toString().trim();
                String email = singupemail.getText().toString().trim();
                String password = singuppassword.getText().toString().trim();

                if (username.isEmpty()) {
                    singupname.setError("User name is required");
                    return;
                }
                if (email.isEmpty()) {
                    singupemail.setError("Email is required");
                    return;
                }
                if (password.isEmpty()) {
                    singuppassword.setError("Password is required");
                    return;
                }

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(sing_up.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(sing_up.this, com.example.app1.login.class));
                                } else {
                                    Toast.makeText(sing_up.this, "Signup failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
