package com.example.app1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sustainable_practices_main extends AppCompatActivity {

    private Button sp1;
    private Button sp2;
    private Button sp3;
    private Button back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sustainable_practices_main);

        sp1 = findViewById(R.id.button39);
        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sustainable_practices_main.this, sustainable_practices_1.class);
                startActivity(intent);
            }
        });

        sp2 = findViewById(R.id.button40);
        sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sustainable_practices_main.this, sustainable_practices_2.class);
                startActivity(intent);
            }
        });

        sp3 = findViewById(R.id.button41);
        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sustainable_practices_main.this, sustainable_practices_3.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.button44);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sustainable_practices_main.this, awareness.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}