package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class marine_conservation extends AppCompatActivity {
    private Button sa;
    private Button bw;
    private Button cl;
    private Button sy;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_marine_conservation);

        sa = findViewById(R.id.button31);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(marine_conservation.this, small_atlantic.class);
                startActivity(intent);
            }
        });

        bw = findViewById(R.id.button32);
        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(marine_conservation.this, bowhead_whales.class);
                startActivity(intent);
            }
        });

        sy = findViewById(R.id.button33);
        sy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(marine_conservation.this, Super_year.class);
                startActivity(intent);
            }
        });

        cl = findViewById(R.id.button34);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(marine_conservation.this, Countries_launch.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.button46);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(marine_conservation.this, awareness.class);
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